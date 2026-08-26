package controlflow.assignments_problems;

public class SumOfNaturalNumbers {
    public void sumOfNaturalNumbers(int n) {
        int counter = 1;
        int total = 0;
        while (counter <= n) {
            total += counter;
            counter++;
        }
        System.out.println("Sum of numbers from 1 to " + n + " = " + total);
    }

    public static void main(String[] args) {
        SumOfNaturalNumbers snn = new SumOfNaturalNumbers();
        snn.sumOfNaturalNumbers(5); // Sum of numbers from 1 to 5 = 15
    }
}
