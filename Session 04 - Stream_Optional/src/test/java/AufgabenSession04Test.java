import model.Berater;
import model.Branche;
import model.Kunde;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AufgabenSession04Test {


    @Test
    void task1() {
        //Lösungsvorschlag:
//        return beraterList.stream()
//                .filter(berater -> berater.getKunden().size() == 1)
//                .collect(Collectors.toList());


        List<Berater> expectedData = Helper.generateData().stream()
                .filter(berater -> berater.getKunden().size() == 1)
                .collect(Collectors.toList());

        List<Berater> actualData = AufgabenSession04.task1(Helper.generateData());

        assertEquals(expectedData, actualData);
    }

    void task2() {
        //Lösungsvorschlag:
//        beraterList.stream()
//                .parallel()
//                .forEach(berater -> System.out.println(berater.getName()));

        // Es fällt auf, dass die Ausgabe-Reihenfolge zufällig ist und wir uns nicht darauf verlassen können,
        // dass die ForEach-Loop immer in derselben Reihenfolge ausgeführt wird.
        // Mit einem .forEachOrdered() können wir das natürlich erzwingen.

    }


    @Test
    void task3() {
// Lösungsvorschlag:
//        return beraterList.stream()
//                .filter(berater -> berater.getKunden().size() == 1)
//                .map(Berater::getName)
//                .collect(Collectors.toSet());

// alternativer Lösungsvorschlag:
//        beraterList.stream()
//                .filter(berater -> berater.getKunden().size() == 1)
//                .distinct()
//                .map(Berater::getName)
//                .collect(Collectors.toList());


        List<Berater> testData = new ArrayList<>(Helper.generateData());
        testData.add(new Berater("Dave", 42, Set.of(
                new Kunde("Lidl", Branche.EDV))));
        testData.add(new Berater("Dave", 42, Set.of(
                new Kunde("Lidl", Branche.EDV))));


        Set<String> expectedData = testData.stream()
                .filter(berater -> berater.getKunden().size() == 1)
                .map(Berater::getName)
                .collect(Collectors.toSet());

        Collection<String> actualData = AufgabenSession04.task3(testData);

        assertEquals(expectedData.stream().sorted().collect(Collectors.toList()),
                actualData.stream().sorted().collect(Collectors.toList()));
    }


    @Test
    void task4() {
        // Jaja, ich bin gemein: ein Set hat eigentlich keine Reihenfolge.
        // Aber hat dir vielleicht deine IDE geholfen?

// Lösungsvorschlag:
//        return beraterList.stream()
//                .filter(berater -> berater.getKunden().size() >= 2)
//                .flatMap(berater -> berater.getKunden().stream())
//                .map(Kunde::getFirmenname)
//                .sorted()
//                .collect(Collectors.toCollection(LinkedHashSet::new));

        List<Berater> testData = new ArrayList<>(Helper.generateData());


        Set<String> expectedData = testData.stream()
                .filter(berater -> berater.getKunden().size() >= 2)
                .flatMap(berater -> berater.getKunden().stream())
                .map(Kunde::getFirmenname)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Collection<String> actualData = AufgabenSession04.task4(testData);

        assertEquals(expectedData, actualData);
    }


    @Test
    void task5() {
// Lösungsvorschlag:
//        return beraterList.stream()
//                .flatMap(berater -> berater.getKunden().stream())
//                .sorted(Comparator.comparing(Kunde::getFirmenname))
//                .collect(Collectors.groupingBy(Kunde::getBranche));

        List<Berater> testData = new ArrayList<>(Helper.generateData());

        Map<Branche, List<Kunde>> expectedData = testData.stream()
                .flatMap(berater -> berater.getKunden().stream())
                .sorted(Comparator.comparing(Kunde::getFirmenname))
                .collect(Collectors.groupingBy(Kunde::getBranche));

        Map<Branche, List<Kunde>> actualData = AufgabenSession04.task5(testData);

        assertEquals(expectedData, actualData);
    }

    @Test
    void task5b() {
// Lösungsvorschlag:
//        List<Kunde> toSort = new ArrayList<>();
//        for (Berater berater : beraterList) {
//            for (Kunde kunde : berater.getKunden()) {
//                toSort.add(kunde);
//            }
//        }
//        toSort.sort(Comparator.comparing(Kunde::getFirmenname));
//        Map<Branche, List<Kunde>> map = new HashMap<>();
//        for (Kunde kunde : toSort) {
//            map.computeIfAbsent(kunde.getBranche(), k -> new ArrayList<>()).add(kunde);
//        }
//        return map;

        List<Berater> testData = new ArrayList<>(Helper.generateData());

        Map<Branche, List<Kunde>> expectedData = testData.stream()
                .flatMap(berater -> berater.getKunden().stream())
                .sorted(Comparator.comparing(Kunde::getFirmenname))
                .collect(Collectors.groupingBy(Kunde::getBranche));

        Map<Branche, List<Kunde>> actualData = AufgabenSession04.task5b(testData);

        assertEquals(expectedData, actualData);
    }


    @Test
    void task6() {
// Lösungsvorschlag:
//        return beraterList.stream()
//                .collect(Collectors.toMap(Berater::getName, berater -> berater.getKunden().stream()
//                        .map(Kunde::getBranche).collect(Collectors.toSet()))
//                );

        List<Berater> testData = new ArrayList<>(Helper.generateData());

        Map<String, Set<Branche>> expectedData = testData.stream()
                .collect(Collectors.toMap(Berater::getName, berater -> berater.getKunden().stream()
                        .map(Kunde::getBranche).collect(Collectors.toSet()))
                );

        Map<String, Set<Branche>> actualData = AufgabenSession04.task6(testData);

        assertEquals(expectedData, actualData);
    }


    @Test
    void task7() {
// Lösungsvorschlag:
//        boolean noPrime = IntStream.range(2, (numberToTest + 1) / 2)
//                .parallel()
//                .anyMatch(i -> numberToTest % i == 0);
//        return !noPrime;

//        Oder mit:
//        IntStream.rangeClosed(2, numberToTest / 2)

        // Laufzeit des Tests mit .parallel(): ca. 6 Sek, ohne: ca. 20 Sek

        assertTrue(AufgabenSession04.checkPrime(331));
        assertTrue(AufgabenSession04.checkPrime(661));

        assertFalse(AufgabenSession04.checkPrime(323));
        assertFalse(AufgabenSession04.checkPrime(667));


        // Versucht bei den hier nicht den Stream Trace zu öffnen :-P
        assertTrue(AufgabenSession04.checkPrime(1630548889));
        assertTrue(AufgabenSession04.checkPrime(1819420133));
        assertTrue(AufgabenSession04.checkPrime(1465144531));
        assertTrue(AufgabenSession04.checkPrime(1867488269));
        assertTrue(AufgabenSession04.checkPrime(1393490699));
        assertTrue(AufgabenSession04.checkPrime(1537557883));
        assertTrue(AufgabenSession04.checkPrime(1537557883));

        assertFalse(AufgabenSession04.checkPrime(114961163));
        assertFalse(AufgabenSession04.checkPrime(124272587));
        assertFalse(AufgabenSession04.checkPrime(479229187));
        assertFalse(AufgabenSession04.checkPrime(1900872737));
        assertFalse(AufgabenSession04.checkPrime(1995389579));


//        assertEquals(expectedData, actualData);
    }


    @Test
    void task8() {
// Lösungsvorschlag:
//        return beraterList.stream()
//                .map(Berater::getSchuhgroesse)
//                .reduce(
//                        BigInteger.ZERO,
//                        (BigInteger bigInteger, Integer integer) -> bigInteger.add(BigInteger.valueOf(integer)),
//                        BigInteger::add
//                );

        List<Berater> testData = new ArrayList<>(Helper.generateData());
        testData.add(new Berater("Bigfoot", Integer.MAX_VALUE, Collections.emptySet()));

        BigInteger expectedData = testData.stream()
                .map(Berater::getSchuhgroesse)
                .reduce(
                        BigInteger.ZERO,
                        (BigInteger bigInteger, Integer integer) -> bigInteger.add(BigInteger.valueOf(integer)),
                        BigInteger::add
                );
        BigInteger actualData = AufgabenSession04.task8(testData);

        assertEquals(expectedData, actualData);

    }

}