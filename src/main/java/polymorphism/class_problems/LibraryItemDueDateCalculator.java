package polymorphism.class_problems;

import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getBorrowDays();

    LocalDate getDueDate(LocalDate current) {
        return current.plusDays(getBorrowDays());
    }
}

class Book extends LibraryItem {
    Book(String title) { super(title); }
    int getBorrowDays() { return 14; }
}

class DVD extends LibraryItem {
    DVD(String title) { super(title); }
    int getBorrowDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }
    int getBorrowDays() { return 3; }
}

public class LibraryItemDueDateCalculator {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("1984"));
        items.add(new DVD("The Matrix"));
        items.add(new Magazine("Forbes Issue 500"));

        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.getDueDate(currentDate));
        }
    }
}