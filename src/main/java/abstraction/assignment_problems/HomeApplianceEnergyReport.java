package abstraction.assigment_problems;

import java.util.Scanner;

public class LibraryLateFineCounter {

    static abstract class LibraryItem {
        String title;
        int daysLate;
        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }
        abstract double fine();
    }

    static class Book extends LibraryItem {
        Book(String title, int daysLate) { super(title, daysLate); }
        double fine() { return daysLate * 2.0; }
    }

    static class DVD extends LibraryItem {
        DVD(String title, int daysLate) { super(title, daysLate); }
        double fine() { return Math.min(daysLate * 5.0, 50.0); }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) { super(title, daysLate); }
        double fine() { return daysLate * 1.0; }
    }

    static LibraryItem createItem(String type, String title, int daysLate) {
        switch (type) {
            case "BOOK": return new Book(title, daysLate);
            case "DVD": return new DVD(title, daysLate);
            case "MAGAZINE": return new Magazine(title, daysLate);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            LibraryItem item = createItem(parts[0], parts[1], Integer.parseInt(parts[2]));
            double fine = item.fine();
            total += fine;
            System.out.printf("%s: %.2f%n", item.title, fine);
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}