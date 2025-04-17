package adventofcode2015.day7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static util.InputHandler.handleInputStream;

// Todo: Work in progress

public class Day7Part1 {

    static Map<String, String> test = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(handleInputStream("2015/day7input.txt"));
        Map<String, String> instructions = new HashMap<>();

        while (scanner.hasNextLine()) {
            String[] lineSplit = scanner.nextLine().split(" -> ");
            String wire = lineSplit[1];
            String expression = lineSplit[0];
            instructions.put(wire, expression);
        }

        //instructions.forEach((key, value) -> System.out.println(key + " -> " + value));


        // test
        test.put("ab", "a + b");
        test.put("a", "5");
        test.put("b", "c");
        test.put("c", "10");

        System.out.println("Value of ab = " + testMethod("ab"));
    }

    public static int testMethod(String key) {

        int value = 0;

        // ab = a + b
        // a = 5, b = c;
        // c = 10;

        try {
            String[] expressionSplit = test.get(key).split(" ");
            // if expressionSplit.size() = 1 then parse the integer
            // try testMethod(expressionSplit[0]) and try testMethod(expressionSplit[2]) ?
            if (Arrays.asList(expressionSplit).contains("+")) {
                value = (Integer.parseInt(expressionSplit[0]) + Integer.parseInt(expressionSplit[2]));
            } else {
                value = Integer.parseInt(test.get(key));
            }

        } catch (NumberFormatException e) {

        }
        return value;




//        try {
//            value = Integer.parseInt(test.get(key));
//            System.out.println(key + " = " + value);
//        } catch (NumberFormatException e) {
//            value = testMethod(test.get(key));
//            System.out.println(key + " = " + value);
//        }
//        return value;
    }
}
