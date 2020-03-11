package TP1;

import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        WeightedGraph w = new WeightedGraph();
        w.createGraph("arrondissements.txt");
        w.printGraph();
    }

}
