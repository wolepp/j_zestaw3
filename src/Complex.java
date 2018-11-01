import java.util.ArrayList;

/**
 * @author Wojciech Lepich
 * @version 1.0
 *
 */
public class Complex implements Field<Complex> {
    private double r, i;

    //TODO: użyć @Override w odpowiednich miejscach
    //TODO: przetestować wszystkie funkcje

    public static void main(String[] args) {
        Complex zero = new Complex(0, 0);
        Complex unoImaginary = new Complex(0, 1);
        Complex uno = new Complex(1, 0);

        ArrayList<Complex> complexes = new ArrayList<>();
        complexes.add(new Complex(1.1, 1.1));
        complexes.add(new Complex(-1.2, 1.2));
        complexes.add(new Complex(-1.3, -1.3));
        complexes.add(new Complex(1.4, -1.4));
        complexes.add(zero);
        complexes.add(unoImaginary);
        complexes.add(uno);

        ArrayList<Complex> complexes1 = new ArrayList<>();
        for (Complex c: complexes)
            complexes1.add(new Complex(valueOf(c.toString())));

        for (Complex c: complexes)
            System.out.println(c);
        for (Complex c: complexes1)
            System.out.println(c);
    }

    public Complex() {
        this(0d);
    }

    public Complex(double r) {
        this(r, 0);
    }

    public Complex(double r, double i) {    //Główny konstruktor
        this.r = r;
        this.i = i;
    }

    public Complex(String s) {
        this(Complex.valueOf(s));
    }

    public Complex(Complex c) {
        this(c.r, c.i);
    }


    /* Poniższe metody modyfikują aktualny obiekt i zwracają 'this' */

    public Complex add(Complex c) {     // Dodawanie
        this.r += c.r;
        this.i += c.i;
        return this;
    }

    public Complex sub(Complex c) {     // Odejmowanie
        this.r -= c.r;
        this.i -= c.i;
        return this;
    }

    public Complex mul(Complex c) {     // Mnożenie
        double origR = this.r;
        double origI = this.i;
        this.r = (origR * c.r) - (origI * c.i);
        this.i = (origR * c.i) + (origI * c.r);
        return this;
    }

    public Complex div(Complex c) throws ArithmeticException {     // Dzielenie
        if (c.r == 0 && c.i == 0)
            throw new ArithmeticException("Dzielenie przez 0");
        else {
            double mianownik = (c.r * c.r) + (c.i * c.i);
            double origR = this.r;
            double origI = this.i;
            this.r = (origR * c.r) + (origI * c.i);
            this.i = (c.r * origI) - (origR * c.i);
            this.r /= mianownik;
            this.i /= mianownik;
        }
        return this;
    }

    public double abs() {       // Moduł
        return Math.sqrt(sqrAbs());
    }

    public double sqrAbs() {   // Kwadrat modułu
        return (Math.pow(this.r, 2) + Math.pow(this.i, 2));
    }

    public double phase() {        // Faza od (-Pi, Pi)
        return Math.atan2(this.i, this.r);
    }


    public double re() {    // Część rzeczywista
        return this.r;
    }

    public double im() {    // Część urojona
        return this.i;
    }

    /* Metody statyczne dla powyższych operacji */

    public static Complex add(Complex a, Complex b) {
        return new Complex(a.r + b.r, b.i + b.r);
    }

    public static Complex sub(Complex a, Complex b) {
        return new Complex(a.r - b.r, b.i - b.r);
    }

    public static Complex mul(Complex a, Complex b) {
        return new Complex(a).mul(b);
    }

    public static Complex div(Complex a, Complex b) {
        return new Complex(a).div(b);
    }

    public static double abs(Complex c) {
        return c.abs();
    }

    public static double phase(Complex c) {
        return c.phase();
    }

    public static double sqrAbs(Complex c) {
        return c.sqrAbs();
    }

    public static double re(Complex c) {
        return c.re();
    }

    static double im(Complex c) {
        return c.im();
    }

    /* Dodatkowe metody */

    @Override
    public String toString() {

        if (this.i >= 0)
            return String.valueOf(this.r) + "+" + String.valueOf(this.i) + "i";
        return String.valueOf(this.r) + String.valueOf(this.i) + "i";
    }
    /* Zwraca String z zapisaną
        liczbą zespoloną formacie "-1.23+4.56i" */

    public static Complex valueOf(String s) {

        // pozbycie się białych spacji z przodu i z tyłu
        s = s.trim();

        // indeks znaku '+' lub '-' stojącego przy części urojonej
        int beginOfImag = s.indexOf('-',1) * s.indexOf('+', 1) * (-1);

        String real = s.substring(0, beginOfImag);
        String imag = s.substring(beginOfImag, s.length()-1);
        System.out.println("strReal:\t" + real);
        System.out.println("strImag:\t" + imag);

        return new Complex(Double.valueOf(real), Double.valueOf(imag));
    }

    /* Zwraca liczbę zespolona o wartości podanej
        w argumencie w formacie "-1.23+4.56i" */

    public void setRe(double r) {
        this.r = r;
    }
    /* Przypisuje podaną wartość części rzeczywistej */

    public void setIm(double i) {
        this.i = i;
    }
    /* Przypisuje podaną wartość części urojonej */

    public void setVal(Complex c) {
        this.r = c.r;
        this.i = c.i;
    }

    public void setVal(double r, double i) {
        this.r = r;
        this.i = i;
    }
    /* Przypisuje podaną wartość */
}