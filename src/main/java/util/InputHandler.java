package util;

import java.io.InputStream;

public class InputHandler {

    public static InputStream handleInputStream(String fileName) {

        if (fileName == null || fileName.isEmpty()) System.out.println("Invalid file name!");

        InputStream inputStream = InputHandler.class.getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) System.out.println("File not found!");

        return inputStream;
    }
}
