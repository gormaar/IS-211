package Dijkstras;

import java.util.*;

public class Main {

    public static void main(String[] args)  {

        int V = 5;
        int source = 0;

        List<List<Node>> adj = new ArrayList<List<Node>>();

        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(0).add(new Node(1, 2));
        adj.get(0).add(new Node(3, 4));

        Dijkstra d = new Dijkstra(V);
        d.dijkstra(adj, source);

        System.out.println("Shortest path from node :");
        for (int i = 0; i < d.dist.length; i++){
            System.out.println(source + " to " + i + " is " + d.dist[i]);
        }
    }
}
