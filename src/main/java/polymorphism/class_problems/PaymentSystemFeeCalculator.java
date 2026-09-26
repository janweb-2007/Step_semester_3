package polymorphism.class_problems;

import java.util.*;

abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAdjustedAmount();
    abstract String getType();
}

class CardPayment extends Payment {
    CardPayment(double amount) { super(amount); }
    double calculateAdjustedAmount() { return amount * 1.02; }
    String getType() { return "CARD"; }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) { super(amount); }
    double calculateAdjustedAmount() { return amount * 1.01; }
    String getType() { return "WALLET"; }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) { super(amount); }
    double calculateAdjustedAmount() { return amount; }
    String getType() { return "BANKTRANSFER"; }
}

public class PaymentSystemFeeCalculator {

    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();
        payments.add(new CardPayment(1000));
        payments.add(new WalletPayment(500));
        payments.add(new BankTransferPayment(2000));

        double total = 0;
        for (Payment p : payments) {
            double adjusted = p.calculateAdjustedAmount();
            System.out.printf("%s: %.2f%n", p.getType(), adjusted);
            total += adjusted;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}