package adventofcode2015.day7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.FileReader.fileInResourcesToArray;

public class Day7Part2 {
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

        instructions.put("b", new Wire(956));

        Wire wireA = instructions.get("a");
        int WireASignalValue = wireA.evaluate(instructions);
        System.out.println("The signal of wire 'a' is: " + WireASignalValue);
    }
}

