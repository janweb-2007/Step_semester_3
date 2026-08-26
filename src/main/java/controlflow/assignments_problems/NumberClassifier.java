package controlflow.assignments_problems;

public class NumberClassifier {
    public void classifyNumber(int number) {
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }

    public static void main(String[] args) {
        NumberClassifier nc = new NumberClassifier();
        nc.classifyNumber(15); // Positive
        nc.classifyNumber(-4); // Negative
        nc.classifyNumber(0);  // Zero
    }
}
