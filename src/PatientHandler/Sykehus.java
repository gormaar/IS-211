package PatientHandler;
import java.util.*;

public class Sykehus {
    //Deklarasjoner av datastruktur(er)
    //oppgave 1b
    //oppgave 1a - Jeg vil bruke Queue fordi den første pasienten inn, blir også den første pasienten ut
    //oppgave 2a - Jeg vil bruke PriorityQueue fordi datastrukturen holder pasienter i en kø, hvor pasientene kan prioriteres
    private Queue<Pasient> pasientKø;
    private PriorityQueue<Pasient> pKø;

    public Sykehus()    {
        //oppgave 1b
        pasientKø = new LinkedList<Pasient>();
        pKø = new PriorityQueue<>();


    }

    public void nyHenvisning(Pasient p) {
        //oppgave 1c

        pKø.add(p);
        System.out.println("Pasient: " + p + " har blitt plassert i køen");

        }


    public Pasient hentNestePasient()   {


        while (!pKø.isEmpty()) {
            Pasient nesteP = pKø.poll();
            System.out.println("Neste pasient: " + nesteP);

        }
        return null;
    }


    public void behandleNestePasient()  {

        /*Pasient p = hentNestePasient();
        *//*opererPaa(p);
        skrivUt(p);*/


    }
}
