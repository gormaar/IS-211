package Dijkstras;

import java.util.*;

public class Node implements Comparator<Node>{

     int node;
     int cost;

     public Node()  {

     }

    public Node(int node, int cost) {

        this.node = node;
        this.cost = cost;

    }

    public int compare(Node n1, Node n2)  {

         if (n1.cost < n2.cost) {
             return -1;
         }
         if (n1.cost > n2.cost) {
             return 1;
         }
         else {
             return 0;
         }
    }
}
