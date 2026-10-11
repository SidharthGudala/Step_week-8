import java.util.*;

class Payment {
    double amount;
    Payment(double amount) {
        this.amount = amount;
    }
    double calculate() {
        return amount;
    }
}

class Card extends Payment {
    Card(double a) { super(a); }
    double calculate() { return amount * 1.02; }
}

class Wallet extends Payment {
    Wallet(double a) { super(a); }
    double calculate() { return amount * 1.01; }
}

class BankTransfer extends Payment {
    BankTransfer(double a) { super(a); }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment p;

            switch (type) {
                case "CARD": p = new Card(amount); break;
                case "WALLET": p = new Wallet(amount); break;
                default: p = new BankTransfer(amount);
            }

            double result = p.calculate();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
