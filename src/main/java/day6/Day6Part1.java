package day6;

import java.io.InputStream;
import java.util.*;

import static util.InputHandler.handleInputStream;

public class Day6Part1 {

    static ArrayList<String> inputArray = new ArrayList<>();
    static HashMap<Integer, Set<Integer>> positionCoordinatesMap = new HashMap<>();

    public static void main(String[] args) {

        InputStream inputStream = handleInputStream("day6input.txt");
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) inputArray.add(scanner.nextLine());

        int xAxis = 0, yAxis = 0;

        // Find the starting position (line and index)
        for (; yAxis < inputArray.size(); yAxis++) {
            if (inputArray.get(yAxis).indexOf('^') != -1) {
                xAxis = inputArray.get(yAxis).indexOf('^');
                addPositionCoordinates(yAxis, xAxis);
                System.out.println("Starting position is: y-axis '" + yAxis + "', x-axis '" + xAxis + "'");
                break;
            }
        }
        System.out.println(positionCoordinatesMap);

        // Catch the error when the 'guard' inevitably moves off the grid
        try {
            moveUp(yAxis, xAxis);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Guard has moved out of the grid!");
        }

        System.out.println("positionCoordinates = " + positionCoordinatesMap);

        // Get the size of every Set in 'positionCoordinatesMap' and add up
        int totalDistinctPositions = 0;
        for (Set<Integer> set : positionCoordinatesMap.values()) totalDistinctPositions += set.size();
        System.out.println("Total distinct positions = " + totalDistinctPositions);
    }

    static void moveUp(int yAxis, int xAxis) {
        boolean isClear = true;
        while (isClear) {
            if (inputArray.get(yAxis - 1).charAt(xAxis) == '#') {
                System.out.println("Position " + (yAxis - 1) + ":" + xAxis + " is blocked");
                isClear = false;
            } else {
                System.out.println("Moving up (" + (yAxis - 1) + ":" + xAxis + ")");
                yAxis--;
                addPositionCoordinates(yAxis, xAxis);
            }
        }
        moveRight(yAxis, xAxis);
    }

    static void moveRight(int yAxis, int xAxis) {
        boolean isClear = true;
        while (isClear) {
            if (inputArray.get(yAxis).charAt(xAxis + 1) == '#') {
                System.out.println("Position " + yAxis + ":" + (xAxis + 1) + " is blocked");
                isClear = false;
            } else {
                System.out.println("Moving right (" + yAxis + ":" + (xAxis + 1) + ")");
                xAxis++;
                addPositionCoordinates(yAxis, xAxis);
            }
        }
        moveDown(yAxis, xAxis);
    }

    static void moveDown(int yAxis, int xAxis) {
        boolean isClear = true;
        while (isClear) {
            if (inputArray.get(yAxis + 1).charAt(xAxis) == '#') {
                System.out.println("Position " + (yAxis + 1) + ":" + xAxis + " is blocked");
                isClear = false;
            } else {
                System.out.println("Moving down (" + (yAxis + 1) + ":" + xAxis + ")");
                yAxis++;
                addPositionCoordinates(yAxis, xAxis);
            }
        }
        moveLeft(yAxis, xAxis);
    }

    static void moveLeft(int yAxis, int xAxis) {
        boolean isClear = true;
        while (isClear) {
            if (inputArray.get(yAxis).charAt(xAxis - 1) == '#') {
                System.out.println("Position " + yAxis + ":" + (xAxis - 1) + " is blocked");
                isClear = false;
            } else {
                System.out.println("Moving left (" + yAxis + ":" + (xAxis - 1) + ")");
                xAxis--;
                addPositionCoordinates(yAxis, xAxis);
            }
        }
        moveUp(yAxis, xAxis);
    }

    static void addPositionCoordinates(int yAxis, int xAxis) {
        if (positionCoordinatesMap.containsKey(yAxis)) positionCoordinatesMap.get(yAxis).add(xAxis);
        else positionCoordinatesMap.put(yAxis, new HashSet<>(List.of(xAxis)));
    }
}
