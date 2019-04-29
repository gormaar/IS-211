package BusSimulator;

import java.util.LinkedList;
import java.util.Queue;

/** BusStop representerer en holdeplass */
public class BusStop {
    int id; // unik id – samme verdi som objektets indeks
    // i Arrayen BusSim.instance.stop
// datastruktur – oppgave 2c

    private Queue<Passenger> queue;

    public BusStop(int id) {

        this.id = id;
        queue = new LinkedList<>();

    }

    public void add(Passenger p)    {
        queue.add(p);
    }

    public Passenger next() {
        return queue.poll();
    }

    public boolean isEmpty()    {
        return queue.isEmpty();
    }

}



