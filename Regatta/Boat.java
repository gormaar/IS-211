package Regatta;

import java.util.*;

public class Boat {

    private String name;
    private int boatNr;
    private ArrayList<Integer> results = new ArrayList<>();
    private int points;

    public Boat(String name, int boatNr)    {

        this.name = name;
        this.boatNr = boatNr;

   }

   public int getSailNr()   {return boatNr;}

   public ArrayList<Integer> getResults()   {
        return results;
   }

   public void setPoints(int points) {
        this.points += points;
        results.add(points);
   }


   public int getPoints()    {
       return points;
   }

   public String toString() {
        String point = "" + points;
        String nr = "" + boatNr;
        return point + " " + nr;
   }
}
