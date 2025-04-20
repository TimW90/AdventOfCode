package adventofcode2015.day2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.FileReader.fileInResourcesToArray;

public class Day2Part1 {
    public static void main(String[] args) {
        List<String> fileLines = fileInResourcesToArray("2015/day2input.txt");
        Pattern pattern = Pattern.compile("(\\d*)x(\\d*)x(\\d*)");
        int totalFeetOfWrappingPaper = 0;

        for (String line : fileLines) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                int length = Integer.parseInt(matcher.group(1));
                int width = Integer.parseInt(matcher.group(2));
                int height = Integer.parseInt(matcher.group(3));
                int[] sides = {length * width, width * height, height * length};
                Arrays.sort(sides);
                totalFeetOfWrappingPaper += 2 * sides[0] + 2 * sides[1] + 2 * sides[2] + sides[0];
            }
        }
        System.out.println("Total feet of wrapping paper: " + totalFeetOfWrappingPaper);
    }
}
