package ShipScheduler;

import java.util.LinkedList;
import java.util.List;

public class Ship {

    public String id;
    public double economySpeed;
    public double distance;
    public int targetArrivalTime;
    private LinkedList<Ship> linkedShips;

    public Ship() {

        linkedShips = new LinkedList<>();

    }

    public void setTargetArrivalTime(int targetArrivalTime) {
        this.targetArrivalTime = targetArrivalTime;

    }

    public void targetArrivalTime(List<Ship> shipList) {

        for (Ship ship : shipList) {

            int time = (int)Math.round(ship.distance / ship.economySpeed);
            int lastShip = linkedShips.getLast().targetArrivalTime;

            if (time > lastShip) {

                setTargetArrivalTime(time);
                linkedShips.add(ship);

            }
            else if (time < lastShip) {

                int newTime = lastShip + 1;
                setTargetArrivalTime(newTime);


            }
            else {

                int newTime = lastShip +1;
                setTargetArrivalTime(newTime);

            }
        }
    }
}