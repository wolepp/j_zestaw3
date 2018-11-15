import java.util.ArrayList;


public class Drukarka implements Printer {
    private ArrayList<String> kolejka = new ArrayList<>();

    public static void main(String[] args) {
        Drukarka drukarka = new Drukarka();

        String dok1 = "Dokument 1";
        String dok2 = "Dokument 2";

        drukarka.dodajDoKolejki(dok1);
        drukarka.print(dok2);
        System.out.println();
        Printer.printReport(dok1);

        drukarka.printAll();
    }

    /**
     * Klasa drukuje podany dokument (String)
     * @param s String do wydrukowania
     */
    @Override
    public void print(String s) {
        System.out.println("Drukarka drukuje: " + s);
    }


    public void dodajDoKolejki(String dokument) {
        kolejka.add(dokument);
    }

    public void printAll() {
        if (!kolejka.isEmpty())
            for (String dok: kolejka)
                print(dok);
    }

}
