package Tester;

import java.util.ArrayList;
import java.util.List;

public class Node {

    boolean visited;
    ArrayList<Edge> neighbours;
    ArrayList<Node> neighbourNodes;

    public void addNeighbours(Edge edge) {
        neighbours.add(edge);
    }

    public ArrayList<Node> getNeighbourNodes() {
        return neighbourNodes;
    }

    public boolean isVisited()  {
        return visited;
    }

    public void setVisited(boolean visited)    {
        this.visited = visited;
    }


    public void setNeighbours(ArrayList neighbours)  {
        this.neighbours = neighbours;
    }

    public ArrayList<Edge> getEdges()   {
        return neighbours;
    }

    public String toString()    {

        return "Node: name";


    }
}
