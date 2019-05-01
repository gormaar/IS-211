package Tester;

import java.util.HashSet;

public class Sets {

    private HashSet<Integer> set;
    private int a, b, c;

    public Sets()   {
        set = new HashSet<>();
        a = 1;
        b = 2;
        c = 5;
    }

    public void useSet()    {


        int size = set.size();

        for (int i = 0; i < 8; i++) {

            set.add(a);
            a++;
            System.out.println(set);

            if (a == 5) {
                break;
            }
        }




    }
}
