import java.util.*;

class Delivery {
    double w, d;
    Delivery(double w, double d) {
        this.w = w;
        this.d = d;
    }
    double fee() { return 0; }
}
class Standard extends Delivery {
    Standard(double w, double d) { super(w, d); }
    double fee() { return 5 + 0.5*w + 0.1*d; }
}
class Express extends Delivery {
    Express(double w, double d) { super(w, d); }
    double fee() { return 15 + w + 0.2*d; }
}
class International extends Delivery {
    double customs;
    International(double w, double d, double c) {
        super(w, d);
        customs = c;
    }
    double fee() { return 25 + 2*w + 0.5*d + customs; }
}
public class DeliveryFee {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String t = s.next();
            double w = s.nextDouble(), d = s.nextDouble();
            Delivery x;
            if (t.equals("STANDARD")) x = new Standard(w, d);
            else if (t.equals("EXPRESS")) x = new Express(w, d);
            else x = new International(w, d, s.nextDouble());
            double f = x.fee();
            System.out.printf("%s: %.2f%n", t, f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
