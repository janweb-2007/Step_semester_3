package abstraction.assigment_problems;

import java.util.Scanner;

public class ElectricityConnectionBilling {

    static abstract class Connection {
        int units;
        Connection(int units) { this.units = units; }
        abstract double bill();
    }

    static class HomeConnection extends Connection {
        HomeConnection(int units) { super(units); }
        double bill() {
            if (units <= 100) return units * 5.0;
            return 100 * 5.0 + (units - 100) * 7.0;
        }
    }

    static class ShopConnection extends Connection {
        ShopConnection(int units) { super(units); }
        double bill() { return units * 8.0 + 100.0; }
    }

    static class FactoryConnection extends Connection {
        FactoryConnection(int units) { super(units); }
        double bill() { return Math.max(units * 6.0, 1000.0); }
    }

    static Connection createConnection(String type, int units) {
        switch (type) {
            case "HOME": return new HomeConnection(units);
            case "SHOP": return new ShopConnection(units);
            case "FACTORY": return new FactoryConnection(units);
            default: throw new IllegalArgumentException("Unknown connection type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Connection connection = createConnection(parts[0], Integer.parseInt(parts[1]));
            double bill = connection.bill();
            total += bill;
            System.out.printf("%s: %.2f%n", parts[0], bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}