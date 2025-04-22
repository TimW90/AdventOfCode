package adventofcode2015.day7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.FileReader.fileInResourcesToArray;

public class Day7Part1 {
    public static void main(String[] args) {
        List<String> fileLines = fileInResourcesToArray("2015/day7input.txt");
        Map<String, Wire> instructions = new HashMap<>();

        for (String line : fileLines) {
            String[] lineSplit = line.split(" -> ");
            String key = lineSplit[1];
            String expression = lineSplit[0];

            instructions.put(key, new Wire(expression));
        }

        Wire wireA = instructions.get("a");
        int wireASignalValue = wireA.evaluate(instructions);
        System.out.println("The signal of wire 'a' is: " + wireASignalValue);
    }
}
