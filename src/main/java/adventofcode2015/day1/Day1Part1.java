package adventofcode2015.day1;

import java.io.InputStream;
import java.util.Scanner;

import static util.InputHandler.handleInputStream;

public class Day1Part1 {
    public static void main(String[] args) {

        InputStream inputStream = handleInputStream("2015/day1input.txt");
        Scanner scanner = new Scanner(inputStream);
        String input = scanner.nextLine();

//        int floor = 0;
//        for (int i = 0; i < input.length(); i++) {
//            if (input.charAt(i) == '(') floor++;
//            else floor--;
//        }

        System.out.println(input.chars().map(c -> c == '(' ? 1 : -1).sum());
    }
}
