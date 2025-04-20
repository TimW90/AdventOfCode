package adventofcode2015.day1;

import java.util.List;

import static util.FileReader.fileInResourcesToArray;

public class Day1Part1 {
    public static void main(String[] args) {
        List<String> fileLines = fileInResourcesToArray("2015/day1input.txt");
        String line = fileLines.getFirst();

        int finalFloor = line.chars().map(c -> c == '(' ? 1 : -1).sum();
        System.out.println(finalFloor);
    }
}
