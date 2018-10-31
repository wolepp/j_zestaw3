public class Complex implements Field<Complex> {
    private double r, i;

    //TODO: użyć @Override w odpowiednich miejscach
    //TODO: przetestować wszystkie funkcje

    public Complex() {
        this(0d);
    }
    public Complex(double r) {
        this(r, 0);
    }
    public Complex(double r, double i) {
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
        return Math.sqrt(Math.pow(this.r, 2) + Math.pow(this.i, 2));
    }

    public double sqrAbs() {   // Kwadrat modułu
        return (Math.pow(this.r, 2) + Math.pow(this.i, 2));
    }
    public double phase() {        // Faza od (-Pi, Pi)
        //Dokładniejsze wartości jeśli liczba jest postaci z=bi
        if (this.r == 0) {
            if (this.i == 0)
                return 0;
            else
                return (this.i > 0) ? Math.PI/2 : -(Math.PI/2);
        }

        if (this.r > 0)
            return Math.atan(this.i / this.r);
        return Math.atan(this.i / this.r) + Math.PI;
    }

    public static void main(String[] args) {
        Complex zero = new Complex(0, 0);
        Complex uno = new Complex(0, 1);
        Complex c1 = new Complex(2, 3);
        Complex c2 = new Complex(4, 1);
        Complex cc = new Complex(add(c1, c2));
        System.out.println(cc.r + " " + cc.i);
        System.out.println(c1.r + " " + c1.i);
        System.out.println(c2.r + " " + c2.i);
    }

    public double re() {    // Część rzeczywista
        return this.r;
    }

    public double im() {    // Część urojona
        return this.i;
    }

    /* Metody statyczne dla powyższych operacji */

    public static Complex add(Complex a, Complex b) {
        return new Complex(a).add(b);
    }

    public static Complex sub(Complex a, Complex b) {
        return new Complex(a).sub(b);
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

    //TODO: String toString();
//    String toString();
    /* Zwraca String z zapisaną
        liczbą zespoloną formacie "-1.23+4.56i" */

    //TODO: poprawić ten teścik
    static Complex valueOf(String s) {
        return new Complex(0, 0);
    }
    /* Zwraca liczbę zespolona o wartości podanej
        w argumencie w formacie "-1.23+4.56i" */
//
    void setRe(double r) {
        this.r = r;
    }
    /* Przypisuje podaną wartość części rzeczywistej */

    void setIm(double i) {
        this.i = i;
    }
    /* Przypisuje podaną wartość części urojonej */

    void setVal(Complex c) {
        this.r = c.r;
        this.i = c.i;
    }
    void setVal(double r, double i) {
        this.r = r;
        this.i = i;
    }
    /* Przypisuje podaną wartość */

}
