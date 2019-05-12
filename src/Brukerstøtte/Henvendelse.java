package Brukerstøtte;


public class Henvendelse  {

    public String brukernavn;
    public String arbeidsplass;
    public String problemBeskrivelse;

    public String toString()    {
        return ("Brukernavn: " + brukernavn + "\n Arbeidsplass: " + arbeidsplass + "\n Problembeskrivelse: " + problemBeskrivelse);
    }
}

