package encapsulation.class_problems;

public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        savings += amount;
    }

    public void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Rejected — insufficient savings");
        } else {
            savings -= amount;
        }
    }

    public double getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("savings = " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("savings = " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("savings = " + pb.getSavings());
    }
}
