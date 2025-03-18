package day3;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part1 {
    public static void main (String[] args) {

        InputStream inputStream = Day3Part1.class.getClassLoader().getResourceAsStream("day3input.txt");
        int results = 0;

        if (inputStream != null) {

            Scanner scanner = new Scanner(inputStream);
            Pattern mulPattern = Pattern.compile("mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)");

            while (scanner.hasNextLine()) {

                String mulLine = scanner.nextLine();
                Matcher mulMatcher = mulPattern.matcher(mulLine);

                while (mulMatcher.find()) {
                    results += Integer.parseInt(mulMatcher.group(1)) * Integer.parseInt(mulMatcher.group(2));
                }
            }

            System.out.println("Results are: " + results);

        } else System.out.println("File not found!");

    }
}
