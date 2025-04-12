package adventofcode2015.day5;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.InputHandler.handleInputStream;

public class Day5Part2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(handleInputStream("2015/day5input.txt"));
        ArrayList<String> niceStrings = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            if (isANiceString(string)) niceStrings.add(string);
        }

        System.out.println("Amount of nice strings: " + niceStrings.size());
    }


    private static boolean isANiceString(String input) {

        Pattern doublePairPattern = Pattern.compile("([a-zA-Z]{2}).*\\1");
        Matcher doublePairMatcher = doublePairPattern.matcher(input);

        if (doublePairMatcher.find()) {
            Pattern repeatingLetterPattern = Pattern.compile("([a-zA-Z])[a-zA-Z]\\1");
            Matcher repeatingLetterMatcher = repeatingLetterPattern.matcher(input);
            if (repeatingLetterMatcher.find()) return true;
        }
        return false;
    }
}
