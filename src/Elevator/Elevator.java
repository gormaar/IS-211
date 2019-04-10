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

    private Comparator<Integer> comp = new Comparator<Integer>() {

        public int compare(Integer etasje, Integer b)  {

            int minusEtasje = etasje - iEtasje;
            int minusb = b - iEtasje;

            if (retning == OPP && etasje > iEtasje && b > iEtasje) {
                if (minusEtasje < minusb)   {
                    return -1;
                }
                else if (minusEtasje > minusb) {
                    return 1;
                }
                else {
                    return 0;
                }
            }

            else if (retning == OPP && etasje > iEtasje && b < iEtasje) {
                return -1;
            }
            else if (retning == OPP && etasje < iEtasje && b > iEtasje) {
                return 1;
            }

            else if (retning == OPP && etasje < iEtasje && b < iEtasje) {
                if (minusEtasje > minusb)   {
                    return -1;
                }
                else if (minusEtasje < minusb)  {
                    return -1;
                }
                else {
                    return 0;
                }
            }

            else if (retning == NED && etasje < iEtasje && b < iEtasje)    {
                if (minusEtasje > minusb)   {
                    return -1;
                }
                else if (minusEtasje < minusb)  {
                    return 1;
                }
                else {
                    return 0;
                }
            }
            else if (retning == NED && etasje > iEtasje && b > iEtasje)    {
                if (minusEtasje < minusb)   {
                    return -1;
                }
                else if (minusEtasje > minusb)  {
                    return 1;
                }
                else {
                    return 0;
                }
            }
            else if (retning == NED && etasje < iEtasje && b > iEtasje) {
                return -1;
            }
            else if (retning == NED && etasje > iEtasje && b < iEtasje) {
                return 1;
            }
            else {
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
        System.out.println("Stop har blitt registrert i etasje: " + etasje);



        System.out.println("I etasje: " + iEtasje + " --- Neste stop: " + heis.peek() + ". etasje");

        System.out.println("Kø: " + heis);
        System.out.println("Head of queue " + heis.peek());

        if (etasje == iEtasje)  {
            fjernStopp(etasje);
        }

    }

    public void fjernStopp(int etasje)  {
        System.out.println("Stopp har blitt fjernet i etasje: " + etasje);
        heis.remove(etasje);
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
                    System.out.println("Flytter en etasje opp");

                    if (neste == iEtasje) {

                        System.out.println("Fjernet stopp i etasje: " + heis.peek());
                        heis.poll();
                    }

                } else if (neste < iEtasje) {
                    retning = NED;
                    iEtasje--;
                    System.out.println("Flytter en etasje ned");

                    if (neste == iEtasje) {
                        System.out.println("Fjernet stopp i etasje: " + heis.peek());
                        heis.poll();
                    }
                } else {
                    retning = STOP;

                }
            }

            if (heis.isEmpty()) {

                iEtasje = 0;
                retning = OPP;
                System.out.println("Ingen nye stop. Heis settes i idle i etasje: " + iEtasje);
            }

            return 0;

      }
    }

    /*
    Lesehodet skal bevege seg minst mulig mellom hver fil som lese:
    Nærmeste-først-algoritmen kan føre til at det blir lang ventetid hos noen leseønsker dersom
    der er mange leseønsker som ligger nærme hverandre. Dersom det da kommer et leseønske på andre siden
    av disken vil det ta lang tid for leserhodet å komme seg dit. Derfor blir det kort ventetid
    for de som ligger nær hverandre, men lang for dem langt borte

    N-step-SCAN-algoritmen vil kjøre noe likt den vanlig elevator-algoritmen vil, men denne tar
    utgangspunkt i et stykke av hele køen. Dette vil da føre til mer jevn ventetid for hele disken
    på lik linje med den vanlige elevator algoritmen.
    Dersom det kommer leseønske men lesehode akkurat beveger seg forbi kan det også bli lang tid
    før lesehodet kommer tilbake til hvor den var

    Når det kommer til Big O vil
     */

