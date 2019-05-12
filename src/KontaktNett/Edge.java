package KontaktNett;

import java.util.*;

public class Edge {

    private String src, dest;
    private int weight;
    private ArrayList<Edge> adjList;

    public Edge(String src, String dest, int weight)    {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public String getSrc() {
        return src;
    }
    public String getDest() {
         return dest;
    }

    public int getWeight()  {
        return weight;
    }

    public void incrementWeight()   {
        weight += 1;
    }

    }

