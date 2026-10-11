import java.util.*;

class Question {
    String type, correct, answer;
    double points;

    Question(String t, String c, String a, double p) {
        type = t;
        correct = c;
        answer = a;
        points = p;
    }

    double score() { return 0; }
}
class MCQ extends Question {
    MCQ(String c, String a, double p) {
        super("MCQ", c, a, p);
    }
    double score() {
        return correct.equalsIgnoreCase(answer) ? points : 0;
    }
}
class TF extends Question {
    TF(String c, String a, double p) {
        super("TF", c, a, p);
    }
    double score() {
        return correct.equalsIgnoreCase(answer) ? points : 0;
    }
}
class Essay extends Question {
    Essay(String c, String a, double p) {
        super("ESSAY", c, a, p);
    }
    double score() {
        int count = 0;
        for (String k : correct.split(","))
            if (answer.toLowerCase().contains(k.trim().toLowerCase()))
                count++;
        return count >= 2 ? points * 0.75 :
               count == 1 ? points * 0.5 : 0;
    }
}
public class ExaminationGrader {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = s.nextLine();
            java.util.regex.Matcher m =
                java.util.regex.Pattern.compile("\"([^\"]*)\"").matcher(line);

            String type = line.substring(0, line.indexOf(' '));
            List<String> a = new ArrayList<>();
            while (m.find()) a.add(m.group(1));

            double points = Double.parseDouble(
                line.substring(line.lastIndexOf('"') + 1).trim());

            Question q;
            if (type.equals("MCQ"))
                q = new MCQ(a.get(1), a.get(2), points);
            else if (type.equals("TF"))
                q = new TF(a.get(1), a.get(2), points);
            else
                q = new Essay(a.get(1), a.get(2), points);

            double score = q.score();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
