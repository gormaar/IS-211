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

        Pasient pasient1 = new Pasient("Fredrik", 28, "B", true, false);
        Pasient pasient2 = new Pasient("Petter", 52, "B", false, false);
        Pasient pasient3 = new Pasient("Ingrid", 37, "C", true, true);

    }

    public void nyHenvisning(Pasient p) {
        //oppgave 1c

        pasientKø.add(p);
        System.out.println("Pasient: " + p + " har blitt plassert i køen");

    }

    public Pasient hentNestePasient()   {

        Pasient hentetPasient = pasientKø.remove();
        System.out.println("Pasient " + hentetPasient + " har blitt hentet");
        return hentetPasient;


    }

    public void behandleNestePasient()  {

        /*Pasient p = hentNestePasient();
        opererPaa(p);
        skrivUt(p);*/
    }
}
