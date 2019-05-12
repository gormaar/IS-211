package Brukerstøtte;

import java.util.LinkedList;
import java.util.Queue;

public class HenvendelseDB {

    private Queue<Henvendelse> queue;

    public HenvendelseDB()	{
        queue = new LinkedList<>();
    }

    public void leggInn(Henvendelse h) {
        queue.add(h);
    }
    public Henvendelse taUtFørste()	{
        return queue.poll();
    }

    public Henvendelse seFørste()	{
        return queue.peek();


    }

    public Henvendelse seNeste()	{

        int n = 0;

        for (Henvendelse h : queue) {
            if (n == 1) return h;
            else {
                n++;
            }
        }
            return null;
    }
}

