import model.Berater;
import model.Branche;
import model.Kunde;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AufgabenSession04 {

//    Stöbert in:
//    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/package-summary.html
//    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html
//    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Optional.html


    public static void main(String[] args) {
        List<Berater> beraterList = Helper.generateData();
        task6(beraterList);

//        checkPrime(323); // false
//        checkPrime(331); // true
    }

    /**
     * Schaue dir die Klassen im Package model an, damit du ein Gefühl für die Datenstruktur bekommst.
     * Getter, Setter, equal, hashCode & toString enthalten nur generierten Code.
     * <p>
     * Die Methode Helper.generateData() generiert dir Testdaten. Wenn du die Daten ändern/erweitern möchtest,
     * kopiere dir bitte diese Methode und manipuliere die Daten in der Kopie. Sonst funktionieren vielleicht die
     * Folgeaufgaben nicht mehr.
     */
    static void task1() {
        List<Berater> beraterList = Helper.generateData();
    }


    /**
     * Gib alle Berater zurück, die nur bei einem Kunden im Einsatz sind.
     *
     * @return die gefilterte Liste
     */
    static List<Berater> task2(List<Berater> beraterList) {
        return null;
    }

// Task 2b)
//     * Schaue dir den Stream im Debugger an:
//     * 1. Nutze die Stream-Trace-Funktion deiner IDE (https://www.jetbrains.com/help/idea/analyze-java-stream-operations.html)
//     * 2. Setze einen Breakpoint nur an deinem Lambda-Ausdruck und nicht am '.filter'
//     * 3. Setze einen Breakpoint am '.filter' und nicht am Lambda-Ausdruck.
//     * 4. Setze einen Breakpoint sowohl am '.filter' als auch am Lambda-Ausdruck.


    /**
     * Gib die Namen der Berater zurück, die nur bei einem Kunden im Einsatz sind.
     * Stelle sicher, dass kein Name doppelt vorkommt.
     *
     * @return die gefilterte Liste
     */
    static Collection<String> task3(List<Berater> beraterList) {

        return null;
    }


    /**
     * Gib alle Kunden-Namen zurück, bei denen mindestens 2 Berater im Einsatz sind.
     * Stelle sicher, dass kein Kunde doppelt vorkommt.
     * Sortiere die Kunden-Firmennamen alphabetisch.
     * <p>
     * Wenn du ein Problem mit dem Return-Type Set<String> hast, dann ändere ihn auf Collection<String>
     *
     * @return die gefilterte Collection
     */
    static Set<String> task4(List<Berater> beraterList) { // schwer
//    static Collection<String>  task4(List<Berater> beraterList) { // einfach

        return null;
    }

    /**
     * Liste alle Kunden anhand ihrer Branche auf.
     * Er stelle eine Map mit folgender Signatur: Map<Branche, List<Kunde>>
     * <p>
     * Die List<Kunde> soll alphabetisch nach den Firmennamen sortiert sein.
     */
    static Map<Branche, List<Kunde>> task5(List<Berater> beraterList) {

        return null;
    }


    /**
     * Optionale Aufgabe, falls du immer noch der Meinung bist, dass Stream unleserlicher sind als Java-7-Code:
     * Wiederhole Aufgabe 5, diesmal aber ohne Streams (╯°□°）╯︵ ┻━┻
     */
    static Map<Branche, List<Kunde>> task5b(List<Berater> beraterList) {

        return null;
    }


    /**
     * Kommst du auch mit Streams in Streams klar?
     * Erstelle eine Map, die als Key den Beraternamen enthält und als Value alle Branchen, mit denen er zu tun hat.
     */
    static Map<String, Set<Branche>> task6(List<Berater> beraterList) {

        return null;
    }



    /*
     * Genug von Collection-Manipulation mit Hilfe von Streams.
     *
     * Task 7) Implementiere folgende Methode indem du die Streams für primitive Datentypen nutzt:
     */

    /**
     * Diese Methode prüft, ob numberToTest eine Promzahl ist.
     * <p>
     * Dazu probiert sie alle Integers (i) von 2 bis numberToTest/2 durch und prüft ob
     * numberToTest % i == 0 ist. Dies soll parallel auf allen CPUs gesehen und beim erstbesten
     * Treffer aufhören.
     *
     * @param numberToTest wird geprüft ob es eine Primzahl ist
     * @return true, wenn es sich um eine Primzahl handelt, false, wenn nicht
     */
    static boolean checkPrime(int numberToTest) {

        return false;
    }


    /**
     * Schreibe deinen eigenen Reducer, um die Schuhgrößen aller Berater zu addieren.
     * <p>
     * Der Rückgabewert soll genau wie in der Demo ein BigInteger sein. Sonst wäre es ja zu einfach ;-)
     */
    static BigInteger task8(List<Berater> beraterList) {

        return null;
    }


}
