package adventofcode2015.day7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static util.InputHandler.handleInputStream;

// Todo: Work in progress

public class Day7Part1 {

    static Map<String, String> test = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(handleInputStream("2015/day7input.txt"));
        Map<String, Wire> instructions = new HashMap<>();

        while (scanner.hasNextLine()) {
            String[] lineSplit = scanner.nextLine().split(" -> ");
            String wire = lineSplit[1];
            String expression = lineSplit[0];

            try {
                int value = Integer.parseInt(expression);
                instructions.put(wire, new Wire(value));
            } catch (NumberFormatException e) {
                instructions.put(wire, new Wire(expression));
            }

            //This is for part 2!
            // Overriding "b"
            //instructions.put("b", new Wire(956));
        }
        System.out.println("The signal of wire 'a' is: " + instructions.get("a").evaluate(instructions));
    }
}

class Wire {

   private Integer intValue;

   private final String expression;


   public Wire (Integer intValue) {
       this.intValue = intValue;
       this.expression = null;
   }

   public Wire (String expression) {
       this.intValue = null;
       this.expression = expression;
   }

   private boolean hasInt() {
       return intValue != null;
   }

   public Integer evaluate(Map<String, Wire> instructions) {
       if (hasInt()) return intValue;

       String[] expressionSplit = expression.split(" ");

       // The wire is wire case
       if (expressionSplit.length == 1) {
           String key = expressionSplit[0];
           Wire wire = instructions.get(key);
           return intValue = wire.evaluate(instructions);
       }

       // The NOT case
       if (expressionSplit.length == 2) {
           String key = expressionSplit[1];
           Wire wire = instructions.get(key);
           int value = wire.evaluate(instructions);
           return intValue = ~value;

           // The other cases
       } else if (expressionSplit.length == 3) {
           String leftKey = expressionSplit[0];
           String operator = expressionSplit[1];
           String rightKey = expressionSplit[2];

           int leftValue;
           if (stringIsANumber(leftKey)) {
               leftValue = Integer.parseInt((leftKey));
           } else {
               Wire leftWire = instructions.get(leftKey);
               leftValue = leftWire.evaluate(instructions);
           }

           int rightValue;
           if (stringIsANumber(rightKey)) {
               rightValue = Integer.parseInt(rightKey);
           } else {
               Wire rightWire = instructions.get(rightKey);
               rightValue = rightWire.evaluate(instructions);
           }

               intValue = switch (operator) {
               case "AND" -> leftValue & rightValue;
               case "OR" -> leftValue | rightValue;
               case "RSHIFT" -> leftValue >> rightValue;
               case "LSHIFT" -> leftValue << rightValue;
               default -> throw new IllegalStateException("Unexpected value: " + operator);
           };

           return intValue;

       } else throw new IllegalArgumentException("Incorrect expression: " + expression);
   }

   public boolean stringIsANumber(String str) {
       try {
           Integer.parseInt(str);
           return true;
       } catch (NumberFormatException e) {
           return false;
       }
   }
}
