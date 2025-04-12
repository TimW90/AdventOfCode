package day3;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.InputHandler.handleInputStream;

public class Day3Part2 {
    public static void main(String[] args) {

        InputStream inputStream = handleInputStream("2025/day3input.txt");
        int results = 0;

        Scanner scanner = new Scanner(inputStream);
        Pattern mulPattern = Pattern.compile("mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)|do\\(\\)|don't\\(\\)");

        while (scanner.hasNextLine()) {

            String mulLine = scanner.nextLine();
            Matcher mulMatcher = mulPattern.matcher(mulLine);
            boolean enable = true;

            while (mulMatcher.find()) {

                if (!enable && mulMatcher.group().equals("do()")) {
                    System.out.println(mulMatcher.group());
                    enable = true;
                }
                if (enable && mulMatcher.group().equals("don't()")) {
                    System.out.println(mulMatcher.group());
                    enable = false;
                }
                if (enable && mulMatcher.group().matches("mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)")) {
                    System.out.println(mulMatcher.group());
                    results += Integer.parseInt(mulMatcher.group(1)) * Integer.parseInt(mulMatcher.group(2));
                }
            }
        }

        System.out.println("Results are: " + results);


    }
}