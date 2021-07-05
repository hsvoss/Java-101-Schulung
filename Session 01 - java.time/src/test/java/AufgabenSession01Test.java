import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AufgabenSession01Test {


    void task1() {
//        Lösung:
//        LocalTime.now();
    }


    @Test
    void task2() {

//        Mit LocalTime.now() wird zwei mal auf die Uhr geschaut. Zwischen diesen beiden Momenten verstreichen
//        einige Millisekunden. Dies wird sichtbar, wenn man folgenden Code ausführt

        LocalTime a = LocalTime.now();
        LocalTime b = LocalTime.now();
        System.out.println(a);
        System.out.println(b);
    }


    @Test
    void task3() {
//        Lösung:
//        return LocalTime.parse(uhrzeit, DateTimeFormatter.ofPattern("H:m:s"));

        assertEquals(LocalTime.of(7, 13, 25), AufgabenSession01.task3("07:13:25"));
        assertEquals(LocalTime.of(7, 13, 25), AufgabenSession01.task3("7:13:25"));
        assertEquals(LocalTime.of(14, 7, 5), AufgabenSession01.task3("14:7:05"));
        assertEquals(LocalTime.of(1, 2, 3), AufgabenSession01.task3("1:2:3"));

    }

    @Test
    void task4() {
//        Lösung:
//        return LocalDate.now().getDayOfWeek();

        assertEquals(LocalDate.now().getDayOfWeek(), AufgabenSession01.task4());


    }

    @Test
    void task5() {
//        Lösung:
//        return LocalDate.now().getDayOfWeek().minus(1);

        assertEquals(LocalDate.now().getDayOfWeek().minus(1), AufgabenSession01.task5());
    }

    @Test
    void task6() {
//        Lösung:
//        LocalDate dayOfBirth = LocalDate.parse(input);
//        return dayOfBirth.plusDays(10000);

        assertEquals(LocalDate.parse("2019-10-26"), AufgabenSession01.task6("1992-06-09"));
        assertEquals(LocalDate.parse("2021-07-06"), AufgabenSession01.task6("1994-02-18"));
    }


    @Test
    void task7() {
//        Lösung:
//      Erstelle ein LocalTime-Objekt für 7 Uhr Morgens
        LocalTime siebenUhr = LocalTime.of(7, 0);
//      reichere 'siebenUhr' um das Datum 1. Februar 2003 an
        LocalDateTime siebenUhrMitDatum = siebenUhr.atDate(LocalDate.of(2003, 2, 1));
//      reichere 'siebenUhrMitDatum' um die Zeitzone von Tokyo an.
        ZonedDateTime tokyo = siebenUhrMitDatum.atZone(ZoneId.of("Asia/Tokyo"));
//      Objekt mit anderer Zeizzone vom selben Moment zurück geben lassen
        ZonedDateTime losAngles = tokyo.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));


//      Dein Ergebnis prüfen
        assertEquals(losAngles, AufgabenSession01.task7());


//      Um Momenten direkt zu vergleichen kann man gut den Instant nutzen
        Instant instantLosAngles = losAngles.toInstant();
        Instant instantTokyo = tokyo.toInstant();
        assertEquals(instantLosAngles, instantTokyo);
//      denn die ZonedDateTime sind nicht gleich - sind ja auch unterschiedliche Zeitzonen
        assertNotEquals(losAngles, tokyo);
    }


    void task8() {
        // Warum gibt es kein ZonedDate?
        // Auch wenn die Datumsgrenze durch den Pazifik verläuft, haben Zeitzonen keine Tage. Sie sind (fast immer) 24 Stunden lang.
        // Sonst müsste es ja "Tagzonen" heißen.


        // Warum gibt es kein ZonedTime?
        // Zeitzonen ändern sich häufig. Ort und Uhrzeit reichen nicht aus, um einen genauen Zeitpunkt in der
        // Vergangenheit oder Zukunft zu bestimmen.

        // Beispiel: Die Information "Sonntag um 17:35 Uhr, in Berlin" ist wertlos, wenn du das Datum nicht kennst.
        // Sprichst du von einem Zeitpunkt zu dem Winterzeit oder Normalzeit galt?
        // Sprichst du von einem Zeitpunkt der vor oder nach 1980 liegt?
        // Es gab sogar mal zwei Zeitzonen in Berlin: Ost- oder West-Zeit?

        // Besonders knifflig wird es mit Zeitpunkten in der Zukunft. Beispiel: "12:00 Uhr am 24.12.2022" in Berlin.
        // Ob die Winterzeit bis dahin abgeschafft wird, wissen wir heute noch nicht. Einzige Lösung: Libraries regelmäßig updaten.

    }

    @Test
    void task9() {
//      Lösung:
//      LocalDate deutschesWeihnachten = LocalDate.of(2021, 12, 24);
//      LocalDate russischesWeihnachten = LocalDate.of(2022, 1, 7);
//
//      Period zeitperiode = Period.between(deutschesWeihnachten, russischesWeihnachten);
//      return zeitperiode.getDays();

        assertEquals(14, AufgabenSession01.task9());

    }
}
