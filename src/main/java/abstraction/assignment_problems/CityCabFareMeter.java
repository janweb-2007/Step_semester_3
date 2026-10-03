package abstraction.assigment_problems;

import java.util.Scanner;

public class CityCabFareMeter {

    static abstract class Cab {
        abstract double ratePerKm();
        final double baseFare(double km) { return Math.max(km * ratePerKm(), 100.0); }
    }

    interface NightServiceCapable {
        default double nightFare(double baseFare) { return baseFare * 1.20; }
    }

    static class Mini extends Cab { double ratePerKm() { return 10.0; } }
    static class Sedan extends Cab implements NightServiceCapable { double ratePerKm() { return 14.0; } }
    static class SUV extends Cab implements NightServiceCapable { double ratePerKm() { return 18.0; } }

    static Cab createCab(String type) {
        switch (type) {
            case "MINI": return new Mini();
            case "SEDAN": return new Sedan();
            case "SUV": return new SUV();
            default: throw new IllegalArgumentException("Unknown cab type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double km = Double.parseDouble(parts[1]);
            String time = parts[2];

            Cab cab = createCab(type);

            if (time.equals("NIGHT") && !(cab instanceof NightServiceCapable)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.baseFare(km);
            if (time.equals("NIGHT")) {
                fare = ((NightServiceCapable) cab).nightFare(fare);
            }

            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
