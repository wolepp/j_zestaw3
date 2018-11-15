import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Udostępnia funkcję drukowania, oraz drukowania raportu
 */
public interface Printer {

    default void print(String s) {
        System.out.println(this.toString() + " prints: " + s);
    }

    static void printReport(String s) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Raport " + dtf.format(now));
        System.out.println(s);
    }
}
