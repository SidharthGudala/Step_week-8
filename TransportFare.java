import java.util.*;

class Transport {
    double d;
    Transport(double d) { this.d = d; }
    double fare() { return 0; }
}
class Bus extends Transport {
    Bus(double d) { super(d); }
    double fare() { return Math.min(10, 2 + 0.1*d); }
}
class Train extends Transport {
    Train(double d) { super(d); }
    double fare() { return 3 + 0.15*d; }
}
class Metro extends Transport {
    double factor;
    Metro(double d, double f) { super(d); factor = f; }
    double fare() { return (1.5 + 0.2*d) * factor; }
}
public class TransportFare {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String t = s.next();
            double d = s.nextDouble();
            Transport x;
            if (t.equals("BUS")) x = new Bus(d);
            else if (t.equals("TRAIN")) x = new Train(d);
            else x = new Metro(d, s.nextDouble());
            double f = x.fare();
            System.out.printf("%s: %.2f%n", t, f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
