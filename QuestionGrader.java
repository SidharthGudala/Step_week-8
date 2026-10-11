import java.util.*;
import java.util.regex.*;

class Question {
    String correct, answer;
    double points;
    Question(String c, String a, double p) {
        correct = c;
        answer = a;
        points = p;
    }
    double score() { return 0; }
}
class MCQ extends Question {
    MCQ(String c, String a, double p) { super(c, a, p); }
    double score() { return correct.equalsIgnoreCase(answer) ? points : 0; }
}
class TF extends Question {
    TF(String c, String a, double p) { super(c, a, p); }
    double score() { return correct.equalsIgnoreCase(answer) ? points : 0; }
}
class Essay extends Question {
    Essay(String c, String a, double p) { super(c, a, p); }
    double score() {
        int count = 0;
        for (String k : correct.split(","))
            if (answer.toLowerCase().contains(k.trim().toLowerCase()))
                count++;
        return count >= 2 ? points * 0.75 : count == 1 ? points * 0.5 : 0;
    }
}
public class QuestionGrader {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String line = s.nextLine();
            Matcher m = Pattern.compile("\"([^\"]*)\"").matcher(line);
            ArrayList<String> a = new ArrayList<>();
            while (m.find()) a.add(m.group(1));
            String type = line.substring(0, line.indexOf(' '));
            double p = Double.parseDouble(line.substring(line.lastIndexOf('"') + 1).trim());
            Question q;
            if (type.equals("MCQ")) q = new MCQ(a.get(1), a.get(2), p);
            else if (type.equals("TF")) q = new TF(a.get(1), a.get(2), p);
            else q = new Essay(a.get(1), a.get(2), p);
            double score = q.score();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
