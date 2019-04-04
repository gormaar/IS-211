package Linking;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.lang.reflect.Method;




/**
 * The linker
 */
public class Linker1 implements Library1, ObjectFile1 {
    /**
     * Datastrukturer (opg 1a) - enten her...
     * 1a)
     *
     */

    private List<Library1> libraries;
    private HashMap<String, List<ObjectFile1>> map;
    private List<String> definedFunctions;



    public Linker1()    {
        map = new HashMap<>();
        libraries = new ArrayList<>();
        definedFunctions = new ArrayList<>();
    }

    public String getDefinedFunction()  {

        Class classobj = Linker1.class;
        Method[] methods = classobj.getMethods();


        for (Method method : methods) {
            return method.getName();
        }
        return null;
    }

    public Set<String> getExternalReferences()  {
return null;
    }

    public ObjectFile1 getObjectFile(String function)   {
        return null;
    }


    /**
     * Denne metoden går gjennom bibliotekene (og finner objektfilene som
     * definerer de metodene som er brukt i hovedprogrammet
     *
     * @param mainProgram hovedprogrammet
     * @param libraries bibliotekene linker skal søke i
     * @return liste som inneholder de objektfilene som må være med for å få
     * definert alle funksjoner som blir brukt i hovedprogrammet
     */
    public Set<ObjectFile1> resolveReferences(ObjectFile1 mainProgram, List<Library1> libraries)
            throws Exception {
        /**
         * Skriv ferdig metoden (opg 1b)
         */
        return null;
    }
}

