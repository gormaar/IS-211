package PatientHandler;


import java.util.Comparator;

public class Pasient implements Comparable<Pasient>  {

    private String navn;
    private int alder;
    private String gruppe;
    private boolean yrkesaktiv;
    private boolean henvistFør;



    public Pasient(String navn, int alder, String gruppe, boolean yrkesaktiv, boolean henvistFør)    {
        this.navn = navn;
        this.alder = alder;
        this.gruppe = gruppe;
        this.henvistFør = henvistFør;
        this.yrkesaktiv = yrkesaktiv;

    }

    public String getGruppe()   {
        return gruppe;
    }

    public boolean erYrkesaktiv()   {
        return yrkesaktiv;
    }

    public boolean henvistFør(Pasient p) {
        return henvistFør;
    }


    public int compareTo(Pasient p) {

        String thispasient = this.getGruppe();
        Integer.parseInt(thispasient);
        String patient = p.getGruppe();
        Integer.parseInt(patient);

        return 0;
    }


    public boolean prioritertForan(Pasient p)    {



        return true;

    }
}
