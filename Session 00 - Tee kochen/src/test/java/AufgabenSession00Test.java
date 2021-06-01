import model.Tasse;
import model.Zutaten;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AufgabenSession00Test {

    private Tasse tasse;

    @BeforeEach
    void setUp() {
        AufgabenSession00 aufgabenSession00 = new AufgabenSession00();
        tasse = aufgabenSession00.aufgabe1();
    }

    @AfterEach
    void tearDown() {
        tasse = null;
    }

    @Test
    void notNull() {
        assertNotNull(tasse, "Die Tasse ist null.");
        assertNotNull(tasse.getZutaten(), "Die Zutatenliste ist null.");
    }


    @Test
    void wasser() {
        assertTrue(tasse.getZutaten().contains(Zutaten.WASSER), "Der Tee sollte schon etwas flüssiger sein.");
    }

    @Test
    void tee() {
        assertTrue(tasse.getZutaten().contains(Zutaten.TEEBLAETTER), "Du musst Teeblätter in die Tasse tun.");
    }

    @Test
    void milch() {
        assertTrue(tasse.getZutaten().contains(Zutaten.MILCH), "Du hast die Milch vergessen.");
    }

    @Test
    void zucker() {
        assertTrue(tasse.getZutaten().contains(Zutaten.ZUCKER), "Tu etwas Zucker rein.");
    }


    @Test
    void ganzVorsichtigProbieren() {

        assertTrue(tasse.getZutaten().containsAll(List.of(Zutaten.MILCH, Zutaten.WASSER, Zutaten.ZUCKER, Zutaten.TEEBLAETTER)));

        assertEquals(4,
                tasse.getZutaten().stream()
                        .filter(zutat -> List.of(Zutaten.MILCH, Zutaten.WASSER, Zutaten.ZUCKER, Zutaten.TEEBLAETTER).contains(zutat))
                        .count(), "Irgendetwas stimmt nicht. ICh glaube du hast dich mit den Mengen vertan.");

        List<Zutaten> falscheZutaten = tasse.getZutaten().stream()
                .filter(zutat -> !List.of(Zutaten.MILCH, Zutaten.WASSER, Zutaten.ZUCKER, Zutaten.TEEBLAETTER).contains(zutat))
                .collect(Collectors.toList());

        assertTrue(falscheZutaten.isEmpty(), "Willst du mich vergiften? warum tust du "+
                falscheZutaten.stream().map(Zutaten::getName).collect(Collectors.joining(","))
                + " in meinen Tee?");
    }


}