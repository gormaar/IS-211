package KontaktNett;
import java.util.*;
public class Vertex {

    private String name;
    private List<Edge> connections;

    public Vertex(String name, ArrayList<Edge> connections) {
        this.name = name;
        this.connections = connections;
    }
}
