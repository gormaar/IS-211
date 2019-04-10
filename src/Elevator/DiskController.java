package Elevator;


import java.util.LinkedList;
import java.util.Queue;



/** Enkel simulering av en diskcontroller som bruker n-step-scan */


public class DiskController {
    // Køen av leseønsker
    // Nye ønsker som kommer inn legges på magisk vis sist i denne køen

    /*
    3a)
    Her ville det vært lurt å bruke en algoritme som sorterer arrayet i stigende rekkefølge
    En kan da bruke Timesort eller Mergesort fordi disse er gode på time complexity
    Bucket Sort, Radix Sort, Counting Sort
     */
    private LinkedList<Integer> queue;
    private Queue<Integer> opp;
    private Queue<Integer> ned;



    // Antall ønsker som behandles av gangen
    private final int N;

    // Sektoren hvor lesehodet er nå
    private int currentCylinder;
    /** Konstruktøren setter opp objektet */
    public DiskController(int n) {
        N = n;
        queue = new LinkedList<>();
        opp = new LinkedList<>();
        ned = new LinkedList<>();

        currentCylinder = 5;

    }

    /** Legg til et ønske om å lese fra en bestemt sylinder
     * Kalles på magisk vis fra prosessene som vil lese filer */
    public void newRequest(int cylinder) {
        queue.add(cylinder);
    }
    /** Kalles for å start controlleren */
    public void run() {
        while (true) {
            // Hent N ønsker fra køen
            queue.add(1);
            queue.add(7);
            queue.add(2);
            queue.add(3);
            queue.add(10);

            queue.add(1);
            queue.add(2);
            queue.add(9);
            queue.add(1);
            queue.add(6);
            int[] buf = new int[N];
            for (int i=0; !queue.isEmpty() && i<N; i++) {
                buf[i] = queue.remove();
            }
            scan(buf);

        }
    }

    /** Behandler leseønskene ved å kalle read() for hvert ønske.
     * Flytter lesehodet minst mulig mellom hvert kall på read().
     * @param buf - array med cylindenr det skal leses fra */
    private void scan(int[] buf) {
        // oppgave 3

        for (Integer cylinder : buf)    {

            if (cylinder > currentCylinder) {
                opp.add(cylinder);
            }
            else {
                ned.add(cylinder);
            }
        }

        while (!opp.isEmpty())  {
            System.out.println("Opp " + opp);
            move(opp.poll());
            read();

        }

        System.out.println("Ferdig lest opp-kø\n");
        while (!ned.isEmpty())  {
            System.out.println("Ned " + ned);
            move(ned.poll());
            read();

        }
        System.out.println("Ferdig lest ned-kø\n");
        currentCylinder = 5;

        System.out.println("Ferdig scannet buffer \n\n");
    }

    /** Simulerer flytting av lesehodet.
     * @param cylinder - sylindernummeret.
     */
    private void move(int cylinder) {
        if (cylinder != currentCylinder) {
            System.out.println("Flytter lesehodet til sylinder "+cylinder);
            currentCylinder = cylinder;
        }
    }

    /** Simulerer lesing av en fil */
    private void read() {
        System.out.println("Leser fil fra sylinder "+currentCylinder);
    }
}