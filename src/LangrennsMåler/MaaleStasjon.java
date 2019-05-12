package LangrennsMåler;

import java.util.*;

public class MaaleStasjon {

    private PriorityQueue<Passering> prioqueue;


    public MaaleStasjon()	{

        prioqueue = new PriorityQueue<>();

    }


    public void resultatListe()	{


        while(!prioqueue.isEmpty()) {
            System.out.println("Startnr: " + prioqueue.peek().getStartnr() + " ---- Tid: " + prioqueue.peek().getTid());
            prioqueue.poll();
        }

    }

    public void NyPassering(Passering p)	{

       prioqueue.add(p);

    }
}