import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class AufgabenSession01 {


    public static void main(String[] args) {
        task1();
//        task2();
//        task3("07:13:25");
//        task3("7:13:25");
//        task3("14:7:05");
//        task6("1992-06-09");
    }

    /**
     * Welche Uhrzeit haben wir jetzt?
     */
    static LocalTime task1() {
        return LocalTime.now();
    }

    /**
     * Überlege dir weshalb ergibt 'b' false
     */
    static void task2() {
        boolean b = LocalTime.now() == LocalTime.now();
        System.out.println(b); // false
    }


    /**
     * Schaue dir die DateTimeFormatter zum parsen von Uhrzeiten an. Es wird eine Normale Uhrzeit Übergeben. Zum Beispiel "7:13:25" oder 14:7:05
     */
    static LocalTime task3(String uhrzeit) {

        return null;
    }


    /**
     * Genug von Uhrzeiten. Jetzt geht es um Tage. Welchen Wochentag haben wird heute?
     */
    static DayOfWeek task4() {

        return null;
    }

    /**
     * Und welcher Wochentag war gestern?
     */
    static DayOfWeek task5() {

        return null;
    }

    /**
     * Am 1992-06-09 kam ich zu Welt. Wann werde ich 10000 Tage alt?
     */
    static LocalDate task6(String input) {

        return null;
    }

    /**
     * Am 1. Februar 2003 ist in Tokyo um 07:00 Uhr morgens ein Sack Reis umgefallen.
     * Wie spät war es in diesem Moment in Los Angeles?
     */
    static ZonedDateTime task7() {

        return null;
    }
}