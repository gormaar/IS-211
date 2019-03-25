package KontaktNett;

import java.util.*;

public class KontaktNett {
    // Oppgave 1a - feltdeklarasjoner


      private ArrayList<Edge> perList;
      private ArrayList<Edge> pålList;
      private ArrayList<Edge> narrenList;
      private ArrayList<Edge> prinsessaList;
      private ArrayList<Edge> kongenList;
      private ArrayList<Edge> espenList;
      private ArrayList<Edge> commonList;
      private HashMap<String, ArrayList<Edge>> vertexMap;
      private ArrayList<String> tetteKontakter;
      private ArrayList<String> tettereKontakter;


    public KontaktNett() {
        // Oppgave 1b - constructor

        perList = new ArrayList<>();
        pålList = new ArrayList<>();
        narrenList = new ArrayList<>();
        prinsessaList = new ArrayList<>();
        kongenList = new ArrayList<>();
        espenList = new ArrayList<>();
        commonList = new ArrayList<>();
        tetteKontakter = new ArrayList<>();
        tettereKontakter = new ArrayList<>();

        vertexMap = new HashMap<>();

        Edge perPål = new Edge("Per", "Pål", 12);
        Edge perEspen = new Edge("Per", "Espen", 9);
        Edge perNarren = new Edge("Per", "Narren", 7);
        Edge pålPer = new Edge("Pål", "Per", 11);
        Edge pålNarren = new Edge("Pål", "Narren", 15);
        Edge narrenKongen = new Edge("Narren", "Kongen", 21);
        Edge narrenPrinsessa = new Edge("Narren", "Prinsessa", 19);
        Edge narrenPer = new Edge("Narren", "Per", 7);
        Edge narrenPål = new Edge("Narren", "Pål", 17);
        Edge espenPrinsessa = new Edge("Espen", "Prinsessa", 115);
        Edge prinsessaEspen = new Edge("Prinsessa", "Espen", 143);
        Edge prinsessaKongen = new Edge("Prinsessa", "Kongen", 14);
        Edge kongenPrinsessa = new Edge("Kongen", "Prinsessa", 3);

        perList.add(perPål);
        perList.add(perEspen);
        perList.add(perNarren);
        pålList.add(pålPer);
        pålList.add(pålNarren);
        narrenList.add(narrenKongen);
        narrenList.add(narrenPrinsessa);
        narrenList.add(narrenPer);
        narrenList.add(narrenPål);
        espenList.add(espenPrinsessa);
        prinsessaList.add(prinsessaEspen);
        prinsessaList.add(prinsessaKongen);
        kongenList.add(kongenPrinsessa);

        vertexMap.put("Per", perList);
        vertexMap.put("Pål", pålList);
        vertexMap.put("Narren", narrenList);
        vertexMap.put("Espen", espenList);
        vertexMap.put("Kongen", kongenList);
        vertexMap.put("Prinsessa", prinsessaList);

        }
        /**
        * Registrer en samtale i grafen
        * @param fra - navnet på personen som ringte
        * @param til - navnet på personen han ringte til
         */

