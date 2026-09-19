package string.assignments_problems;

public class LibraryISBNNormalizer {

    public String normalizeCode(String raw) {
        String trimmed = raw.trim();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        String pubCode = code.substring(0, 3);
        String body = code.substring(3);

        for (char c : pubCode.toCharArray()) {
            if (!Character.isLetter(c)) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (char c : body.toCharArray()) {
            if (!Character.isDigit(c)) {
                return "Invalid: body must be digits";
            }
        }

        String year = body.substring(0, 4);
        String catalog = body.substring(4);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ").append(year).append(" | CATALOG: ").append(catalog);
        return sb.toString();
    }

    public static void main(String[] args) {
        LibraryISBNNormalizer normalizer = new LibraryISBNNormalizer();
        String normalized = normalizer.normalizeCode(" pen2026004251 ");
        System.out.println(normalizer.validateAndFormat(normalized));
        System.out.println(normalizer.validateAndFormat("12N2026004251"));
    }
}
