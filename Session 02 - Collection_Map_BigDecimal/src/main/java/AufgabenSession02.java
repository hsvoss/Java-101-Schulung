import model.Apfel;
import model.Birne;
import model.Obst;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class AufgabenSession02 {

//    Stöbert in:
//    https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html
//    https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
//    https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
//    https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html


    public static void main(String[] args) {
        task6();
    }

    /**
     * Welche Interfaces fallen dir ein, die java.util.Collection erweitern?
     */
    static void task1() {
    }

    /**
     * Welche Implementierungen fallen dir ein, die java.util.Map implementieren?
     */
    static void task2() {
    }

    /**
     * Du hast gerade einige Maps aufgelistet. Welche Eigenschaften haben sie und wie unterscheiden Sie sich?
     */
    static void task3() {
    }

    /**
     * Weshalb enthält das Set 'obstsalat' nur 2 Items, obwohl 3 Item hineingetan werden?
     * Untersuche dazu die Klassen im Model-Ordner. Wenn du den Fehler gefunden hast, korrigiere ihn.
     */
    static Set<Obst> task4() {

        Set<Obst> obstsalat = new HashSet<>();
        obstsalat.add(new Apfel("Elster"));
        obstsalat.add(new Apfel("Boskop"));
        obstsalat.add(new Birne());

        System.out.println(obstsalat.size());
        return obstsalat;
    }


    /**
     * Wähle eine sinnvolle Datenstruktur ohne die Klassen im Package 'telefonbuch' zu ändern:
     * Unser Arbeitgeber möchte seine Kunden nach Branchen katalogisieren.
     * Einige Kunden können mehreren Branchen zugeordnet werden.
     */
    static void task5() {

    }


    /**
     * Erkläre folgenden Effekt:
     */
    static void task6() {
        double a = 5.6;
        double b = 5.8;

        System.out.println(a + b);
        System.out.println(a + b < 11.4);
        System.out.println(a + b >= 11.4);


    }


    /**
     * Nachdem du Task 6 bearbeitet hast, sollst du nun die Rechnung korrekt durchführen
     */
    static BigDecimal task7() {
        String a = "5.6";
        String b = "5.8";

        return null;
    }

    /**
     * Untersuche d und e. Erkläre, weshalb d.equals(e) false ergibt.
     *
     * Wenn du nicht weiter kommst, versuche erst die nächste Aufgabe,
     * bevor du in die Lösung schaust.
     */
    static void task8() {

        BigDecimal d = new BigDecimal("0.2");
        BigDecimal e = new BigDecimal(0.2);

        System.out.println(d.equals(e)); // false

    }


    /**
     * Untersuche d und e. Erkläre, weshalb d.equals(e) false ergibt.
     */
    static void task8MitTipp() {
        BigDecimal d = new BigDecimal("12.3");
        BigDecimal e = new BigDecimal("12.30");

        System.out.println(d.equals(e)); // false

    }


}