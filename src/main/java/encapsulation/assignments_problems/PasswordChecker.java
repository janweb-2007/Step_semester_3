package encapsulation.assignments_problems;

public class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();

        if (length < 6) {
            return "Weak";
        } else if (length < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    private boolean containsDigit(String value) {
        for (char c : value.toCharArray()) {
            if (java.lang.Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("abcd -> " + pc1.getStrength()); // Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("abcdefgh -> " + pc2.getStrength()); // Medium

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("abcdefghij -> " + pc3.getStrength()); // Strong
    }
}