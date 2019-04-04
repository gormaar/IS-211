package PatientHandler;

public class Main {

    public static void main(String[] args){

    Sykehus sykehus = new Sykehus();
    Pasient per = new Pasient("Per", 22, "B", true, false);
    Pasient anne = new Pasient("Anne", 43, "A", false, true);
    Pasient eirik = new Pasient("Eirik", 18, "A", true, false);
    Pasient mette = new Pasient("Mette", 9, "C", false, true);
    Pasient arnold = new Pasient("Arnold", 59, "A", true, true);
    Pasient rashid = new Pasient("Rashid", 35, "C", true, false);
    Pasient ragnar = new Pasient("Ragnar", 26, "C", true, true);

    sykehus.nyHenvisning(per);
    sykehus.nyHenvisning(anne);
    sykehus.nyHenvisning(eirik);
    sykehus.nyHenvisning(mette);
    sykehus.nyHenvisning(arnold);
    sykehus.nyHenvisning(rashid);
    sykehus.nyHenvisning(ragnar);

    sykehus.hentNestePasient();

    }
}
