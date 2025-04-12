package adventofcode2015.day2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.InputHandler.handleInputStream;

public class Day2Part2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(handleInputStream("2015/day2input.txt"));
        Pattern pattern = Pattern.compile("(\\d*)x(\\d*)x(\\d*)");
        int totalFeetOfRibbon = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                int[] numbers = {Integer.parseInt(matcher.group(1)),
                        Integer.parseInt(matcher.group(2)),
                        Integer.parseInt(matcher.group(3))};
                Arrays.sort(numbers);
                totalFeetOfRibbon += numbers[0] + numbers[0] + numbers[1] + numbers[1] +
                        (numbers[0] * numbers[1] * numbers[2]);
            }
        }
        System.out.println("Total feet of ribbon: " + totalFeetOfRibbon);
    }
}
