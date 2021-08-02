import model.Saft;
import model.Sorte;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import static model.Sorte.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AufgabenSession03Test {

    void task1() {
        // Ein Interface, dass die Annotation @FunctionalInterface trägt,
        // hat genau eine abstrakte Methode.
        // Es kann weitere Methoden definieren, muss dann aber für diese auch eine
        // Default-Implementierung enthalten.
    }

    void task2() {
//        Interface: Function<T, R> Typen:  T -> R
//        Interface: Supplier<T>    Typen:  () -> T
//        Interface: Consumer<T>    Typen:  T -> void
//        Interface: Predicate<T>   Typen:  T -> boolean
//        Interface: Runnable<T>    Typen:  () -> void
    }

    void task3() {
        // Diese Functions sind identisch.
        // Mir half es am Anfang sehr, die Schreibweisen 4 und 5 zu verwenden
        // und dann meine IDE die Lambdas 'kürzen' zu lassen. Alt + Enter
        Function<Saft, Integer> ermittelMenge1 = new Function<>() {
            @Override
            public Integer apply(Saft saft) {
                return saft.getMilliliter();
            }
        };

        Function<Saft, Integer> ermittelMenge2 = saft -> saft.getMilliliter();
        Function<Saft, Integer> ermittelMenge3 = Saft::getMilliliter;
        Function<Saft, Integer> ermittelMenge4 = (Saft saft) -> saft.getMilliliter();
        Function<Saft, Integer> ermittelMenge5 = (Saft saft) -> {
            return saft.getMilliliter();
        };
    }

    void task4() {
        Saft aSaft = new Saft(APFEL, 500);
        Saft bSaft = new Saft(Sorte.BIRNE, 1000);

        Function<Saft, Integer> ermittelMenge3 = (Saft saft) -> saft.getMilliliter();
        // Führe die Function 'ermittelMenge3' aus.
        Integer milliliter3 = ermittelMenge3.apply(aSaft);

        // Schaue dir den Rückgabetypen an: Es ist der große Integer. Kannst du einen analogen
        // Lambda-Ausdruck aufschreiben, der den kleinen int zurück gibt?
        ToIntFunction<Saft> ermittelMenge6 = (Saft saft) -> saft.getMilliliter();
        int milliliter6 = ermittelMenge6.applyAsInt(aSaft);
    }

    @Test
    void task5() {
        //Lösungsvorschlag:
//        BinaryOperator<Set<Sorte>> union = (sorte1, sorte2) -> {
//            Set<Sorte> sorten = new HashSet<>(sorte1);
//            sorten.addAll(sorte2);
//            return sorten;
//        };
//
//        return union;

        BiFunction<Set<Sorte>, Set<Sorte>, Set<Sorte>> setUnion = AufgabenSession03.task5();

        Set<Sorte> union1 = setUnion.apply(Collections.emptySet(), Set.of(CLEMENTINE, ERDBEERE));
        assertEquals(Set.of(CLEMENTINE, ERDBEERE), union1);

        Set<Sorte> union2 = setUnion.apply(Collections.emptySet(), Collections.emptySet());
        assertEquals(Collections.emptySet(), union2);


        Set<Sorte> union3 = setUnion.apply(Set.of(APFEL, BIRNE), Set.of(CLEMENTINE, ERDBEERE));
        assertEquals(Set.of(APFEL, BIRNE, CLEMENTINE, ERDBEERE), union3);
        assertEquals(4, union3.size());


        Set<Sorte> unionAll = setUnion.apply(setUnion.apply(union1, union2), union3);
        assertEquals(Set.of(APFEL, BIRNE, CLEMENTINE, ERDBEERE), unionAll);
        assertEquals(4, unionAll.size());

    }

    @Test
    void task6() {
        //Lösungsvorschlag:
//        BiFunction<Set<Sorte>, Set<Sorte>, Set<Sorte>> union = task5();
//
//        return (aSaft, bSaft) -> new Saft(union.apply(aSaft.getSorte(), bSaft.getSorte())
//                , aSaft.getMilliliter() + bSaft.getMilliliter());

        BinaryOperator<Saft> mixer = AufgabenSession03.task6();

        Saft apfelBirnenSaft = mixer.apply(new Saft(APFEL, 100), new Saft(BIRNE, 200));
        assertEquals(apfelBirnenSaft, new Saft(Set.of(BIRNE, APFEL), 300));
    }


    void  task7(){
        // Lösungsvorschlag:
//        Instant start = Instant.now();
//        for (int i = 0; i < 10; i++) {
//            BigInteger prime = api.generatePrime();
//            System.out.println(prime);
//        }
//        Instant end = Instant.now();
//        System.out.println(Duration.between(start, end)); // PT10.9176595S // Ca. 1 Sekunde im Durchschnitt
    }

    void task8(){
        // Lösungsvorschlag:
//        a)
//        Set<BigInteger> primzahlen = new HashSet<>();
//
//        for (int i = 0; i < 20; i++) {
//            BigInteger prime = api.generatePrime();
//            primzahlen.add(prime);
//            System.out.println(prime);
//        }
//        System.out.println(primzahlen);

//        b & c)
//        Instant globalStart = Instant.now();
//        List<CompletableFuture<Void>> futures = new LinkedList<>();
//        Set<BigInteger> primzahlen = Collections.synchronizedSet(new HashSet<>());
//
//        for (int i = 0; i < 20; i++) {
//            CompletableFuture<BigInteger> primeFuture = CompletableFuture.supplyAsync(() -> api.generatePrime()); // 1. neuer Thread
//            primeFuture.thenAcceptAsync(prime -> System.out.println(prime)); // 2. neuer Thread um eine Ausgabe
//            CompletableFuture<Void> futureAufDasWirWartenWollen = primeFuture.thenAccept(prime -> primzahlen.add(prime));  // immer noch 1. neuer Thread
//            futures.add(futureAufDasWirWartenWollen);
//        }
//
//        futures.forEach(future -> future.join()); // hält den Hauptthread solange an,
//        // bis alle futures terminiert sind.
//        Instant globalEnd = Instant.now();
//        System.out.println("Gesamtlaufzeit: " + Duration.between(globalStart, globalEnd));
//        System.out.println(primzahlen);

//      d)
//        Instant globalStart = Instant.now();
//        List<CompletableFuture<Void>> futures = new LinkedList<>();
//
//        List<Duration> allDurations = Collections.synchronizedList(new LinkedList<>());
//        Set<BigInteger> primzahlen = Collections.synchronizedSet(new HashSet<>());
//
//        for (int i = 0; i < 20; i++) {
//            CompletableFuture<Void> futureAufDasWirWartenWollen = CompletableFuture.supplyAsync(() -> Instant.now())
//                    .thenApply(start -> new PrimeAndInstant(api.generatePrime(), start))
//                    .thenApply(primeAndInstant -> {
//                        primzahlen.add(primeAndInstant.getPrime());
//                        return Duration.between(primeAndInstant.getInstant(), Instant.now());
//                    })
//                    .thenAccept(duration -> allDurations.add(duration));
//            futures.add(futureAufDasWirWartenWollen);
//        }
//
//        futures.forEach(future -> future.join()); // hält den Hauptthread solange an,
//        // bis alle futures terminiert sind.
//
//
//        Instant globalEnd = Instant.now();
//        Duration sum = Duration.ZERO;
//        for (Duration duration : allDurations) {
//            sum = sum.plus(duration);
//        }
//
//        System.out.println("Gesamtlaufzeit: " + Duration.between(globalStart, globalEnd));
//        System.out.println("Gesamtlaufzeit aller Threads: " + sum);
//        System.out.println(primzahlen);
    }


    void task9(){
        // Lösungsvorschlag:
//        CompletableFuture<BigInteger> future1 = CompletableFuture.supplyAsync(() -> api.generatePrime())
//                .exceptionally(throwable -> BigInteger.ONE);
//        CompletableFuture<BigInteger> future2 = CompletableFuture.supplyAsync(() -> api.generatePrime())
//                .exceptionally(throwable -> BigInteger.ONE);
//
//        future1 = future1.thenCombine(future2, (prime1, prime2) -> {
//            if (BigInteger.ONE.equals(prime1) && BigInteger.ONE.equals(prime2)) {
//                return BigInteger.ZERO;
//            } else {
//                return prime1.multiply(prime2);
//            }
//        });
//
//
//        for (int i = 0; i < 1000; i++) {
//            Thread.sleep(100);
//            System.out.println("Zehntelsekunden gewartet: " + i);
//            if (future1.isDone()) {
//                break;
//            }
//        }
//        BigInteger bigInteger = future1.join();
//        System.out.println("Produkt: " + bigInteger);
//        return bigInteger;
    }

    void task10() {
        // Lösungsvorschlag:
//        CompletableFuture.supplyAsync(() -> api.generatePrime())
//                .orTimeout(1, TimeUnit.SECONDS)
//                .whenComplete((bigInteger, throwable) -> {
//                    if (throwable != null) {
//                        errorCallback.accept(throwable);
//                    } else {
//                        callback.accept(bigInteger);
//                    }
//                });
    }

}
