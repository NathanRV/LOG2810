package TP1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello World!");
        WeightedGraph w = new WeightedGraph();
        List<String> graphInformation = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get("resources/arrondissements.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                graphInformation.add(line);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        w.createGraph(graphInformation);
        System.out.println("Success?");
    }
}
