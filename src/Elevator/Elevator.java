package Elevator;

import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Write a description of class Elevator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Elevator {

    // Konstanter for retning
    public final static int NED = -1;
    public final static int STOP = 0;
    public static final int OPP = 1;
    private PriorityQueue<Integer> heis;

    Comparator<Integer> comp = new Comparator<Integer>() {

        public int compare(Integer etasje, Integer b)  {


            if (retning == OPP && etasje > iEtasje) {
                if ()
                return -1;
            }
            else if (retning == OPP && etasje < iEtasje)    {
                return 1;
            }
            else if (retning == NED && etasje < iEtasje)    {
                return -1;
            }
            else if (retning == NED && etasje > iEtasje)    {
                return 1;
            }
            else {
                retning = STOP;
                return 0;

            }
        }
    };


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

        heis = new PriorityQueue<>(comp);


        // opprette datastruktur oppgave 1b
    }



    /** Registrer at heisen må stoppe fordi noen vil på eller av
     * @param etasje - etasjen heisen skal stoppe i */
    public void nyttStopp(int etasje) {
        // oppgave 1c

        heis.add(etasje);

        int head = heis.peek();

        if (head == iEtasje) {
            retning = STOP;
            heis.poll();
    }
        System.out.println("I etasje: " + iEtasje + " --- Neste stop: " + head + ". etasje");

    }

    /** Flytter heisen en etasje opp eller ned. Heisen fortsetter i
     * samme retning så lenge det er ønsker om stopp i den retningen.
     * Heisen snur (begynner å gå den andre veien)når det ikke er flere
     * ønsker igjen i bevegelsesretningen.
     * @return etasjen heisen har flyttet til */

    public int flytt() {
        // oppgave 1d


            while (!heis.isEmpty()) {
                int neste = heis.peek();

                if (neste > iEtasje) {
                    retning = OPP;
                    iEtasje++;

                    if (neste == iEtasje) {
                        heis.poll();
                    }

                } else if (neste < iEtasje) {
                    retning = NED;
                    iEtasje--;

                    if (neste == iEtasje) {
                        heis.poll();
                    }

                } else {
                    retning = STOP;

                }
            }


        /*if (heis.isEmpty()) {
            iEtasje = 0;
            retning = OPP;
            System.out.println("Ingen nye stop-requests. Heisen stopper på bunnen: " + iEtasje);
        }*/
            //System.out.println("Flytter " + retning);

            //System.out.println(heis);
            //System.out.println("Etasje: " + iEtasje + " --- Neste stop: " + heis.peek());
            return 0;


      }
    }

