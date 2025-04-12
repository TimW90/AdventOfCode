package adventofcode2015.day2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.InputHandler.handleInputStream;

public class Day2Part1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(handleInputStream("2015/day2input.txt"));
        Pattern pattern = Pattern.compile("(\\d*)x(\\d*)x(\\d*)");
        int totalFeetOfWrappingPaper = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                int lengthWidth = Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
                int widthHeight = Integer.parseInt(matcher.group(2)) * Integer.parseInt(matcher.group(3));
                int heightLength = Integer.parseInt(matcher.group(3)) * Integer.parseInt(matcher.group(1));
                totalFeetOfWrappingPaper += ((2 * lengthWidth) + (2 * widthHeight) + (2 * heightLength)
                        + Math.min(lengthWidth, Math.min(widthHeight, heightLength)));
            }
        }
        System.out.println("Total feet of wrapping paper: " + totalFeetOfWrappingPaper);
    }
}
