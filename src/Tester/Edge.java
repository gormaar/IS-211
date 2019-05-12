package Tester;

import java.util.*;

public class Edge {

    private Node from, to;
    private int weight;
    boolean visited;

    public Edge(Node from, Node to, int weight)   {

        this.from = from;
        this.to = to;
        this.weight = weight;

    }


    public Node getFrom() {
        return from;
    }


    public Node getTo() {
        return to;
    }

    public int getWeight()  {
        return weight;
    }

}
