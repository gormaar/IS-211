package Tester;

import java.util.ArrayList;
import java.util.List;

public class Fylke {

    private String name;
    private int weight;
    private ArrayList<Fylke> adjList;

    public Fylke(String name)   {

        this.name = name;
        adjList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void addAdjFylke(Fylke fylke)   {
        adjList.add(fylke);
    }

    public List<Fylke> getAdjFylker()  {

        return adjList;


    }
}

