public class Complex implements Field<Complex> {
    private double r, i;

    //TODO: użyć @Override w odpowiednich miejscach

    Complex() {
        this(0d);
    }
    Complex(double ) {
        this()
    Complex(double, double);
    Complex(Complex);
    Complex(String);

    /* Poniższe metody modyfikują aktualny obiekt i zwracają 'this' */
    //TODO: metody niestatyczne mają zwracać this

    Complex add(Complex);   // Dodawanie
    Complex sub(Complex);   // Odejmowanie
    Complex mul(Complex);   // Mnożenie
    //TODO: div ma wyrzucać wyjątek przy dzieleni przez 0
    Complex div(Complex);   // Dzielenie
    double abs();           // Moduł
    double sqrAbs();        // Kwadrat modułu
    double phase();         // Faza
    double re();            // Część rzeczywista
    double im();            // Część urojona

    /* Metody statyczne dla powyższych operacji */

    static Complex add(Complex, Complex);
    static Complex sub(Complex, Complex);
    static Complex mul(Complex, Complex);
    static Complex div(Complex, Complex);
    static double abs(Complex);
    static double phase(Complex);
    static double sqrAbs(Complex);
    static double re(Complex);
    static double im(Complex);

    /* Dodatkowe metody */

    String toString();
    /* Zwraca String z zapisaną
        liczbą zespoloną formacie "-1.23+4.56i" */

    static Complex valueOf(String);
    /* Zwraca liczbę zespolona o wartości podanej
        w argumencie w formacie "-1.23+4.56i" */

    void setRe(double);
    /* Przypisuje podaną wartość części rzeczywistej */

    void setIm(double);
    /* Przypisuje podaną wartość części urojonej */

    void setVal(Complex);
    void setVal(double, double);
    /* Przypisuje podaną wartość */
}
}
