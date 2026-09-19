package string.class_problems;

public class BankTransactionRefGenerator {

    public String normalizeReference(String raw) {
        String trimmed = raw.trim();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }
        String bankCode = reference.substring(0, 3);
        String body = reference.substring(3);

        for (char c : bankCode.toCharArray()) {
            if (!Character.isLetter(c)) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (char c : body.toCharArray()) {
            if (!Character.isDigit(c)) {
                return "Invalid: body must be digits";
            }
        }

        String date = body.substring(0, 6);
        String seq = body.substring(6);
        String dd = date.substring(0, 2);
        String mm = date.substring(2, 4);
        String yy = date.substring(4, 6);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ").append(dd).append("/").append(mm).append("/").append(yy)
                .append(" | SEQ: ").append(seq);
        return sb.toString();
    }

    public static void main(String[] args) {
        BankTransactionRefGenerator generator = new BankTransactionRefGenerator();
        String normalized = generator.normalizeReference(" hdf03022600042 ");
        System.out.println(generator.validateAndFormat(normalized));
        System.out.println(generator.validateAndFormat("12F03022600042"));
    }
}