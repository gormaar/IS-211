package BusSimulator;

import java.util.ArrayList;

// Minimal representasjon av en buss
public class Bus {
    // Maks antal passasjerer bussen kan ta

    public static final int MAX_PASS = 40;
    public int id;
    public int numPass;
    public ArrayList<Passenger>[] passengerList;
    private static int nextId;

    public Bus() {
    //oppgave 2c

        numPass = 0;
        id = nextId++;
        passengerList = new ArrayList[BusSim.NUM_STOPS+1];
        for (int i = 0; i <= BusSim.NUM_STOPS; i++) {
            passengerList[i] = new ArrayList<>();
        }
    }

    /** Simuler et stop på holdeplass stopNum, på tidspunktet t */
    public void makeStop(int stopNum, int t) {
        // henter simulator-objektet, og BustStop-objektet som representerer holdeplassen

        int leaving = passengerList[stopNum].size();
        passengerList[stopNum].clear();
        numPass -= leaving;

        BusSim sim = BusSim.instance;
        int busStop = sim.stop[stopNum];
        int boarded = 0;
    /*    while(!busStop.isEmpty() && numPass < MAX_PASS) {

            add(busStop.next());
            boarded++;
        }


        // oppgave2d
    }

    // andre metoder – oppgave 2c


    public void passengerLeave(Passenger p)    {
        passengerList.remove(p);
    }

    public void add(Passenger p)    {
        passengerList[p.toStop].add(p);
        numPass++;
    }*/
    }
}

