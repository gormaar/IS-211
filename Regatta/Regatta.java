package Regatta;

import java.util.*;

public class Regatta {

    private static ArrayList<Boat> participants;
    private static ArrayList<Race> races;


    public Regatta()
    {
        participants = new ArrayList<>();
        races = new ArrayList<>();

    }

    public void enter(Boat boat) {
        participants.add(boat);
    }

    public void race(int raceNr, ArrayList<Boat> participants)  {

        Race race = new Race(raceNr, participants);
        races.add(race);

    }

    public void finalResult()   {

            participants.sort(Comparator.comparing(Boat::getPoints));
            int place = 1;
            for (Boat boat : participants)  {
               System.out.println("Place: " + place + " ---" + " Boatnumber: "
                       + boat.getSailNr() + " ---" + " Race results: "
                       + boat.getResults() + " ---" + " Sum: " + boat.getPoints());

                place++;
            }
    }

    public void simulator() {


        for (int i = 0; i < 10; i++) {

            Boat boat = new Boat("båt", i);
            enter(boat);

        }
            race(1, participants);
            race(2, participants);
            race(3, participants);

        Random random = new Random();

        int num = 90;

            for (Race race : races) {

                ArrayList<Boat> clone = (ArrayList<Boat>) participants.clone();
                Collections.shuffle(clone);

                for (Boat boat : clone) {

                    if (num < random.nextInt(100))    {

                        race.premature(boat);
                    }

                    race.målgang(boat, race.getRaceNr());

                }

            }

        finalResult();
    }
}
