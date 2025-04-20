package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public static List<String> fileInResourcesToArray(String fileName) {

        try {
            Path path = Paths.get("src/main/resources/" + fileName);
            return Files.readAllLines(path);
        } catch (NoSuchFileException e) {
            System.out.println("File not found! Please make sure the file path is correct");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error! Something went wrong... Please make sure the file path is correct");
            throw new RuntimeException(e);
        }
    }
}
