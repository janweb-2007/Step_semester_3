package polymorphism.assignments_problems;

import java.util.*;

abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();
    abstract String getType();
}

class Student extends Customer {
    Student(double amount) { super(amount); }
    double calculateFinalAmount() { return amount * 0.90; }
    String getType() { return "STUDENT"; }
}

class Staff extends Customer {
    Staff(double amount) { super(amount); }
    double calculateFinalAmount() { return amount * 0.95; }
    String getType() { return "STAFF"; }
}

class Guest extends Customer {
    Guest(double amount) { super(amount); }
    double calculateFinalAmount() { return amount + 10; }
    String getType() { return "GUEST"; }
}

public class CanteenBillingCounter {

    public static void main(String[] args) {
        List<Customer> bills = new ArrayList<>();
        bills.add(new Student(200));
        bills.add(new Staff(300));
        bills.add(new Guest(150));

        double total = 0;
        for (Customer c : bills) {
            double finalAmount = c.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", c.getType(), finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}