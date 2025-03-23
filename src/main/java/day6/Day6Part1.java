package day6;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static util.InputHandler.handleInputStream;

public class Day6Part1 {

    static ArrayList<String> inputArray = new ArrayList<>();

    public static void main(String[] args) {

        InputStream inputStream = handleInputStream("day6input.txt");
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) inputArray.add(scanner.nextLine());

        HashMap<Integer, Integer> positionCoordinates = new HashMap<>();
        int xAxis = 0, yAxis = 0;

        // Find the starting position (line and index)
        for (; yAxis < inputArray.size(); yAxis++) {
            if (inputArray.get(yAxis).indexOf('^') != -1) {
                xAxis = inputArray.get(yAxis).indexOf('^');
                positionCoordinates.put(yAxis, xAxis);
                System.out.println("Starting position is: y-axis '" + yAxis + "', x-axis '" + xAxis + "'");
            }
        }




    }

    static void moveUp(int yAxis, int xAxis) {

    }

    static void moveRight(int yAxis, int xAxis) {

    }

    static void moveDown(int yAxis, int xAxis) {

    }

    static void moveLeft(int yAxis, int xAxis) {

    }
}
