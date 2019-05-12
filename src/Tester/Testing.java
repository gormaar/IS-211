package Tester;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Testing {

    private Hashtable hashtable;
    private HashSet<Integer> hashSet;
    private HashMap<Integer, String> hashMap;
    private LinkedList<Integer> linkedList;
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private String[] things = {"apples", "noobs", "pwnage", "bacon", "goats"};
    private List<String> list1;
    private List<String> list2;
    private String[] things2 = {"sausage", "bacon", "goats", "harrypotter"};
    private HashMap<String, Fylke> graph;
    private ArrayBlockingQueue<Integer> queue;
    private PriorityQueue<Integer> priorityQueue;
    private Stack<Integer> stack;
    private int[] array;
    private TreeSet<Integer> treeSet;


    public Testing()  {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {

                return Integer.compare(o1, o2);
            }
        };

        hashtable = new Hashtable();
        hashSet = new HashSet<>();
        hashMap = new HashMap<>();
        linkedList = new LinkedList<>();
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2)    {
                return - Integer.compare(o1, o2);
            }
        });

        list1 = new LinkedList<>();
        list2 = new LinkedList<>();

        graph = new HashMap<>();

        queue = new ArrayBlockingQueue<Integer>(5);


        priorityQueue = new PriorityQueue<>(comparator);

        stack = new Stack<>();
        array = new int[5];

        treeSet = new TreeSet<>();
    }

    public void setTreeSet()    {

        treeSet.add(5);
        treeSet.add(20);
        treeSet.add(11);
        treeSet.add(9);

        for (Integer i : treeSet)   {
            System.out.println(i);

        }

        System.out.println(treeSet.first());


    }

    public void setArray()  {

        array[0] = 1;
        array[3] = 4;
        array[4] = 5;
        array[2] = 3;
        array[1] = 2;

        for (Integer i : array) {

            System.out.println(i);


        }
    }

    private int find(int v, int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int m = (lo + hi) / 2;
        if (v < a[m]) return find(v, a, lo, m - 1);
        if (v > a[m]) return find(v, a, m + 1, hi);
        return m; // v == a[m]
    }

    public int findIndex(int v, int[] a)    {
        return find(v, a, 19, a.length -1);
    }

    public void setQueue() {

        queue.add(1);
        queue.offer(6);
        queue.offer(8);
        queue.offer(2);
        queue.offer(8);
        queue.offer(19);

        System.out.println(queue);


    }

    public Integer seNeste()    {
        int i = 0;
        for (Integer h : queue) {
            if (i == 1) return h;
            i++;
        }
        return null;
    }

    public void setHashtable()   {

        hashtable.put(1,"a");
        hashtable.put(2, "b");
        hashtable.get(2);

        System.out.println(hashtable);

    }

    public void setHashSet()    {

        int size = hashSet.size();

        hashSet.add(1);
        hashSet.add(2);

        boolean empty = hashSet.isEmpty();

        boolean a = hashSet.contains(1);

        System.out.println(hashSet);
        hashSet.clear();
        System.out.println(hashSet);
    }

    public void setHashMap()    {

        hashMap.put(1, "a");
        hashMap.put(2, "b");
        hashMap.put(3, "c");

        boolean value = hashMap.containsValue("a");
        boolean value2 = hashMap.containsValue("d");
        boolean key = hashMap.containsKey(3);

        hashMap.get(2);

        Collection<String> values = hashMap.values();

        System.out.println(values);


    }

    public void setLinkedList() {

        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(3);
        linkedList.add(2);

        System.out.println(linkedList.indexOf(3));

        System.out.println(linkedList.peek());
        System.out.println(linkedList);
        linkedList.poll();
        System.out.println(linkedList.peek());

        linkedList.add(1, 15);
        linkedList.addLast(9);
        System.out.println(linkedList);

        linkedList.pop();

        System.out.println(linkedList);

        int prev = linkedList.listIterator(1).previous();

        System.out.println("Previous: " + prev);

        for (String z : things) {
            list1.add(z);
        }

        for (String y : things2)    {
            list2.add(y);
        }

        list1.addAll(list2);
        list2 = null;

       /* printMe(list1);
        removeStuff(list1, 2, 5);
        reverseMe(list1);*/

       linkedList.sort(Integer::compareTo);

    }

    public void setMaxHeap() {

        maxHeap.add(15);
        maxHeap.add(5);
        maxHeap.add(3);
        maxHeap.add(8);
        maxHeap.add(2);
        maxHeap.add(6);
        maxHeap.add(7);
        maxHeap.add(10);

        System.out.println(maxHeap);

        System.out.println(maxHeap.peek());


    }

    public void setMinHeap() {


        minHeap.add(15);
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(6);
        minHeap.add(9);

        System.out.println(minHeap);
        System.out.println(minHeap.peek());

    }

    public void setGraph()  {


        Fylke rogaland = new Fylke("Rogaland");
        Fylke hordaland = new Fylke("Hordaland");
        Fylke vestAgder = new Fylke("Vest-Agder");
        Fylke austAgder = new Fylke("Aust-Agder");
        Fylke telemark = new Fylke("Telemark");
        Fylke sognOgFjordane = new Fylke("Sogn og Fjordane");
        Fylke buskerud = new Fylke("Buskerud");

        rogaland.addAdjFylke(hordaland);
        rogaland.addAdjFylke(vestAgder);
        rogaland.addAdjFylke(austAgder);
        rogaland.addAdjFylke(telemark);

        hordaland.addAdjFylke(rogaland);
        hordaland.addAdjFylke(sognOgFjordane);
        hordaland.addAdjFylke(buskerud);
        hordaland.addAdjFylke(telemark);

        vestAgder.addAdjFylke(austAgder);



        graph.put("Rogaland", rogaland);
        graph.put("Hordaland", hordaland);
        graph.put("Vest-Agder", vestAgder);

        //System.out.println(graph);

        List<Fylke> list = rogaland.getAdjFylker();
        System.out.println("Rogaland grenser til: ");
        for (Fylke fylke : list)    {

            System.out.println(fylke.getName());
        }
    }

    public void setPriorityQueue()  {

        priorityQueue.add(6);
        priorityQueue.add(4);
        priorityQueue.add(13);
        priorityQueue.add(8);

        priorityQueue.add(7);
        priorityQueue.remove();

        Comparator comp = priorityQueue.comparator();
        System.out.println(comp);
        System.out.println(priorityQueue);

    }
}
