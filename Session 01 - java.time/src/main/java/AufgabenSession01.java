import java.time.*;

public class AufgabenSession01 {

    // Java Doc: https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html
    // Vortragsempfehlung: 'Ein Tag hat nur 24±1 Stunden' von Miroslav Šedivý  https://www.youtube.com/watch?v=Q7-Hw0SM9x0
    // Schulungsmaterial von Ralf Domnik: https://visionconsultinggmbhcokg.sharepoint.com/austausch/Dokumente/Forms/AllItems.aspx?RootFolder=%2Faustausch%2FDokumente%2FKurse%5FSchulungen%2FUnterlagen%2FJava%20Inhouse%20Schulung%202019&FolderCTID=0x012000F45E9AA57E72BA4BBD2AFD8A398DD1A9

    public static void main(String[] args) {
        task2();
//        task3("07:13:25");
//        task3("7:13:25");
//        task3("14:7:05");
//        task6("1992-06-09");
//        task8();
    }

    /**
     * Welche Uhrzeit haben wir jetzt?
     */
    static LocalTime task1() {
        return null;
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

    /**
     * Denke über folgende Fragen nach:
     */
    static void task8() {
        // Es gibt die Klassen LocalTime, LocalDate, LocalDateTime und ZonedDateTime.
        // Warum gibt es kein ZonedDate?
        // Warum gibt es kein ZonedTime?
    }

    /**
     * In Russland wird Weihnachten erst am 7. Januar gefeiert.
     * Wie viele Tage müssen die Kinder länger auf ihre Geschenke warten?
     * Tipp: schau dir mal Period und Duration an.
     * @return der int soll die Tageszahl enthalten
     */
    static int task9() {

      return 0;
    }
}