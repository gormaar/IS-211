package PatientHandler;


import java.util.Comparator;

public class Pasient implements Comparable<Pasient>   {

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

    public int compareTo(Pasient p)  {

        if (this.getGruppe().equals(p.getGruppe())) {
            if (this.erYrkesaktiv() == p.erYrkesaktiv())    {
                if (this.henvistFør == p.henvistFør)    {
                    return 0;
                }
                else if (this.henvistFør && !p.henvistFør)  {
                    return -1;
                }
                else{
                    return 1;
                }
            }
            else if (this.erYrkesaktiv() && !p.erYrkesaktiv())  {
                return -1;
            }
            else {
                return 1;
            }
        }
        else if (this.getGruppe().equals("C") && p.getGruppe().equals("A"))  {
            return -1;
        }
        else if (this.getGruppe().equals("C") && p.getGruppe().equals("B")) {
            return -1;
        }
        else if (this.getGruppe().equals("B") && p.getGruppe().equals("A")) {
            return -1;
        }
        else {
            return 1;
        }

    }


    public boolean prioritertForan(Pasient p)    {

        if (this.getGruppe().equals("C") && p.getGruppe().equals("B"))  {
            return true;
        }
        else if (this.getGruppe().equals("C") && p.getGruppe().equals("A")) {
            return true;
        }
        else if (this.getGruppe().equals("B") && p.getGruppe().equals("A")) {
            return true;
        }
        else if (this.getGruppe().equals(p.getGruppe()))    {
            if (this.yrkesaktiv && !p.yrkesaktiv)   {
                return true;
            }
            else if (this.yrkesaktiv == p.yrkesaktiv)   {
                if (this.henvistFør && !p.henvistFør) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public String toString()    {
        return "Navn: " + navn + " Alder: " + alder +
                " Gruppe: " + getGruppe() + " Yrkesaktiv: "
                + yrkesaktiv + " Henvist før: " + henvistFør;
    }
}
