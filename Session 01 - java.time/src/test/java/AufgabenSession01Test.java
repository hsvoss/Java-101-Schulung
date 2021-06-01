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


}
