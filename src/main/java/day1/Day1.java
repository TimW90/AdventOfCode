package day1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static util.InputHandler.handleInputStream;

public class Day1 {
    public static void main(String[] args) {

        int totalDistance = 0;
        int similarityScore = 0;
        ArrayList<Integer> numberList1 = new ArrayList<>();
        ArrayList<Integer> numberList2 = new ArrayList<>();
        InputStream inputStream = handleInputStream("2025/day1input.txt");

        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" {3}");

            numberList1.add(Integer.valueOf(parts[0]));
            numberList2.add(Integer.valueOf(parts[1]));
        }

        numberList1.sort(null);
        numberList2.sort(null);

        for (int i = 0; i < numberList1.size() || i < numberList2.size(); i++) {
//                System.out.println(numberList1.get(i) + " - " + numberList2.get(i) + " = " + Math.abs(numberList1.get(i) - numberList2.get(i)));
            totalDistance += Math.abs(numberList1.get(i) - numberList2.get(i));
        }

        for (int number1 : numberList1) {
            int amount = 0;
            for (int number2 : numberList2) {
                if (number1 == number2) {
                    amount++;
                }
            }
            similarityScore += number1 * amount;
        }

        System.out.println("Total distance = " + totalDistance);
        System.out.println("similarity score = " + similarityScore);
    }
}
