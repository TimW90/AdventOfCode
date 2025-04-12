package adventofcode2015.day3;

import java.util.*;

import static util.InputHandler.handleInputStream;

public class Day3Part2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(handleInputStream("2015/day3input.txt"));
        String input = scanner.nextLine();

        int xCoordinate = 0;
        int yCoordinate = 0;
        int xCoordinateRoboSanta = xCoordinate;
        int yCoordinateRoboSanta = yCoordinate;
        Set<List<Integer>> coordinatesSet = new HashSet<>();
        coordinatesSet.add(new ArrayList<>(Arrays.asList(xCoordinate, yCoordinate)));

        for (int index = 0; index < input.length(); index++) {
            if (index % 2 == 0) {
                if (input.charAt(index) == '^')
                    coordinatesSet.add(new ArrayList<>(Arrays.asList(xCoordinate, ++yCoordinate)));
                if (input.charAt(index) == 'v')
                    coordinatesSet.add(new ArrayList<>(Arrays.asList(xCoordinate, --yCoordinate)));
                if (input.charAt(index) == '>')
                    coordinatesSet.add(new ArrayList<>(Arrays.asList(++xCoordinate, yCoordinate)));
                if (input.charAt(index) == '<')
                    coordinatesSet.add(new ArrayList<>(Arrays.asList(--xCoordinate, yCoordinate)));
            } else {
                if (input.charAt(index) == '^')
                    coordinatesSet.add(new ArrayList<>(Arrays.asList(xCoordinateRoboSanta, ++yCoordinateRoboSanta)));
                if (input.charAt(index) == 'v')
                    coordinatesSet.add(new ArrayList<>(Arrays.asList(xCoordinateRoboSanta, --yCoordinateRoboSanta)));
                if (input.charAt(index) == '>')
                    coordinatesSet.add(new ArrayList<>(Arrays.asList(++xCoordinateRoboSanta, yCoordinateRoboSanta)));
                if (input.charAt(index) == '<')
                    coordinatesSet.add(new ArrayList<>(Arrays.asList(--xCoordinateRoboSanta, yCoordinateRoboSanta)));
            }
        }
        System.out.println("Amount of unique houses visited: " + coordinatesSet.size());
    }
}
