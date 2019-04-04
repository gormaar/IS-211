package Linking;

/** represents a library of object files */
public interface Library2
{
    /** find the object file that defines the named function
     return null if not found */
    public ObjectFile2 getObjectFile(String function);
}