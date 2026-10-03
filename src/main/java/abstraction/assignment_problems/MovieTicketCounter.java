package abstraction.assigment_problems;

import java.util.Scanner;

public class MovieTicketCounter {

    static abstract class Seat {
        static final double CONVENIENCE_FEE = 20.0;
        abstract double price();
        final double amountFor(int count) { return (price() + CONVENIENCE_FEE) * count; }
    }

    static class RegularSeat extends Seat { double price() { return 150.0; } }
    static class PremiumSeat extends Seat { double price() { return 250.0; } }
    static class ReclinerSeat extends Seat { double price() { return 400.0; } }

    static Seat createSeat(String type) {
        switch (type) {
            case "REGULAR": return new RegularSeat();
            case "PREMIUM": return new PremiumSeat();
            case "RECLINER": return new ReclinerSeat();
            default: throw new IllegalArgumentException("Unknown seat type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Seat seat = createSeat(parts[0]);
            double amount = seat.amountFor(Integer.parseInt(parts[1]));
            total += amount;
            System.out.printf("%s: %.2f%n", parts[0], amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
