package ShipScheduler;

import java.util.*;

public class Port {

    LinkedList<Ship> schedule = null;


    public Port()	{

        schedule = new LinkedList<>();


    }

    private void scheduleShip(Ship ship) {

        int idealArrivalTime = (int) Math.round(ship.distance / ship.economySpeed);
        int arrivalTimeOffset = 0;
        int proposedArrivalTime = idealArrivalTime + arrivalTimeOffset;
        int speed = (int) Math.round(ship.distance / proposedArrivalTime);

        Iterator iter = schedule.iterator();

        // while(iter.hasNext()) {

           /* Ship current = iter.getCurrent();
            Ship previous = iter.getPrevious();*//*

            if (speed < (ship.economySpeed/2))	{

                Ship replacedShip = current;
                current = ship;
                scheduleShip(replacedShip);

                return;

            }

            if (current.targetArrivalTime < proposedArrivalTime)	{

                if ((current.targetArrivalTime - previous.targetArrivalTime) > 1)	{

                    ship.targetArrivalTime = proposedArrivalTime;
                    iter.insertBefore(ship);
                    return;

                }
                else if(current.targetArrivalTime == proposedArrivalTime)	{


                    arrivalTimeOffset++;
                }
            }

        }

    }*/


   /* public void assignArrivalTimes(List<Ship> ships)	{


        for (Ship ship : ships)	{

            scheduleShip(ship);

        }
    }
*/
    }
}