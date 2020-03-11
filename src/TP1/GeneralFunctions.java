package TP1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GeneralFunctions {
    /**
     * Converts information contained in a text file into a list
     *
     * @param fileName Name of text file
     * @return fileInformation Array in which each input represents a single line from the txt file passed by parameter
     */
    public static List<String> readFile(String fileName) throws FileNotFoundException {
        List<String> fileInformation = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("resources/" + fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileInformation.add(line);
            }
        }
        catch (Exception e) {
            throw new FileNotFoundException();
        }
        return fileInformation;
    }

}
