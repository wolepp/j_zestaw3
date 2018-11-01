import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ComplexTest {

    @org.junit.Test
    public void add() {
        Complex a = new Complex(-1.2, 3.4);
        Complex b = new Complex(5.6, -7.8);
        a.add(b);
        String result = a.toString();
        String numerycznyBlad = String.valueOf(-1.2+5.6);
        Assert.assertEquals(numerycznyBlad+"-4.4i", result);
//        Assert.assertEquals("4.4+11.2i", result);
//        -1.2 + 5.6 == 4.3999999999999995, stąd test jest fałszywie negatywny
    }

    @org.junit.Test
    public void mul() {
        Complex a = new Complex(-1.2, 3.4);
        Complex b = new Complex(5.6, -7.8);
        a.mul(b);
        String result = a.toString();
        assert result.equals("19.8+28.4i");
    }

    @org.junit.Test
    public void div() {
        Complex a = new Complex("1+8i");
        Complex b = Complex.valueOf("2+3i");
        a.div(b);
        String result = a.toString();
        Assert.assertEquals("2.0+1.0i", result);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Test
    public void divException() throws ArithmeticException {
        Complex a = new Complex("4.23-2.3234i");
        Complex b = new Complex(0);
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage("Dzielenie przez 0");
        a.div(b);
    }

    @org.junit.Test
    public void addStatic() {
        Complex a = new Complex("1.15-3.22i");
        Complex b = new Complex(-4.15, 2.32);
        Complex c = Complex.add(a,b);
        String result = c.toString();
//         ponownie błędy numeryczne
        double bladRe = 1.15-4.15;
        double bladIm = -3.22 + 2.32;
        String expected = String.valueOf(bladRe)+String.valueOf(bladIm)+"i";
        Assert.assertEquals(expected, result);

//        Assert.assertEquals("-3.0-0.9i", result);
    }

    @org.junit.Test
    public void mulStatic() {
        Complex a = new Complex("2.32-1.14i");
        Complex b = new Complex(4.18, -2.15);
        Complex c = Complex.mul(a, b);
        String result = c.toString();
        String expected = "7.2466-9.7532i";
        assert result.equals(expected);
    }

    @org.junit.Test
    public void divStatic() {
        Complex a = new Complex(20, -4);
        Complex b = new Complex("3.0+2i");
        Complex c = Complex.div(a, b);
        String result = c.toString();
        String expected = "4.0-4.0i";
        assert result.equals(expected);
    }

    @org.junit.Test
    public void toStringTest() {
        Complex a = new Complex(1.4414, -12.218);
        String expected = "1.4414-12.218i";
        Assert.assertEquals(expected, a.toString());

        Complex b = new Complex(-0.333333, +32.323323);
        String expected2 = "-0.333333+32.323323i";
        assert b.toString().equals(expected2);

        Complex c = Complex.valueOf(b.toString());
        assert b.toString().equals(c.toString());

    }

    @org.junit.Test
    public void valueOf() {
        Complex b = Complex.valueOf("   99.09-666.777i   ");
        String result = b.toString();
        String expected = "99.09-666.777i";
        Assert.assertEquals(expected, result);
    }
}