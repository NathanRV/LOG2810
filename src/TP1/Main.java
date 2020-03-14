package TP1;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        WeightedGraph w = new WeightedGraph();
        w.createGraph("arrondissements.txt");
        LinkedList<WeightedGraph.Node> path = w.plusCourtChemin(1, 7);
        System.out.println(w.computeDistanceOfPath(path));
        w.printTrajectory(1, 7);
        System.out.println("We made it!");
    }
}