        public void registrerSamtale(String fra, String til) {
            // oppgave 1c


            if (vertexMap.containsKey(fra)) {

                ArrayList<Edge> destinationList = vertexMap.get(fra);
                int edgeCount = 0;
                for (Edge e : destinationList)  {
                    if (e.getSrc().equals(fra) && e.getDest().equals(til))  {
                        e.incrementWeight();
                        System.out.println("Edge found between " + fra + " and " + til + ". Increasing weight by one");
                        System.out.println("Current weight: " + e.getWeight());
                        edgeCount++;
                    }
                }


                if (edgeCount == 0)  {

                    Edge newEdge = new Edge(fra, til, 1);

                    switch (fra) {
                        case "Per":
                            perList.add(newEdge);
                            System.out.println("New Edge created between " + fra + " and " + til);
                            System.out.println("Current weight: " + newEdge.getWeight());
                            break;
                        case "Pål":
                            pålList.add(newEdge);
                            System.out.println("New Edge created between " + fra + " and " + til + " with weight: " + newEdge.getWeight());
                            System.out.println("Current weight: " + newEdge.getWeight());
                            break;
                        case "Espen":
                            espenList.add(newEdge);
                            System.out.println("New Edge created between " + fra + " and " + til + " with weight: " + newEdge.getWeight());
                            System.out.println("Current weight: " + newEdge.getWeight());
                            break;
                        case "Narren":
                            narrenList.add(newEdge);
                            System.out.println("New Edge created between " + fra + " and " + til + " with weight: " + newEdge.getWeight());
                            System.out.println("Current weight: " + newEdge.getWeight());
                            break;
                        case "Kongen":
                            kongenList.add(newEdge);
                            System.out.println("New Edge created between " + fra + " and " + til + " with weight: " + newEdge.getWeight());
                            System.out.println("Current weight: " + newEdge.getWeight());
                            break;
                        case "Prinsessa":
                            prinsessaList.add(newEdge);
                            System.out.println("New Edge created between " + fra + " and " + til + " with weight: " + newEdge.getWeight());
                            System.out.println("Current weight: " + newEdge.getWeight());
                            break;

                    }

                }
            }
        }

            /**
             * Returner en liste over personer som en mistenkt har hatt tett kontakt med.
             * @param mistenkt - navnet på den mistenkte personen
             * @param ant - antall ganger to personer må ringt hverandre for å ha hatt tett kontakt
             */

            public List<String> finnDirekteKontakter(String mistenkt, int ant) {
                 // oppgave 2a


                        if (vertexMap.containsKey(mistenkt)) {

                            ArrayList<Edge> suspectList = vertexMap.get(mistenkt);
                            for (Edge e : suspectList) {
                                if (e.getWeight() >= ant) {
                                    tetteKontakter.add(e.getDest());
                                }
                            }
                            System.out.println(tetteKontakter);

                            return tetteKontakter;
                        }
                        return null;
                }
                /**
                 * Returner en liste over personer som en mistenkt har hatt direkte eller indirekte tett kontakt med.
                 * @param mistenkt - navnet på den mistenkte personen
                 * @param ant - antall ganger to personer må ringt hverandre
                 * for å ha hatt tett kontakt
                 */

                public List<String> finnAlleKontakter(String mistenkt, int ant) {
                    // oppgave 2b

                    if (vertexMap.containsKey(mistenkt)) {

                        ArrayList<Edge> directContact = vertexMap.get(mistenkt);
                        for (Edge edge : directContact) {


                            if (edge.getWeight() >= ant) {
                                tettereKontakter.add(edge.getDest());

                                String name = edge.getDest();

                                ArrayList<Edge> indirectContact = vertexMap.get(name);
                                for (Edge e : indirectContact) {

                                    if (!e.getDest().equals(edge.getSrc()) ) {
                                        if (e.getWeight() >= ant) {
                                            tettereKontakter.add(e.getDest());
                                        }
                                    }
                                }
                            }
                        }

                        if (!tettereKontakter.isEmpty()) {
                            System.out.println("Direkte og indirekte kontakter til " + mistenkt + " :");
                            System.out.println(tettereKontakter);
                        }
                        else    {
                            System.out.println(mistenkt + " har ingen direkte eller indirekte kontakter med antall <= " + ant);
                        }

                        return tettereKontakter;
                    }
                    return null;
                }

                public List<String> ITRY(String mistenkt, int ant)  {
                    if (vertexMap.containsKey(mistenkt)) {

                        ArrayList<Edge> directContact = vertexMap.get(mistenkt);
                        for (Edge edge : directContact) {

                            if (edge.getWeight() >= ant) {
                                tettereKontakter.add(edge.getDest());

                                String name = edge.getDest();

                                ArrayList<Edge> indirectContact = vertexMap.get(name);

                            }
                        }

                        if (!tettereKontakter.isEmpty()) {
                            System.out.println("Direkte og indirekte kontakter til " + mistenkt + " :");
                            System.out.println(tettereKontakter);
                        }
                        else    {
                            System.out.println(mistenkt + " har ingen direkte eller indirekte kontakter med antall <= " + ant);
                        }

                        return tettereKontakter;
                    }
                    return null;
                }
}
