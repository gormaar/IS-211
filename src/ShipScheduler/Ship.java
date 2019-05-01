package ShipScheduler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
1a) Jeg vil bruke kø
 */
public class Ship {
    /** Unique id, e.g. name or callsign */
    public String id;
    /** Max economical speed in knots */
    public double economySpeed;
    /** Distance from the port in nautical miles
     * You can assume this is set automatically,
     * e.g. by a satellite surveillance system. */
    public double distance;
    /** Arrival time assigned by the system */
    public int targetArrivalTime;
    private Queue<Ship> shipQueue;
    private List<Ship> shipList;

    public Ship()   {

        shipQueue = new LinkedList<>();
        shipList = new ArrayList<>();
        Ship ship1 = new Ship();
        Ship ship2 = new Ship();
        Ship ship3 = new Ship();

        shipList.add(ship1);
        shipList.add(ship2);
        shipList.add(ship3);
    }

    public void scheduler(List shipList)    {

       /* for (Ship ship : shipList)  {

        }*/

    }
}

