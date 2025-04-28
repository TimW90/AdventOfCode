package adventofcode2015.day8;

import java.util.List;
import java.util.stream.Collectors;

import static util.FileReader.fileInResourcesToArray;

public class Day8Part1 {
    public static void main(String[] args) {
        List<String> fileLines = fileInResourcesToArray("2015/day8input.txt");
        int totalCharactersInString = 0;
        int totalCharactersInCode = 0;

        for (String line : fileLines) {
            totalCharactersInString += line.length();
            StringBuilder stringInMemory = new StringBuilder();

            stringInMemory.append("\"");
            stringInMemory.append(line.chars()
                    .mapToObj(c ->
                            switch (c) {
                                case '\"' -> "\\\"";
                                case '\\' -> "\\\\";
                                default -> (c >= 32 && c <= 126)
                                        ? Character.toString((char) c)
                                        : String.format("\\x%02X", c);
                            })
                    .collect(Collectors.joining())
            );
            stringInMemory.append("\"");

            System.out.println(line);
            System.out.println(stringInMemory);
            System.out.println();
            totalCharactersInCode += stringInMemory.length();
        }

        int difference = totalCharactersInCode - totalCharactersInString;
        System.out.println("totalCharactersInCode - totalCharactersInString = " + difference);
    }
}
