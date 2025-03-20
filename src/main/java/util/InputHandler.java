package util;

import java.io.InputStream;

public class InputHandler {

    public static InputStream handleInputStream(String input) {

        if (input == null || input.isEmpty()) System.out.println("Invalid file name!");

        InputStream inputStream = InputHandler.class.getClassLoader().getResourceAsStream(input);

        if (inputStream == null) System.out.println("File not found!");

        return inputStream;
    }
}
