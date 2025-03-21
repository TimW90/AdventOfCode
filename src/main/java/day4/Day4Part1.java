package day4;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.InputHandler.handleInputStream;

public class Day4Part1 {
    public static void main(String[] args) {

        InputStream inputStream = handleInputStream("day4input.txt");
        Pattern xmasPattern = Pattern.compile("XMAS|SAMX");
        ArrayList<String> inputToArray = new ArrayList<>();
        int count = 0;

        // inputToArray & Horizontal XMAS
        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            inputToArray.add(line);
            Matcher xmasMatcher = xmasPattern.matcher(line);

            while (xmasMatcher.find()) {
                count++;
            }
        }

        System.out.println(count);

        // Vertical XMAS
        StringBuilder verticalToHorizontalLine = new StringBuilder();
        for (int x = 0; x < inputToArray.getFirst().length(); x++) {
            for (int y = 0; y < inputToArray.size(); y++) {
                verticalToHorizontalLine.append(inputToArray.get(y).charAt(x));
            }
            verticalToHorizontalLine.append("\n");
        }

        count += xmasCounter(verticalToHorizontalLine.toString());
        System.out.println(count);

        // Diagonal XMAS (left to right)
        StringBuilder diagonalLeftToRight = new StringBuilder();
        for (int xStart = (inputToArray.size() - 4); xStart >= 0; xStart--) {
            int x = xStart;
            int y = 0;
            while (x < inputToArray.size() && y < inputToArray.size()) {
                diagonalLeftToRight.append(inputToArray.get(y).charAt(x));
                x++;
                y++;
            }
            diagonalLeftToRight.append("\n");
        }

        // Second half
        for (int yStart = 1; yStart < (inputToArray.size() - 3); yStart++) {
            int x = 0;
            int y = yStart;
            while (x < inputToArray.size() && y < inputToArray.size()) {
                diagonalLeftToRight.append(inputToArray.get(y).charAt(x));
                x++;
                y++;
            }
            diagonalLeftToRight.append("\n");
        }

        count += xmasCounter(diagonalLeftToRight.toString());
        System.out.println(count);
//        System.out.println(diagonalLeftToRight);

        // Diagonal XMAS (right to left)
        StringBuilder diagonalRightToLeft = new StringBuilder();
        for (int yStart = 3; yStart < inputToArray.size(); yStart++) {
            int x = 0;
            int y = yStart;
            while (x < inputToArray.size() && y >= 0) {
                diagonalRightToLeft.append(inputToArray.get(y).charAt(x));
                x++;
                y--;
            }
            diagonalRightToLeft.append("\n");
        }

        // Second half
        for (int xStart = 1; xStart < (inputToArray.size() - 3); xStart++) {
            int x = xStart;
            int y = inputToArray.size() - 1;
            while (x < inputToArray.size() && y >= 0) {
                diagonalRightToLeft.append(inputToArray.get(y).charAt(x));
                x++;
                y--;
            }
            diagonalRightToLeft.append("\n");
        }
//        System.out.println(diagonalRightToLeft);

        count += xmasCounter(diagonalRightToLeft.toString());
        System.out.println("Total XMAS count = " + count);

    }


    public static int xmasCounter(String input) {

        int count = 0;
        Pattern xmasPattern = Pattern.compile("XMAS|SAMX");
        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher xmasMatcher = xmasPattern.matcher(line);

            while (xmasMatcher.find()) {
                count++;
            }
        }
        return count;
    }
}
