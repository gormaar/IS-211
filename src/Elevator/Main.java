package Elevator;

public class Main {

    public static void main(String[] args) {

        Elevator elevator = new Elevator(5);


        elevator.nyttStopp(3);
        elevator.nyttStopp(1);

        elevator.flytt();

        elevator.nyttStopp(5);
        elevator.nyttStopp(2);
        elevator.nyttStopp(3);
        elevator.nyttStopp(0);
        elevator.nyttStopp(1);
        elevator.nyttStopp(5);




    }
}
