import java.util.*;

class Payment {
    double amount;
    Payment(double a) { amount = a; }
    double fee() { return amount; }
}
class Card extends Payment {
    Card(double a) { super(a); }
    double fee() { return amount * 1.02; }
}
class Wallet extends Payment {
    Wallet(double a) { super(a); }
    double fee() { return amount * 1.01; }
}
class BankTransfer extends Payment {
    BankTransfer(double a) { super(a); }
}
public class PaymentFee {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String t = s.next();
            double a = s.nextDouble();
            Payment p;
            if (t.equals("CARD")) p = new Card(a);
            else if (t.equals("WALLET")) p = new Wallet(a);
            else p = new BankTransfer(a);
            double f = p.fee();
            System.out.printf("%s: %.2f%n", t, f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
