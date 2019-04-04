package Elevator;

import java.util.PriorityQueue;

/**
 * Write a description of class Elevator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Elevator implements Comparable<Integer>
{
    // Konstanter for retning
    public final static int NED = -1;
    public final static int STOP = 0;
    public static final int OPP = 1;

    PriorityQueue<Integer> heis;

    /** Totalt antall etasjer, nederste etasje er 0,
     * øverste er antEtasjer - 1 */
    int antEtasjer;

    /** Etasjen heisen er i nå */
    int iEtasje;

    /** Retningen heisen beveger seg i */
    int retning;

    /** Datastruktur oppgave 1b */

    public Elevator(int antEtasjer) {
        this.antEtasjer = antEtasjer;
        iEtasje = 0;
        retning = OPP;
        heis = new PriorityQueue<>();

        // opprette datastruktur oppgave 1b
    }

    public int compareTo()  {
        return 4;
    }

    /** Registrer at heisen må stoppe fordi noen vil på eller av
     * @param etasje - etasjen heisen skal stoppe i */
    public void nyttStopp(int etasje) {
        // oppgave 1c
    }

    /** Flytter heisen en etasje opp eller ned. Heisen fortsetter i
     * samme retning så lenge det er ønsker om stopp i den retningen.
     * Heisen snur (begynner å gå den andre veien)når det ikke er flere
     * ønsker igjen i bevegelsesretningen.
     * @return etasjen heisen har flyttet til */
    public int flytt() {
        // oppgave 1d
        return iEtasje;
    }
}
