package adventofcode2015.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.InputHandler.handleInputStream;

public class Day5Part1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(handleInputStream("2015/day5input.txt"));
        ArrayList<String> niceStrings = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();

//            if (string.contains("ab") || string.contains("cd") || string.contains("pq") || string.contains("xy"))
//                continue;

            if (Arrays.stream(new String[] {"ab", "cd", "pq", "xy"}).anyMatch(string::contains)) continue;

            if (checkForTripleVowels(string) && checkForDoubleLettersRow(string)) niceStrings.add(string);
        }

        System.out.println("Amount of nice strings: " + niceStrings.size());
    }


    private static boolean checkForTripleVowels(String input) {

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int vowelsCount = 0;
        for (char c : input.toCharArray()) {
            if (vowels.contains(c)) vowelsCount++;
            if (vowelsCount >= 3) return true;
        }
        return false;
    }

    private static boolean checkForDoubleLettersRow(String input) {

        Pattern doubleLettersPattern = Pattern.compile("(.)\\1");
        Matcher matcher = doubleLettersPattern.matcher(input);

        return matcher.find();
    }
}
