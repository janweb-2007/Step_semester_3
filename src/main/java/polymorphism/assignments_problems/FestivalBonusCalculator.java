package polymorphism.assignments_problems;

import java.util.*;

abstract class Employee {
    String name;
    double monthlySalary;

    Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) { super(name, salary); }
    double calculateBonus() { return monthlySalary * 0.10; }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) { super(name, salary); }
    double calculateBonus() { return monthlySalary * 0.05; }
}

class Intern extends Employee {
    Intern(String name, double salary) { super(name, salary); }
    double calculateBonus() { return 2000; }
}

public class FestivalBonusCalculator {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("Asha", 50000));
        employees.add(new PartTimeEmployee("Ravi", 30000));
        employees.add(new Intern("Neha", 15000));

        double total = 0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            System.out.printf("%s: %.2f%n", e.name, bonus);
            total += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}