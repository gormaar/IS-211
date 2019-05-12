package EUKontroll;

import java.util.*;

public class TimeReservasjon {

    int kalender [][];
    String mekaniker;
    List<TimeReservasjon> resListe;
    public TimeReservasjon()    {

        kalender = new int[30][12];
        resListe = new ArrayList<>();
        kalender[5][5] = 2;



    }

}
