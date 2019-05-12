package Tester;

import java.util.*;

public class Graph {

    private HashMap graphMap;

    public Graph() {

        graphMap = new HashMap<Integer, Node>();

        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Edge ab = new Edge(a, b, 1);
        Edge ac = new Edge(a, c, 5);
        Edge bc = new Edge(b, c, 7);
        Edge ba = new Edge(b, a, 1);
        Edge ca = new Edge(c, a, 5);
        Edge cb = new Edge(c, b, 7);

        a.neighbours.add(ab);
        a.neighbours.add(ac);
        b.neighbours.add(bc);
        b.neighbours.add(ba);
        c.neighbours.add(ca);
        c.neighbours.add(cb);

        c.neighbourNodes.add(a);
        c.neighbourNodes.add(b);
        b.neighbourNodes.add(a);
        b.neighbourNodes.add(c);
        a.neighbourNodes.add(b);
        a.neighbourNodes.add(c);

    }

    public void DFS(Node node)   {

        List<Edge> neighbours = node.neighbours;
        node.visited = true;

        for (int i = 0; i < neighbours.size(); i++) {
            Node n = neighbours.get(i).getTo();

            if (n != null && !n.visited) {
                DFS(n);
            }
        }
    }

    public void dfsWithStack(Node node) {

        Stack<Node> stack = new Stack<>();
        stack.add(node);
        node.visited = false;

        while(!stack.isEmpty()) {

            Node element = stack.pop();

            List<Node> neighbours = element.getNeighbourNodes();

            for (int i = 0; i < neighbours.size(); i++) {

                Node n = neighbours.get(i);

                if (n != null && !n.visited)    {

                    stack.add(n);
                    n.visited = true;

                    System.out.println(n);
                }
            }
        }
    }

    public void BFS(Node node)  {

    Queue<Node> queue = new LinkedList<>();

    queue.add(node);
    node.visited = true;

    while(!queue.isEmpty()) {

        Node element = queue.remove();
        List<Node> neighbours = element.neighbourNodes;

        for (int i = 0; i < neighbours.size(); i++) {
            Node n = neighbours.get(i);

            if (n != null && !n.visited)    {

                queue.add(n);
                n.visited = true;
            }
        }
    }
    }
}


