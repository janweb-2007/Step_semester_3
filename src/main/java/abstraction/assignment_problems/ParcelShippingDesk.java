package abstraction.assigment_problems;

import java.util.Scanner;

public class ParcelShippingDesk {

    static abstract class Parcel {
        double weightKg, declaredValue;
        Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }
        abstract double charge();
    }

    interface Insurable {
        double insurance();
    }

    static class StandardParcel extends Parcel {
        StandardParcel(double w, double v) { super(w, v); }
        double charge() { return 40.0 + 10.0 * weightKg; }
    }

    static class ExpressParcel extends Parcel implements Insurable {
        ExpressParcel(double w, double v) { super(w, v); }
        double charge() { return 80.0 + 15.0 * weightKg; }
        public double insurance() { return declaredValue * 0.02; }
    }

    static class FragileParcel extends Parcel implements Insurable {
        FragileParcel(double w, double v) { super(w, v); }
        double charge() { return (40.0 + 10.0 * weightKg) + 50.0; }
        public double insurance() { return declaredValue * 0.02; }
    }

    static Parcel createParcel(String type, double weight, double value) {
        switch (type) {
            case "STANDARD": return new StandardParcel(weight, value);
            case "EXPRESS": return new ExpressParcel(weight, value);
            case "FRAGILE": return new FragileParcel(weight, value);
            default: throw new IllegalArgumentException("Unknown parcel type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double value = Double.parseDouble(parts[2]);

            Parcel parcel = createParcel(type, weight, value);
            double charge = parcel.charge();
            double insurance = (parcel instanceof Insurable) ? ((Insurable) parcel).insurance() : 0.0;
            double total = charge + insurance;
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, charge, insurance, total);
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}