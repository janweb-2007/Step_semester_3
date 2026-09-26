package polymorphism.assignments_problems;

import java.util.*;

abstract class Vehicle {
    int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
    abstract String getType();
}

class Bike extends Vehicle {
    Bike(int hours) { super(hours); }
    double calculateCharge() { return 10 * hours; }
    String getType() { return "BIKE"; }
}

class Car extends Vehicle {
    Car(int hours) { super(hours); }
    double calculateCharge() {
        if (hours <= 1) return 30;
        return 30 + 20 * (hours - 1);
    }
    String getType() { return "CAR"; }
}

class Truck extends Vehicle {
    Truck(int hours) { super(hours); }
    double calculateCharge() {
        double charge = 50 * hours;
        return Math.max(charge, 100);
    }
    String getType() { return "TRUCK"; }
}

public class CampusParkingChargeCalculator {

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Bike(3));
        vehicles.add(new Car(4));
        vehicles.add(new Truck(1));
        vehicles.add(new Car(1));

        double total = 0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            System.out.printf("%s: %.2f%n", v.getType(), charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}