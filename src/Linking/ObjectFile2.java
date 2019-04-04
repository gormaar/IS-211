package Linking;

import java.util.Set;
import java.util.List;

/** Objektene som implementerer dette interface representerer
 * objektfiler (hovedprogrammet eller biblioteksfiler.
 * Klassen er identisk med ObjectFile1, eneste forskjell er
 * getExternalReferences() kan returnere ei liste av funksjoner
 * i stedet for null for biblioteksfilene */
public interface ObjectFile2
{
    public List<String> getDefinedFunctions();
    public Set<String> getExternalReferences();
}
