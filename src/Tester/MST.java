package Tester;

import java.util.*;
import java.util.Map.Entry;


public class MST {

    static class Node {

        LinkedList<MST.Node> shortestPath;
        HashMap<MST.Node, Integer> neighbours;
        int key;
        boolean visited;
        int distance = Integer.MAX_VALUE;

        public Node(int key)   {
            this.key = key;

            shortestPath = new LinkedList<>();
            neighbours = new HashMap<>();
        }

        public HashMap<MST.Node, Integer> getAdjacentNodes()    {
            return neighbours;
        }

        public void setDistance(int distance)   {
            this.distance = distance;
        }

        public void setShortestPath(LinkedList<MST.Node> shortestPath)   {
            this.shortestPath = shortestPath;
        }

        public List<MST.Node> getShortestPath() {
            return shortestPath;
        }

        public int getDistance() {
            return distance;
        }

        public void addDestination(MST.Node destination, int weight)    {
            neighbours.put(destination, weight);
        }

        /*public List<Edge> getEdges()    {
            return edgeList;
        }

        public boolean isVisited()  {
            return visited;
        }

        public void addEdge(int src, int dest, int weight)   {
            Edge edge = new Edge(src, dest, weight);
            edgeList.add(edge);
        }*/

        public String toString()    {
            return "Node: " + key;
        }

        public int getKey() {
            return key;
        }
    }

    static class Edge {

        int src, dest, weight;

        public Edge(int src, int dest, int weight)  {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int getSrc() {
            return src;
        }

        public int getDest()    {
            return dest;
        }

        public int getWeight()  {
            return weight;
        }
    }

    HashMap<Integer, ArrayList<Node>> nodeMap;
    HashSet<MST.Node> nodes;

    public MST()  {

       nodeMap = new HashMap<>();
       nodes = new HashSet<>();

        }

        public void addNode(MST.Node node)  {
            nodes.add(node);
        }


        public void printGraph()    {


            for (int i = 1; i < nodeMap.size(); i++)    {

                ArrayList<MST.Node> nodeList = nodeMap.get(i);

                for (MST.Node n : nodeList) {

                    System.out.println("Node " + i + " is connected to Node: " + n.getKey());

                }
            }
    }

}



