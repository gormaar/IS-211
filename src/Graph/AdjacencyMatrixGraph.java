package Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class AdjacencyMatrixGraph {
    List<String> nodeList;
    double[][] matrix;


    /**
     * Read a graph form file. The structure of this constructor is similar to
     * that in AdjacencyListGraph.
     *
     * @param graphFile
     */
    public AdjacencyMatrixGraph(File graphFile) {
        nodeList = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new FileReader(graphFile))) {
             Scanner scanner = new Scanner(r);
             if (!"Nodes".equals(scanner.next()))
                throw new IOException();
             int numNodes = scanner.nextInt();
             matrix = new double[numNodes][numNodes];
             for (int i = 0; i < numNodes; i++)
                for (int j = 0; j < numNodes; j++)
                    matrix[i][j] = Double.POSITIVE_INFINITY;

             for (int i = 0; i < numNodes; i++) {
                String name = scanner.next();
                nodeList.add(name);
            }

             if (!"Edges".equals(scanner.next()))
                throw new IOException();
             while (scanner.hasNext()) {
                String from = scanner.next();
                String to = scanner.next();
                double weight = scanner.nextDouble();
                int iFrom = nodeList.indexOf(from);
                int iTo = nodeList.indexOf(to);
                matrix[iFrom][iTo] = weight;
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        print(new PrintWriter(System.out));
    }


    public void print(PrintWriter out) {
        for (String n : nodeList)
            out.format(" %8s ", n);

        for (int f = 0; f < nodeList.size(); f++) {
            out.format("\n %s ", nodeList.get(f));
            for (int t = 0; t < nodeList.size(); t++)
                out.format(" %8f ", matrix[f][t]);
        }
        out.println();
        out.flush();

    }


    public void depthFirstTraversal(int s) {
        ArrayList<Integer> seen = new ArrayList<>();
        dfs(seen, s);
    }


    private void dfs(ArrayList<Integer> seen, int n) {
        seen.add(n);
        System.out.println("\nVisiting " + nodeList.get(n) + "\nSeen:");
        for (int v : seen)
            System.out.format(" %s", nodeList.get(v));

        // note the difference from AdjacencyListGraph()
        for (int t = 0; t < nodeList.size(); t++) {
            if (matrix[n][t] < Double.POSITIVE_INFINITY) {
                if (!seen.contains(t)) {
                    dfs(seen, t);
                }
            }
        }
    }


    /**
     * Breadth first traversal also has minor differences from the adjacency
     * list implementation
     *
     * @param args
     */
    public void breadthFirstTraversal(int n) {
        ArrayList<Integer> seen = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(n);
        seen.add(n);
        while (!q.isEmpty()) {
            int nn = q.removeFirst();
            // visit it
            System.out.println("Visiting " + nodeList.get(nn));
            for (int to = 0; to < nodeList.size(); to++) {
                if ((matrix[nn][to] < Double.POSITIVE_INFINITY)
                        && (!seen.contains(to))) {
                    q.addLast(to);
                    seen.add(to);
                }
            }

            // debug printout
            System.out.print("Seen: ");
            for (int sn : seen)
                System.out.print(" " + nodeList.get(sn));
            System.out.print("\n\nQueue:");

            for (int qn : q)
                System.out.print(" " + nodeList.get(qn));
            System.out.println();
        }
    }


    public static void main(String[] args) {
        File f = new File("src/testdata/graph.txt");
        AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(f);

        System.out.println("\n\n\nDFS");
        g.depthFirstTraversal(1);
        System.out.println("\n\n\nBFS");
        g.breadthFirstTraversal(1);
//        g.print(new PrintWriter(System.out));
    }
}