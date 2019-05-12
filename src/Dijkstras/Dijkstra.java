package Dijkstras;

import java.util.*;

public class Dijkstra {

    int dist[];
    Set<Integer> settled;
    PriorityQueue<Node> pq;
    int V; //Number of nodes
    List<List<Node>> adj;


    public Dijkstra(int V)   {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    public void dijkstra(List<List<Node>> adj, int src) {

        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

            //Add source node to pq
            pq.add(new Node(src, 0));

            //Distance to the source is 0
            dist[src] = 0;
            while (settled.size() != V) {

                //remove minimum distance node from pq
                int u = pq.remove().node;

                //adding the node whose distance is finalized
                settled.add(u);

                e_Neighbours(u);
            }
    }

    private void e_Neighbours(int u)    {

        int edgeDistance = -1;
        int newDistance = -1;

        //All neighbours of V
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);

            //If current node hasnt already been processed
            if (!settled.contains(v.node))  {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                //If new node is cheaper in cost
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;


                //Add current node to queue
                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }
}
