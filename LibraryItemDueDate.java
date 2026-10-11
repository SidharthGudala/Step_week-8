import java.util.*;
import java.time.*;

class LibraryItem {
    String title;
    int days;

    LibraryItem(String t, int d) {
        title = t;
        days = d;
    }

    LocalDate dueDate() {
        return LocalDate.parse("2023-10-26").plusDays(days);
    }
}
class Book extends LibraryItem {
    Book(String t) { super(t, 14); }
}
class DVD extends LibraryItem {
    DVD(String t) { super(t, 7); }
}
class Magazine extends LibraryItem {
    Magazine(String t) { super(t, 3); }
}
public class LibraryItemDueDate {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        for (int i = 0; i < n; i++) {
            String line = s.nextLine();
            String type = line.substring(0, line.indexOf(' '));
            String title = line.substring(line.indexOf(' ') + 1)
                                .replace("\"", "");
            LibraryItem item;

            switch (type) {
                case "BOOK": item = new Book(title); break;
                case "DVD": item = new DVD(title); break;
                default: item = new Magazine(title);
            }
            System.out.println(title + ": " + item.dueDate());
        }
    }
}
