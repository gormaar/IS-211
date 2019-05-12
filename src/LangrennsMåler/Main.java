package LangrennsMåler;

import java.util.Random;

public class Main {

    public static void main(String[] args)  {

        MaaleStasjon målestasjon = new MaaleStasjon();

        Passering p3 = new Passering(1, 9.5439);
        Passering p2 = new Passering(2, 6.0043);
        Passering p1 = new Passering(3, 5.0332);
        Passering p4 = new Passering(4, 13.5598);

        målestasjon.NyPassering(p4);
        målestasjon.NyPassering(p1);
        målestasjon.NyPassering(p2);
        målestasjon.NyPassering(p3);

        målestasjon.resultatListe();

    }
}
