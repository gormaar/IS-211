package Regatta;

import java.util.*;

public class Race {

    private ArrayList<Boat> premature;
    private ArrayList<Boat> finish;
    private ArrayList<Boat> participants;
    private int raceNr;
    private Boat boat;

        public Race(int raceNr, ArrayList<Boat> participants)   {

            this.participants = participants;
            finish = new ArrayList<>();
            premature = new ArrayList<>();

        }

        public void premature(Boat boat) {

            this.boat = boat;
            boat.setPoints(participants.size() + 1);
            premature.add(boat);

        }

        public int getRaceNr()  {
            return raceNr;
        }



        public void målgang(Boat boat, int raceNr)  {


            this.raceNr = raceNr;
            this.boat = boat;

            finish.add(boat);
            int size = finish.size();
            boat.setPoints(size);

        }


}
