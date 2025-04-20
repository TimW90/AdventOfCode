package adventofcode2015.day2;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static util.FileReader.fileInResourcesToArray;

public class Day2Part2 {
    public static void main(String[] args) {
        List<String> fileLines = fileInResourcesToArray("2015/day2input.txt");
        Pattern pattern = Pattern.compile("(\\d*)x(\\d*)x(\\d*)");
        int totalFeetOfRibbon = 0;

        for (String line : fileLines) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                int[] numbers = IntStream.range(1, 4)
                        .map(i -> Integer.parseInt(matcher.group(i)))
                        .sorted()
                        .toArray();
                totalFeetOfRibbon += 2 * (numbers[0] + numbers[1]) + numbers[0] * numbers[1] * numbers[2];
            }
        }
        System.out.println("Total feet of ribbon: " + totalFeetOfRibbon);
    }
}
