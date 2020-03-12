package TP1;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        WeightedGraph w = new WeightedGraph();
        w.createGraph("arrondissements.txt");
//        w.plusCourtChemin(1, 10);
        w.printTrajectory(1, 7);
        System.out.println("We made it!");
    }
}
