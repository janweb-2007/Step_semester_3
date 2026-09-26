package polymorphism.assignments_problems;

import java.util.*;

abstract class Room {
    int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
    abstract String getType();
}

class SingleRoom extends Room {
    SingleRoom(int units) { super(units); }
    double calculateBill() { return 8 * units; }
    String getType() { return "SINGLE"; }
}

class SharedRoom extends Room {
    int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }
    double calculateBill() { return (6.0 * units) / occupants; }
    String getType() { return "SHARED"; }
}

class ACRoom extends Room {
    ACRoom(int units) { super(units); }
    double calculateBill() { return 10 * units + 200; }
    String getType() { return "AC"; }
}

public class HostelElectricityBill {

    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom(120));
        rooms.add(new SharedRoom(150, 3));
        rooms.add(new ACRoom(100));

        double total = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            System.out.printf("%s: %.2f%n", r.getType(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}