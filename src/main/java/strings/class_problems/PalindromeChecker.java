package strings.class_problems;

public class PalindromeChecker {

    public boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return new String(original).equals(new String(reversed));
    }

    public static void main(String[] args) {
        PalindromeChecker pc = new PalindromeChecker();
        String[] inputs = {"madam", "hello"};

        for (String input : inputs) {
            String iterative = pc.isPalindromeIterative(input) ? "Palindrome" : "Not Palindrome";
            String recursive = pc.isPalindromeRecursive(input) ? "Palindrome" : "Not Palindrome";
            String arrayReversal = pc.isPalindromeArrayReversal(input) ? "Palindrome" : "Not Palindrome";

            System.out.println("Input: \"" + input + "\" -> Iterative: " + iterative +
                    " | Recursive: " + recursive + " | Array Reversal: " + arrayReversal);
        }
    }
}