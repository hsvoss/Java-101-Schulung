import model.Obst;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AufgabenSession02Test {

    void task1() {
        // java.util.List
        // java.util.Set
        // java.util.Queue

        // hast du auch Map aufgelistet? Map ist keine Collection.
    }

    void task2() {
//        java.util.HashMap
//        java.util.LinkedHashMap
//        java.util.TreeMap
    }

    void task3() {
        // HashMap:
        // Der Klassiker um Key-Value-Paare in einer Map abzuspeichern
        // schnelle Zugriffszeiten für lesen, einfügen, löschen, wenn Key bekannt ist
        // ein Value pro Key, ungeordnet

        // LinkedHashMap:
        // Values liegen zusätzlich in einer LinkedList.
        // Daher haben die Objekte eine Ordnung: Insertion-Order

        // TreeMap:
        // Sortierung an Hand der Kardinalität der Keys.
        // Im Constructor der TreeMap kann zusätzlich ein Comperator angegeben werden.

    }

    @Test
    void task4() {
        // Die Methoden equals und hashCode von der Klasse Apfel sind sehr schlecht gewählt.
        // Lediglich die Stringlänge der 'sorte' wird als Vergleichskriterium verwendet.
        // Kann dir deine IDE helfen um bessere Methoden zu generieren/schreiben?

        Set<Obst> obstsalat = AufgabenSession02.task4();
        assertEquals(3, obstsalat.size());

    }

    void task5() {
        // Map<Branche, Set<Kunde>> telefonbuch;
    }


    void task6() {
        // Nach IEEE 754 werden Gleitkommazahlen aus dem Dezimalsystem im Computer
        // mit 64 Bit nur näherungsweise dargestellt. Die Repräsentation besteht aus
        // Vorzeichenbit, Exponent und Mantisse, welche im Binärsystem arbeiten.
        // Das bedeutet, dass alle Dezimalzahlen mit einer Addition
        // von Zweierpotenzen dargestellt werden.
        // Beispiel:
        // 0,0546875 = 1/32 + 1/64 + 1/128
        // 0,0546875 = 2^-5 + 2^-6 + 2^-7
        // Alle Zahlen, die sich nicht aus Zweierpotenzen zusammensetzten lassen
        // können gar nicht dargestellt werden. Beispiel 0,2
        // Man kann sich 0,2 jedoch recht genau annähern:
        // 0,2 =  1/8 + 1/16 + 1/128 + 1/256 + 1/2048 + 1/4096 ...
        // 0,2 = 2^-3 + 2^-4 + 2^-7  + 2^-8  + 2^-11  - 2^-12  ...

        // Um genau zu sein, kann man sich der Dezimalzahl 0,2 im Binärsystem beliebig genau annähern, da sie
        // im Binärsystem periodisch ist. Da wir jedoch nicht unendlich viele Bits zur Repräsentation
        // zur Verfügung haben, können nur beschränkt viele Zweierpotenzen addiert werden.

        // In der Demo habe ich das Ganze an Hand von Geldbeträgen erklärt. Diese kann man einfach nach vier
        // Nachkommastellen runden und der Schaden ist schlimmstenfalls im Cent-Bereich. Problematisch wird es,
        // wenn wir Chemikalien ab einer Konzentration von 0.2g anders klassifizieren sollen, jedoch
        // 0.199999999999999999 < 0.2 false ergibt.
    }


    @Test
    void task7() {
        BigDecimal result = AufgabenSession02.task7();
        assertEquals(new BigDecimal("11.4"), result);
        assertEquals(3, result.precision());

//        BigDecimal bigDecimalA = new BigDecimal("5.6");
//        BigDecimal bigDecimalB = new BigDecimal("5.8");
//        return bigDecimalA.add(bigDecimalB);
    }

    @Test
    void task8() {
        // Ein BigDecimal setzt sich aus 2 Werten zusammen: Scale und Precision
        // Beispiel: bei new BigDecimal("3.14")
        // Abgespeichert wird der unscaled Value: 314
        // Der Scale ist 2, denn der Dezimalpunkt muss 2 stellen nach links geschoben werden
        // Die Precision ist 3. Die Precision gibt nicht an, wie viele Zahlen hinterm Komma richtig sind.
        // Google lügt! Die Precision ist 3, denn Precision muss man Verstehen als:
        // "Alle drei Ziffern sind korrekt und signifikant."
        // Spiel ein wenig herum, damit du ein Gefühl dafür bekommst:

        BigDecimal f = new BigDecimal("10000");
//        BigDecimal f = new BigDecimal("10000.0");
//        BigDecimal f = new BigDecimal("10000.00");
//        BigDecimal f = new BigDecimal("3.14");
//        BigDecimal f = new BigDecimal("3.140");
        System.out.println("value: " + f);
        System.out.println("unscaled: " + f.unscaledValue());
        System.out.println("scale: " + f.scale());
        System.out.println("precision: " + f.precision());

    }


}
