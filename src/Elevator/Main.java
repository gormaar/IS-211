package Elevator;

public class Main {

    public static void main(String[] args) {

        Elevator elevator = new Elevator(10);


        elevator.nyttStopp(2);
        elevator.flytt();
        elevator.nyttStopp(1);
        elevator.flytt();
        elevator.nyttStopp(3);
        elevator.flytt();
        elevator.nyttStopp(4);
        elevator.nyttStopp(6);
        elevator.nyttStopp(8);
        elevator.nyttStopp(1);
        elevator.flytt();

    }
}
