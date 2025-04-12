package adventofcode2024.day5;

import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.InputHandler.handleInputStream;

public class Day5Part2 {
    public static void main(String[] args) {

        InputStream inputStream = handleInputStream("2024/day5input.txt");
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
        System.out.println(pageOrderingRulesMap);

//        ArrayList<ArrayList<Integer>> correctUpdatesList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> incorrectUpdatesList = new ArrayList<>();

        for (ArrayList<Integer> update : updatesList) {
            boolean isCorrect = true;
            for (int number = update.size() - 1; number >= 0; number--) {
                if (!isCorrect) {
                    break;
                }
                for (int previousNumber = number - 1; previousNumber >= 0; previousNumber--) {
                    if (pageOrderingRulesMap.get(update.get(number)).contains(update.get(previousNumber))) {
//                        System.out.println("Update is incorrect! " + update.get(number) + " should be before "
//                                + update.get(previousNumber));
                        isCorrect = false;
                        incorrectUpdatesList.add(update);
                        break;
                    }
                }
            }
//            if (isCorrect) {
//                System.out.println("Update is correct");
//                correctUpdatesList.add(update);
//            }
        }

        int score = 0;
//        for (ArrayList<Integer> update : correctUpdatesList) score += (update.get(update.size() / 2));

        for (ArrayList<Integer> incorrectUpdate : incorrectUpdatesList) {
            HashMap<Integer, Integer> inDegreeMap = new HashMap<>();
            for (int index = 0; index < incorrectUpdate.size(); index++) {
                int key = incorrectUpdate.get(index);
                inDegreeMap.put(key, 0);
                for (int number : incorrectUpdate) {
                    if (pageOrderingRulesMap.get(key).contains(number)) inDegreeMap.put(key, inDegreeMap.get(key) + 1);
                }
            }
            System.out.println("In-degree map: " + inDegreeMap);

            ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(inDegreeMap.entrySet());
            entryList.sort(Comparator.comparingInt(Map.Entry::getValue));
            System.out.println("Sorted entry list: " + entryList);

            ArrayList<Integer> correctedUpdatesList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : entryList) correctedUpdatesList.add(entry.getKey());

            System.out.println("Incorrect: " + incorrectUpdate);
            System.out.println("Corrected: " + correctedUpdatesList);
            System.out.println();
            score += (correctedUpdatesList.get(correctedUpdatesList.size() / 2));
        }
        System.out.println("Total score: " + score);
    }
}
