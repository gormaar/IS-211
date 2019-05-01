package Node3D;

import java.util.List;
/**
 * Representasjon av en 3D modell av verden.
 */
public interface Node3D
{
    /** Returnerer barna til denne noden */
    List<Node3D> getChildren();


    /** Returnerer true hvis noden eller deler av den
     * er i synsfeltet. */
    boolean isVisible();


    // Disse metodene kan brukes i Painter's algorithm

    /** Returnerer avstanden fra synspunktet ("øyet") i meter */
    double getDistance();


    /** Viser noden på skjermen. Denne metoden kopierer alle
     * pikslene direkte til skjermen. */
    void paint();


    // Disse methodene kan brukes med z-buffering

    /** Disse metodene antar at alle nodene dekker et
     * firkantet område av skjermen, og returner
     * pikselkoordinatene til sidene av firkanten. */
    int getMinX();
    int getMaxX();
    int getMinY();
    int getMaxY();

    /** Returnerer avstanden fra synspunktet til den delen av
     * denne noden som vises i et bestemt piksel.
     * Returnerer Double.POSITIVE_INFINITY hvis x,y er utenfor
     * området noden dekker. */
    double getDistance(int x, int y);


    /** Returnerer fargen som skal vises i et bestemt piksel.
     * Returnerer en tilfeldig farge hvis x,y er utenfor
     * området noden dekker. */
    int getColour(int x, int y);
}
