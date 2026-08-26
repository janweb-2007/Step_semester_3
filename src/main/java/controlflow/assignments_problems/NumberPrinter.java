package controlflow.assignments_problems;

public class NumberPrinter {
    public void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        NumberPrinter np = new NumberPrinter();
        np.printNumbersUpToN(5); // 1 2 3 4 5
    }
}
