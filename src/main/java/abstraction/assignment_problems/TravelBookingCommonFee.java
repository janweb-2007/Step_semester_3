package abstraction.assigment_problems;

import java.util.Scanner;

public class TravelBookingCommonFee {

    static abstract class Booking {
        static final double BOOKING_FEE = 50.0;
        abstract double fare();
        final double total() { return fare() + BOOKING_FEE; }
    }

    static class BusBooking extends Booking {
        double distanceKm;
        BusBooking(double distanceKm) { this.distanceKm = distanceKm; }
        double fare() { return distanceKm * 2.0; }
    }

    static class TrainBooking extends Booking {
        double distanceKm;
        TrainBooking(double distanceKm) { this.distanceKm = distanceKm; }
        double fare() { return distanceKm * 1.5; }
    }

    static class FlightBooking extends Booking {
        double distanceKm;
        FlightBooking(double distanceKm) { this.distanceKm = distanceKm; }
        double fare() { return 2500.0 + distanceKm * 4.0; }
    }

    static Booking createBooking(String mode, double distanceKm) {
        switch (mode) {
            case "BUS": return new BusBooking(distanceKm);
            case "TRAIN": return new TrainBooking(distanceKm);
            case "FLIGHT": return new FlightBooking(distanceKm);
            default: throw new IllegalArgumentException("Unknown mode: " + mode);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Booking booking = createBooking(parts[0], Double.parseDouble(parts[1]));
            System.out.printf("%s: %.2f%n", parts[0], booking.total());
        }

        sc.close();
    }
}