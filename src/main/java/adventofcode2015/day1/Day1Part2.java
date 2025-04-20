package adventofcode2015.day1;

import java.util.List;

import static util.FileReader.fileInResourcesToArray;

public class Day1Part2 {
    public static void main(String[] args) {
        List<String> fileLines = fileInResourcesToArray("2015/day1input.txt");
        String line = fileLines.getFirst();

        int floor = 0;
        for (int i = 0; i < line.length(); i++) {
            floor += line.charAt(i) == '(' ? 1 : -1;
            if (floor == -1) {
                System.out.printf("The position of the basement = %d", i + 1);
                break;
            }
        }
    }
}
