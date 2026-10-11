import java.util.*;

class Transport {
    double distance;
    Transport(double d) { distance = d; }
    double fare() { return 0; }
}
class Bus extends Transport {
    Bus(double d) { super(d); }
    double fare() { return Math.min(10, 2 + 0.1 * distance); }
}
class Train extends Transport {
    Train(double d) { super(d); }
    double fare() { return 3 + 0.15 * distance; }
}
class Metro extends Transport {
    double factor;
    Metro(double d, double f) {
        super(d);
        factor = f;
    }
    double fare() { return (1.5 + 0.2 * distance) * factor; }
}
public class TransportFareCalculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = s.next();
            double d = s.nextDouble();
            Transport t;

            switch (type) {
                case "BUS": t = new Bus(d); break;
                case "TRAIN": t = new Train(d); break;
                default: t = new Metro(d, s.nextDouble());
            }

            double f = t.fare();
            System.out.printf("%s: %.2f%n", type, f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
