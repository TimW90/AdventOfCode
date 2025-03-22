package day5;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.InputHandler.handleInputStream;

public class Day5Part1 {
    public static void main(String[] args) {

        InputStream inputStream = handleInputStream("day5input.txt");
        Scanner scanner = new Scanner(inputStream);
        HashMap<Integer, List<Integer>> pageOrderingRulesMap = new HashMap<>();
        Pattern pageOrderingPattern = Pattern.compile("(\\d\\d)\\|(\\d\\d)");
        ArrayList<ArrayList<Integer>> updatesList = new ArrayList<>();
        int lineNumber = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher pageOrderingMatcher = pageOrderingPattern.matcher(line);
            if (pageOrderingMatcher.find()) {
                int key = Integer.parseInt(pageOrderingMatcher.group(1));
                int value = Integer.parseInt(pageOrderingMatcher.group(2));
                if (!pageOrderingRulesMap.containsKey(key)) pageOrderingRulesMap.put(key, new ArrayList<>());
                pageOrderingRulesMap.get(key).add(value);
            } else if (!line.isEmpty()) {
                updatesList.add(new ArrayList<>());
                String[] numbers = line.split(",");
                for (String number : numbers) updatesList.get(lineNumber).add(Integer.parseInt(number));
                lineNumber++;
            }
        }

        ArrayList<ArrayList<Integer>> correctUpdatesList = new ArrayList<>();

        for (ArrayList<Integer> update : updatesList) {
            boolean isCorrect = true;
            for (int number = update.size() - 1; number >= 0; number--) {
                if (!isCorrect) {
                    break;
                }
                for (int previousNumber = number - 1; previousNumber >= 0; previousNumber--) {
                    if (pageOrderingRulesMap.get(update.get(number)).contains(update.get(previousNumber))) {
                        System.out.println("Update is incorrect! " + update.get(number) + " should be before "
                                + update.get(previousNumber));
                        isCorrect = false;
                        break;
                    }
                }
            }
            if (isCorrect) {
                System.out.println("Update is correct");
                correctUpdatesList.add(update);
            }
        }

        int score = 0;
        for (ArrayList<Integer> update : correctUpdatesList) score += (update.get(update.size() / 2));
        System.out.println("\nTotal score: " + score);
    }
}
