import complex.ComplexTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Tester {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ComplexTest.class);

        for (Failure failure: result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Wynik testów: " + result.wasSuccessful());
    }

}
