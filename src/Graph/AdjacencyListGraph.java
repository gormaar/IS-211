package Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 * Adjacency list representation of a general graph
 *
 * @author evenal
 */
public class AdjacencyListGraph implements Graph {
    List<Node> nodeList;


    public AdjacencyListGraph() {
        nodeList = new ArrayList<>();
    }


    /**
     * Read the graph from file. A sample file is in src/testdata/graph.txt
     *
     * @param graphFile path to the graph file
     */
    public AdjacencyListGraph(File graphFile) {
        this();
        // hashmap used to speed up finding the nodes when reading file
        HashMap<String, Node> nodes = new HashMap<>();
        try (BufferedReader r = new BufferedReader(new FileReader(graphFile))) {
            // using a scanner to get one token at a time from the file
            Scanner scanner = new Scanner(r);
            // read the nodes
            if (!"Nodes".equals(scanner.next()))
                throw new IOException();
            int numNodes = scanner.nextInt();
            for (int i = 0; i < numNodes; i++) {
                String name = scanner.next();
                Node n = new Node(name);
                nodes.put(name, n);
                nodeList.add(n);
            }
            // read the edges from the file
            if (!"Edges".equals(scanner.next()))
                throw new IOException();
            while (scanner.hasNext()) {
                String from = scanner.next();
                String to = scanner.next();
                double weight = scanner.nextDouble();
                Node fromNode = nodes.get(from);
                Node toNode = nodes.get(to);
                Edge e = new Edge(fromNode, toNode, weight);
                fromNode.edges.add(e);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }


    /**
     * Depth first traverse the graph starting in node n. Delegates the actual
     * traversal to recursive method dfs(). Using a recursive method allow us to
     * use the java call stack, so we do not need an explicit stack
     *
     * @param n start node
     */
    public void depthFirstTraverse(Node n) {
        ArrayList<Node> visited = new ArrayList<>();
        dfs(n, visited);
    }


    /**
     * Visit node n and any nodes reachable from n.
     *
     * @param n The node we are about to visit
     * @param visited list of nodes that have been visited.
     */
    private void dfs(Node n, List<Node> visited) {
        // mark n as visited
        visited.add(n);
        System.out.println("Visiting " + n.name);
        for (Edge e : n.edges) {
            // now we have seen/discovered e.to
            if (!visited.contains(e.to))
                // go on to visit e.to, if it has not been visited before
                dfs(e.to, visited);
        }
    }


    /**
     * Breadth first traversal of the graph starting in n.
     *
     * @param n the start node.
     */
    public void breadthFirstTraversal(Node n) {
        // discovered nodes
        ArrayList<Node> seen = new ArrayList<>();
        // the queue of nodes that will be visited
        LinkedList<Node> q = new LinkedList<>();
        // add the start node to the queue and mark it as seen
        q.addLast(n);
        seen.add(n);
        while (!q.isEmpty()) {
            // get the next node from the queue
            Node node = q.removeFirst();
            // visit it
            System.out.println("Visiting " + node.name);
            for (Edge e : node.edges) {
                // for each node that node has an edge to
                if (!seen.contains(e.to)) {
                    // add it to the queue and mark it as seen
                    q.addLast(e.to);
                    seen.add(e.to);
                }
            }

            // debug printout
            System.out.print("Seen: ");
            for (Node sn : seen)
                System.out.print(" " + sn.name);
            System.out.print("\n\nQueue:");

            for (Node qn : q)
                System.out.print(" " + qn.name);
            System.out.println();
        }

    }


    public void print(PrintWriter out) {
        out.format("Nodes %d\n", nodeList.size());
        for (Node n : nodeList)
            out.format("%s\n", n.name);
        out.println("Edges");
        for (Node n : nodeList) {
            for (Edge e : n.edges)
                out.format("%s %s %f\n",
                        e.from.name,
                        e.to.name,
                        e.weight);
        }
        out.flush();
    }


    /**
     * The node class. This one is minimal. If the program where the graph is
     * used requires more information about the node it can be added here.
     */
    public class Node {
        String name;
        List<Edge> edges;


        public Node(String name) {
            this.name = name;
            edges = new ArrayList<>();
        }
    }


    /**
     * The edge class is only needed if you need information about the edge.
     * (For example weight, as shown here). If the graph is not weighted the
     * graph class can be omitted and the edges list in Node can be replaced by
     * a list of neighbour nodes.
     */
    public class Edge {
        Node from; // edge going from this node
        Node to; // to this node
        double weight; // lenght/capacity... whatever


        public Edge(Node from, Node to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

    }


    public static void main(String[] args) {
        File f = new File("src/testdata/graph.txt");
        System.out.println("\n\n\nDFS");
        AdjacencyListGraph g = new AdjacencyListGraph(f);
        g.depthFirstTraverse(g.nodeList.get(1));
        System.out.println("\n\n\nBFS");
        g.breadthFirstTraversal(g.nodeList.get(1));
//        g.print(new PrintWriter(System.out));
    }
}
