package abstraction.assigment_problems;

import java.util.Scanner;

public class CollegeFeeCounter {

    static abstract class StudentFee {
        String name;
        StudentFee(String name) { this.name = name; }
        abstract double tuition();
    }

    interface BusUser {
        double TRANSPORT_FEE = 12000.0;
        default double transportFee() { return TRANSPORT_FEE; }
    }

    static class DayScholar extends StudentFee implements BusUser {
        DayScholar(String name) { super(name); }
        double tuition() { return 40000.0; }
    }

    static class Hosteller extends StudentFee {
        Hosteller(String name) { super(name); }
        double tuition() { return 40000.0 + 60000.0; }
    }

    static class ScholarshipStudent extends StudentFee implements BusUser {
        ScholarshipStudent(String name) { super(name); }
        double tuition() { return 20000.0; }
    }

    static StudentFee createStudent(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR": return new DayScholar(name);
            case "HOSTELLER": return new Hosteller(name);
            case "SCHOLAR": return new ScholarshipStudent(name);
            default: throw new IllegalArgumentException("Unknown student type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            StudentFee student = createStudent(parts[0], parts[1]);
            double transport = (student instanceof BusUser) ? ((BusUser) student).transportFee() : 0.0;
            double fee = student.tuition() + transport;
            total += fee;
            System.out.printf("%s: %.2f%n", student.name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}