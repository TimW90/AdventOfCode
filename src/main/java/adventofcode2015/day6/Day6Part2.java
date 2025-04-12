package adventofcode2015.day6;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static adventofcode2015.day6.Brightness.*;
import static util.InputHandler.handleInputStream;

public class Day6Part2 {

    private static final int[][] lightGrid = new int[1000][1000];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(handleInputStream("2015/day6input.txt"));

        while (scanner.hasNextLine()) {

            String instruction = scanner.nextLine();
            Pattern lightPattern = Pattern.compile("(\\d{1,3}),(\\d{1,3})\\D+(\\d{1,3}),(\\d{1,3})");
            Matcher lightMatcher = lightPattern.matcher(instruction);

            if (lightMatcher.find()) {
                int[] startingCoordinates = new int[]
                        {Integer.parseInt(lightMatcher.group(1)), Integer.parseInt(lightMatcher.group(2))};
                int[] endingCoordinates = new int[]
                        {Integer.parseInt(lightMatcher.group(3)), Integer.parseInt(lightMatcher.group(4))};

                if (instruction.toLowerCase().startsWith("turn on"))
                    adjustBrightness(ON, startingCoordinates, endingCoordinates);

                if (instruction.toLowerCase().startsWith("turn off"))
                    adjustBrightness(OFF, startingCoordinates, endingCoordinates);

                if (instruction.toLowerCase().startsWith("toggle"))
                    adjustBrightness(TOGGLE, startingCoordinates, endingCoordinates);
            }
        }
        System.out.println("The total brightness is '" + calculateBrightness() + "'");
    }

    private static void adjustBrightness(Brightness action, int[] startingCoordinates, int[] endingCoordinates) {

        int yStart = startingCoordinates[0];
        int xStart = startingCoordinates[1];
        int yEnd = endingCoordinates[0];
        int xEnd = endingCoordinates[1];

        for (int y = yStart; y <= yEnd; y++) {
            for (int x = xStart; x <= xEnd; x++) {
                if (action == ON) lightGrid[y][x]++;
                if (action == OFF) lightGrid[y][x] = --lightGrid[y][x] <= 0 ? 0 : lightGrid[y][x];
                if (action == TOGGLE) lightGrid[y][x] += 2;
            }
        }
    }

    private static int calculateBrightness() {

        int totalBrightness = 0;

        for (int y = 0; y < lightGrid.length; y++) {
            for (int x = 0; x < lightGrid[y].length; x++) {
                totalBrightness += lightGrid[y][x];
            }
        }
        return totalBrightness;
    }
}

enum Brightness {
    ON,
    OFF,
    TOGGLE
}