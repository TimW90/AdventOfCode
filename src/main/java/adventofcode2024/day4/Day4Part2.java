package adventofcode2024.day4;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static util.InputHandler.handleInputStream;

public class Day4Part2 {
    public static void main (String[] args) {

        InputStream inputStream = handleInputStream("2024/day4input.txt");
        ArrayList<String> inputToArray = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            inputToArray.add(line);
        }
        int count = 0;

        for (int yStart = 0; (yStart < inputToArray.size() - 2); yStart++) {
            for (int xStart = 0; (xStart < inputToArray.size() - 2); xStart++) {
                int x = xStart;
                int y = yStart;
                StringBuilder diagonalLeftToRight = new StringBuilder();
                StringBuilder diagonalRightToLeft = new StringBuilder();

                if (inputToArray.get(y + 1).charAt(x + 1) != 'A') continue;

                while (x <= (xStart + 2) && y <= (yStart + 2)) {
                    diagonalLeftToRight.append(inputToArray.get(y).charAt(x));
                    x++;
                    y++;
                }

                if (!diagonalLeftToRight.toString().equals("MAS")
                        && !diagonalLeftToRight.toString().equals("SAM")) continue;

                x = xStart + 2;
                y = yStart;
                while (x >= 0 && y <= (yStart + 2)) {
                    diagonalRightToLeft.append(inputToArray.get(y).charAt(x));
                    x--;
                    y++;
                }

                if (diagonalRightToLeft.toString().equals("MAS")
                        || diagonalRightToLeft.toString().equals("SAM")) count++;
            }
        }
        System.out.println("Total 'X'MAS patterns = " + count);
    }
}
