package adventofcode2015.day1;

import java.io.InputStream;
import java.util.Scanner;

import static util.InputHandler.handleInputStream;

public class Day1Part2 {
    public static void main(String[] args) {

        InputStream inputStream = handleInputStream("2015/day1input.txt");
        Scanner scanner = new Scanner(inputStream);
        String input = scanner.nextLine();

        int floor = 0;
        for (int i = 0; i < input.length(); i++) {
            floor = input.charAt(i) == '(' ? floor + 1 : floor - 1;
            if (floor == -1) {
                System.out.println("The position of the basement = " + (i + 1));
                break;
            }
        }
    }
}
