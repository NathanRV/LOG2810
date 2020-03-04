package TP1;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class WeightedGraph {
    
    List<Node> nodes;

    public WeightedGraph () {
        nodes = new LinkedList<Node>();
    }

    public void addEdge (int nodeID, String edgeData) {

    }

    public boolean creerGraphe(String fileName) {
        return false;
    }

    public Collection<Node> plusCourtChemin(Node source, Node destination) {
        return null;
    }

    public void traiterRequetes(String fileName) {

    }

    static class Node {
        private int index;
        private boolean hasRecharge;
        List<Edge> edges;

        public Node (int index, boolean hasRecharge) {
            this.index = index;
            this.hasRecharge = hasRecharge;
        }
    }
    static class Edge {
        private Node source;
        private Node destination;
        int weight;

        public Edge (Node source, Node destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

    }
    
}
