package adventofcode2015.day7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.FileReader.fileInResourcesToArray;

// Todo: Work in progress

public class Day7Part1 {

    static Map<String, String> test = new HashMap<>();

    public static void main(String[] args) {
        List<String> fileLines = fileInResourcesToArray("2015/day7input.txt");
        Map<String, Wire> instructions = new HashMap<>();

        for (String line : fileLines) {
            String[] lineSplit = line.split(" -> ");
            String key = lineSplit[1];
            String expression = lineSplit[0];

            try {
                int value = Integer.parseInt(expression);
                instructions.put(key, new Wire(value));
            } catch (NumberFormatException e) {
                instructions.put(key, new Wire(expression));
            }
        }
        System.out.println("The signal of wire 'a' is: " + instructions.get("a").evaluate(instructions));
    }
}

class Wire {

    private Integer intValue;

    private final String expression;

    public Wire(Integer intValue) {
        this.intValue = intValue;
        this.expression = null;
    }

    public Wire(String expression) {
        this.expression = expression;
    }

    private boolean hasInt() {
        return intValue != null;
    }

    public Integer evaluate(Map<String, Wire> instructions) {
        if (hasInt()) return intValue;

        String[] expressionSplit = expression.split(" ");
        // The assign (->) case
        if (expressionSplit.length == 1) return intValue = getValue(expressionSplit[0], instructions);
        // The NOT case
        if (expressionSplit.length == 2) return intValue = ~getValue(expressionSplit[1], instructions);
        // The other cases
        if (expressionSplit.length == 3) return intValue = evaluateExpression(expressionSplit, instructions);

        throw new IllegalArgumentException("Incorrect expression: " + expression);
    }

    private int getValue(String key, Map<String, Wire> instructions) {
        int value;

        if (stringIsANumber(key)) {
            value = Integer.parseInt((key));
        } else {
            Wire wire = instructions.get(key);
            value = wire.evaluate(instructions);
        }
        return value;
    }

    private int evaluateExpression(String[] expressionSplit, Map<String, Wire> instructions) {
        String leftKey = expressionSplit[0];
        String operator = expressionSplit[1];
        String rightKey = expressionSplit[2];

        int leftValue = getValue(leftKey, instructions);
        int rightValue = getValue(rightKey, instructions);

        return switch (operator) {
            case "AND" -> leftValue & rightValue;
            case "OR" -> leftValue | rightValue;
            case "RSHIFT" -> leftValue >> rightValue;
            case "LSHIFT" -> leftValue << rightValue;
            default -> throw new IllegalStateException("Unexpected operator value: " + operator);
        };
    }

    private boolean stringIsANumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
