package Tester;

import sun.awt.image.ImageWatched;

import java.util.*;

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


    public Testing()  {

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
}
