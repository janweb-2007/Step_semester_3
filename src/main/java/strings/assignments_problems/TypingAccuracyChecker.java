package strings.assignments_problems;

public class TypingAccuracyChecker {

    public void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1; // 1-based position
            }
        }

        double accuracy = (matched / (double) original.length()) * 100;

        if (firstMismatchPosition == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, original.length(), accuracy);
        } else {
            char originalChar = original.charAt(firstMismatchPosition - 1);
            char typedChar = typed.charAt(firstMismatchPosition - 1);
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, original.length(), accuracy, firstMismatchPosition, originalChar, typedChar);
        }
    }

    public static void main(String[] args) {
        TypingAccuracyChecker checker = new TypingAccuracyChecker();
        checker.checkTypingAccuracy("hello world", "hello worlt");
        checker.checkTypingAccuracy("coding", "coding");
    }
}