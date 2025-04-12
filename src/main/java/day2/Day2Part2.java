package day2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static util.InputHandler.handleInputStream;

//Todo: Not finished yet!

public class Day2Part2 {
    public static void main(String[] args) {

        InputStream inputStream = handleInputStream("2024/day2input.txt");
        int safeReports = 0;
        int reportNumber = 0;

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNextLine()) {
            boolean testSafe = false;
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            List<Integer> report = new ArrayList<>();
            for (String part : parts) report.add(Integer.parseInt(part));

            reportNumber++;

            System.out.println("Report: " + report);
            ReportResult reportResult = test(report);
            if (reportResult.isSafe()) {
                safeReports++;
                testSafe = true;
            } else {
                List<Integer> problemDampenedReport = reportResult.report();
                System.out.println("Problem dampened report: " + problemDampenedReport);
                if (test(problemDampenedReport).isSafe()) {
                    safeReports++;
                    testSafe = true;
                }
            }
            System.out.println("Report " + reportNumber + ": is " + (testSafe ? "safe" : "unsafe "));
            System.out.println();
        }

        System.out.println("\n" + safeReports + " safe reports");

    }

    static ReportResult test(List<Integer> report) {

        boolean isIncreasing = false;
        boolean isDecreasing = false;

        for (int i = 0; i < report.size() - 1; i++) {

            int currentNumber = report.get(i);
            int nextNumber = report.get(i + 1);

            // Check if the difference between the next number and the current number is higher than 3 or equals 0
            if (Math.abs(nextNumber - currentNumber) > 3 || (nextNumber - currentNumber) == 0) {
                report.remove(i + 1);
                return new ReportResult(false, report);
            }
            // Check if the next number is higher than the current number (increasing)
            if (nextNumber > currentNumber) {
                isIncreasing = true;
                if (isDecreasing) {
                    report.remove(i + 1);
                    return new ReportResult(false, report);
                }
            }
            // Check if the next number is lower than the current number (decreasing)
            if (nextNumber < currentNumber) {
                isDecreasing = true;
                if (isIncreasing) {
                    report.remove(i + 1);
                    return new ReportResult(false, report);
                }
            }

        }
        return new ReportResult(true, report);
    }
}


record ReportResult(boolean isSafe, List<Integer> report) {
}