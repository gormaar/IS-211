package Linking;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class Linker2
{
    /** Datastrukturer (opg 2a) - enten her... */

    /** Denne metoden går gjennom bibliotekene (og finner objektfilene
     * som definerer de metodene som er brukt i hovedprogrammet
     * @param mainProgram hovedprogrammet
     * @param libraries bibliotekene linker skal søke i
     * @return liste som inneholder de objektfilene som må være med
     * for å få definert alle funksjoner som blir brukt i hovedprogrammet
     */
    public Set<ObjectFile2> resolveReferences(ObjectFile2 mainProgram, List<Library2> libraries) {
        /* Vedlegget til oppgaven slutter her */
        /* Igjen kan vi velge å gå gjennom funksjonene først,
         * eller bibliotekene først, vi kan også velge mellom
         * dybde-først eller bredde-først traversering  av den
         * grafen vi får fra avhengighetene mellom funksjonene.
         * Det gir fire teoretiske muligheter. Jeg har bare laget to:
         * alt1 går gjennom funksjoner først - dybde-først
         * alt2 går gjennom biblioter først - bredde-først
         */

        Set<ObjectFile2> objFiles;
        objFiles = resolveRefsAlt1(ObjectFile2 mainProgram,
                List<Library2> libraries);
        objFiles = resolveRefsAlt2(ObjectFile2 mainProgram,
                List<Library2> libraries);
    }

    /** alternativ 1 */
    resolveRefsAlt1(ObjectFile2 mainProgram, List<Libary2> libs) {
        Set<String> functions = mainProgram.getUnresolvedReferences();
        HashMap<String,ObjectFile2> resolutions = new HashMap<>();

        for (String fun : functions) {
            resolveFunction(fun, libs, resolutions);
        }
    }

    private void resolveFunction(String fun,
                                 List<Library> libs,
                                 HashMap<String,ObjectFile2> resolutions) {
        if (resolutions.get(fun) != null) return;

        for (Library2 lib : libs) {
            ObjectFile obj = lib.getObjectFile(fun);
            if (obj != null) {
                resolutions.put(fun, obj);
                for (String newFun : obj.getExternalReferences()) {
                    resolveFunction(newFun, libs, resolutions);
                }
                return;
            }
        }
    }

    /** alternativ 2 */

    HashSet<ObjectFile2> objectFiles = new HashSet<>();
    for (String fun : mainProgram.getExternalReferences()) {
    resolveFunction(fun, libraries, objectFiles);
}
    return objectFiles;
}


    private void resolveFunction(String fun,
                                 List<Library2> libraries,
                                 HashSet<ObjectFile2> objectFiles) {
        for (ObjectFile2 obj : objectFiles) {
            if (obj.getDefinedFunctions().contains(fun)) return;
        }
        for (Library2 lib : libraries) {
            ObjectFile2 obj = lib.getObjectFile(fun);
            if (obj != null) {
                objectFiles.add(obj);
                for (String external : obj.getExternalReferences()) {
                    resolveFunction(external, libraries, objectFiles);
                }
                return;
            }

        }
/** this is a linking error */
        throw new Error("Unable to resolve "+fun);
    }

}
