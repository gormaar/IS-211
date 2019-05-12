package LangrennsMåler;

public class Passering implements Comparable<Passering>  {

    public final int startnr;
    public final double tid;


    public Passering(int startnr, double tid)	{
        this.startnr = startnr;
        this.tid = tid;
    }

    public int compareTo(Passering p)  {
        return (int)(this.tid - p.tid);
    }



    public double getTid() {
        return tid;
    }

    public int getStartnr() {
        return startnr;
    }



}