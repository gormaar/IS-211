package Linking;


/** Denne var vedlagt oppgaven */


/** represents a library of object files */
public interface Library1
{
    /** find the object file that defines the named function
     return null if not found */
    public ObjectFile1 getObjectFile(String function);

}