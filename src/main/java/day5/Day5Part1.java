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

        System.out.println(pageOrderingRulesMap);
        System.out.println(updatesList);

        for (ArrayList<Integer> update : updatesList) {
            for (int number = 0; number < update.size() - 1; number++) {
                if (pageOrderingRulesMap.containsKey(update.get(number))) {
                    System.out.println("Update number '" + update.get(number) + "' was found as a 'key' in the HashMap");
//                    for (int updateNumber : pageOrderingRulesMap.get(number)) {
//                        System.out.println("UpdateNumber = " + updateNumber);
//                    }
                } else System.out.println(update.get(number) + " not found as a 'key' in the HashMap");
            }
            System.out.println();
            System.out.println(pageOrderingRulesMap.get(98).contains(42));
        }



    }
}

/*
                                                [46, 98, 96, 88, 42]
    If I start from the left I should check if pageOrderingRulesMap.get(98).contains(42). If true then the update is
    not in the correct order. If false then continue to the next: pageOrderingRulesMap.get(96).contains(98 || 42) but I
    think I will need a .stream for that as contains(98 || 42) will probably not work.

    I could also start from the right and immediately check if key 42 has values 88, 96, 98 or 46 and if so then the
    update is not in the right order
 */
