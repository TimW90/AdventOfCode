package day6;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import static util.InputHandler.handleInputStream;

public class Day6Part1 {
    public static void main(String[] args) {

        InputStream inputStream = handleInputStream("day6input.txt");
        ArrayList<String> inputArray = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) inputArray.add(scanner.nextLine());

        HashSet<Double> positionCoordinates = new HashSet<>();

        // Find the starting position (line and index)
        for (int y = 0; y < inputArray.size(); y++) {
            if (inputArray.get(y).indexOf('^') != -1) {
                System.out.println("Starting position is: y-axis '" + y + "', x-axis '" + inputArray.get(y).indexOf('^') + "'");
                positionCoordinates.add(y + inputArray.get(y).indexOf('^') / 1000.0);
            }
        }

        System.out.println(positionCoordinates);




    }
}
