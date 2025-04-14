package adventofcode2015.day7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static util.InputHandler.handleInputStream;

// Todo: Work in progress

public class Day7Part1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(handleInputStream("2015/day7input.txt"));
        Map<String, String> instructions = new HashMap<>();

        while (scanner.hasNextLine()) {
            String[] lineSplit = scanner.nextLine().split(" -> ");
            String wire = lineSplit[1];
            String expression = lineSplit[0];
            instructions.put(wire, expression);
        }

        instructions.forEach((key, value) -> System.out.println(key + " -> " + value));


    }
}
