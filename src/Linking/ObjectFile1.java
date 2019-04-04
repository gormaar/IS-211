package Linking;

import java.util.Set;

/** Denne var vedlagt oppgaven */
/**
 * Java representation of compiled (object) files
 */
public interface ObjectFile1
{
    /** return the name of the (single) function defined in this object file */
    public String getDefinedFunction();

    /** return a set of the names of external references */
    public Set<String> getExternalReferences();
}




