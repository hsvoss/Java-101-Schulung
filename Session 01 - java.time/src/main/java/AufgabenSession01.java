import java.time.*;
import java.time.format.DateTimeFormatter;

public class AufgabenSession01 {

    // Java Doc: https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html
    // Vortragsempfehlung: 'Ein Tag hat nur 24±1 Stunden' von Miroslav Šedivý  https://www.youtube.com/watch?v=Q7-Hw0SM9x0
    // Schulungsmaterial von Ralf Domnik: https://visionconsultinggmbhcokg.sharepoint.com/austausch/Dokumente/Forms/AllItems.aspx?RootFolder=%2Faustausch%2FDokumente%2FKurse%5FSchulungen%2FUnterlagen%2FJava%20Inhouse%20Schulung%202019&FolderCTID=0x012000F45E9AA57E72BA4BBD2AFD8A398DD1A9

    public static void main(String[] args) {
        task9();
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
     * Schaue dir die DateTimeFormatter zum parsen von Uhrzeiten an. Es wird eine normale Uhrzeit übergeben. Zum Beispiel "7:13:25" oder 14:7:05
     */
    static LocalTime task3(String uhrzeit) {

        return LocalTime.parse(uhrzeit, DateTimeFormatter.ofPattern("H:m:s"));
    }


    /**
     * Genug von Uhrzeiten. Jetzt geht es um Tage. Welchen Wochentag haben wird heute?
     */
    static DayOfWeek task4() {

        return LocalDate.now().getDayOfWeek();
    }

    /**
     * Und welcher Wochentag war gestern?
     */
    static DayOfWeek task5() {
        return LocalDate.now().getDayOfWeek().minus(1);
    }

    /**
     * Am 1992-06-09 kam ich zu Welt. Wann werde ich 10000 Tage alt?
     */
    static LocalDate task6(String input) {
        LocalDate dayOfBirth = LocalDate.parse(input);
        return dayOfBirth.plusDays(10000);
    }

    /**
     * Am 1. Februar 2003 ist in Tokyo um 07:00 Uhr morgens ein Sack Reis umgefallen.
     * Wie spät war es in diesem Moment in Los Angeles?
     */
    static ZonedDateTime task7() {
//      Erstelle ein LocalTime-Objekt für 7 Uhr Morgens
        LocalTime siebenUhr = LocalTime.of(7, 0);
//      reichere 'siebenUhr' um das Datum 1. Februar 2003 an
        LocalDateTime siebenUhrMitDatum = siebenUhr.atDate(LocalDate.of(2003, 2, 1));
//      reichere 'siebenUhrMitDatum' um die Zeitzone von Tokyo an.
        ZonedDateTime tokyo = siebenUhrMitDatum.atZone(ZoneId.of("Asia/Tokyo"));
//      Objekt mit anderer Zeizzone vom selben Moment zurück geben lassen
        ZonedDateTime losAngles = tokyo.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));

        return losAngles;
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
     *
     * @return der int soll die Tageszahl enthalten
     */
    static int task9() {
        LocalDate deutschesWeihnachten = LocalDate.of(2021, 12, 24);
        LocalDate russischesWeihnachten = LocalDate.of(2022, 1, 7);

        Period zeitperiode = Period.between(deutschesWeihnachten, russischesWeihnachten);
        System.out.println(zeitperiode);
        return zeitperiode.getDays();

    }
}