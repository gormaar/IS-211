package Tester;

import java.util.ArrayList;

import static java.util.Arrays.sort;

public class Main {

    public static void main(String[] args) {


        MST mst = new MST();
        ArrayList<MST.Node> node1List = new ArrayList<>();
        ArrayList<MST.Node> node2List = new ArrayList<>();
        ArrayList<MST.Node> node3List = new ArrayList<>();

        MST.Node node1 = new MST.Node(1);
        MST.Node node2 = new MST.Node(2);
        MST.Node node3 = new MST.Node(3);



        node1List.add(node2);
        node1List.add(node3);
        node2List.add(node1);
        node2List.add(node3);
        node3List.add(node1);
        node3List.add(node2);


        mst.nodeMap.put(2, node2List);
        mst.nodeMap.put(1, node1List);
        mst.nodeMap.put(3, node3List);

        mst.printGraph();




    }
}
