package sorting.assigment_problems;

public class LibraryCatalogLookup {

    static class BookRecord {
        String isbn, title;
        BookRecord(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    static String findBook(BookRecord[] catalog, String targetIsbn) {
        int lo = 0, hi = catalog.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = catalog[mid].isbn.compareTo(targetIsbn);
            if (cmp == 0) return catalog[mid].title;
            else if (cmp < 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        BookRecord[] catalog = {
                new BookRecord("0001112223", "Introduction to Algebra"),
                new BookRecord("0002223334", "Beginning Python"),
                new BookRecord("0003334445", "Classic Mythology"),
                new BookRecord("0004445556", "Data and Society"),
                new BookRecord("0005556667", "European History")
        };
        System.out.println(findBook(catalog, "0003334445"));
        System.out.println(findBook(catalog, "0009998887"));
    }
}