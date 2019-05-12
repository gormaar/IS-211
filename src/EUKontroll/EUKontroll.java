package EUKontroll;

import java.util.*;

public class EUKontroll {

    private LinkedList<Kjøretøy> inkallingsListe;
    private Queue<Kjøretøy> kontrollerteKjøretøy;

    public EUKontroll() {

        inkallingsListe = new LinkedList<>();
        kontrollerteKjøretøy = new LinkedList<>();

    }

    public Kjøretøy hentNesteKjøretøy() {

        return kontrollerteKjøretøy.poll();
    }

    public TimeReservasjon finnTime(Kjøretøy k) {





    }
}
