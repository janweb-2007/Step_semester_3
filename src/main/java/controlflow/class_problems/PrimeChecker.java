package controlflow.class_problems;

public class PrimeChecker {
    public void checkPrime(int number) {
        boolean isPrime = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime ? "Prime" : "Not Prime");
    }

    public static void main(String[] args) {
        PrimeChecker pc = new PrimeChecker();
        pc.checkPrime(17); // Prime
        pc.checkPrime(18); // Not Prime
    }
}
