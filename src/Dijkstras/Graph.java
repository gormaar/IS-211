package Dijkstras;

import java.util.*;

public class Graph {

    HashSet<Node> nodes = new HashSet<>();
    HashSet<Node> settledNodes = new HashSet<>();
    HashSet<Node> unsettledNodes = new HashSet<>();


    public void addNode(Node node)   {
        nodes.add(node);
    }

}
