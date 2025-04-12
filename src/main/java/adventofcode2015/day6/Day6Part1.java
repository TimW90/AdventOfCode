package adventofcode2015.day6;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static adventofcode2015.day6.Lights.*;
import static util.InputHandler.handleInputStream;

public class Day6Part1 {

    private static final boolean[][] lightGrid = new boolean[1000][1000];

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
                    switchLights(ON, startingCoordinates, endingCoordinates);

                if (instruction.toLowerCase().startsWith("turn off"))
                    switchLights(OFF, startingCoordinates, endingCoordinates);

                if (instruction.toLowerCase().startsWith("toggle"))
                    switchLights(TOGGLE, startingCoordinates, endingCoordinates);
            }
        }
        System.out.println("There are a total of '" + countTurnedOnLights() + "' lights turned on");
    }

    private static void switchLights(Lights action, int[] startingCoordinates, int[] endingCoordinates) {

        int yStart = startingCoordinates[0];
        int xStart = startingCoordinates[1];
        int yEnd = endingCoordinates[0];
        int xEnd = endingCoordinates[1];

        for (int y = yStart; y <= yEnd; y++) {
            for (int x = xStart; x <= xEnd; x++) {
                if (action == ON) lightGrid[y][x] = true;
                if (action == OFF) lightGrid[y][x] = false;
                if (action == TOGGLE) lightGrid[y][x] = !lightGrid[y][x];
            }
        }
    }

    private static int countTurnedOnLights() {

        int totalLightsOn = 0;

        for (int y = 0; y < lightGrid.length; y++) {
            for (int x = 0; x < lightGrid[y].length; x++) {
                if (lightGrid[y][x]) {
                    totalLightsOn++;
                }
            }
        }
        return totalLightsOn;
    }
}

enum Lights {
    ON,
    OFF,
    TOGGLE
}