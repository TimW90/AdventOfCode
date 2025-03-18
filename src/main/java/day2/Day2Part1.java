package day2;

import java.io.InputStream;
import java.util.Scanner;

public class Day2Part1 {
    public static void main (String[] args) {

        InputStream inputStream = Day2Part1.class.getClassLoader().getResourceAsStream("day2input.txt");
        int safeReports = 0;

        if (inputStream != null) {

            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                int[] report = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    report[i] = Integer.parseInt(parts[i]);
                }

                if (isSafe(report)) safeReports++;
            }

            System.out.println("\n" + safeReports + " safe reports");

        } else System.out.println("File not found!");
    }


    static boolean isSafe(int[] report) {

        boolean isIncreasing = false;
        boolean isDecreasing = false;

        for (int i = 0; i < report.length - 1; i++) {

            int currentNumber = report[i];
            int nextNumber = report[i + 1];

            // Check if the difference between the next number and the current number is higher than 3 or equals 0
            if (Math.abs(nextNumber - currentNumber) > 3 || (nextNumber - currentNumber) == 0) return false;
            // Check if the next number is higher than the current number (increasing)
            if (nextNumber > currentNumber) isIncreasing = true;
            // Check if the next number is lower than the current number (decreasing)
            if (nextNumber < currentNumber) isDecreasing = true;

            if (isIncreasing && isDecreasing) return false;

        }
        return true;
    }

}

