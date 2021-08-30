import model.Saft;
import model.Sorte;
import prime.PrimeApi;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class AufgabenSession03 {

//    Stöbert in:
//    https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
//    https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html
//    https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html


    public static void main(String[] args) throws InterruptedException {
        task5();
//        task7(new PrimeApiImpl());
//        task8(new PrimeApiImpl());
//        task9(new PrimeApiImpl());
    }

    /**
     * Nenne die wichtigste Eigenschaft von Interfaces mit der Annotation @FunctionalInterface?
     */
    static void task1() {
    }

    /**
     * Es gibt fünf wichtige Functional Interfaces.
     * a) Nenne sie.
     * b) Schreibe den jeweiligen Methodenkopf der abstrakten Methode auf.
     * (Zettel + Stift, Pfeile reichen wie im Cheat Sheet, du kannst aber
     * UML-Klassendiagramme zeichnen)
     */
    static void task2() {
    }

    /**
     * Schaue die die Klassen im package 'model' an.
     */
    static void task3() {
        Saft aSaft = new Saft(Sorte.APFEL, 500);
        Saft bSaft = new Saft(Sorte.BIRNE, 1000);

        // Für die Function ermittelMenge gibt es noch andere Schreibweisen. #Syntactic Sugar
        // Schreibe mindestens drei auf. Vielleicht hilft die ja deine IDE...
        Function<Saft, Integer> ermittelMenge1 = new Function<>() {
            @Override
            public Integer apply(Saft saft) {
                return saft.getMilliliter();
            }
        };

    }


    static void task4() {
        Saft aSaft = new Saft(Sorte.APFEL, 500);
        Saft bSaft = new Saft(Sorte.BIRNE, 1000);

        Function<Saft, Integer> ermittelMenge3 = (Saft saft) -> saft.getMilliliter();
        // Führe die Function 'ermittelMenge3' aus.


        // Schaue dir den Rückgabetypen an: Es ist der große Integer. Kannst du einen analogen
        // Lambda-Ausdruck aufschreiben, der den kleinen int zurückgibt?

    }

    /**
     * Implementiere einen Lambda-Ausdruck der zwei Sets vereinigt.
     * Gibt es eine bessere Signatur als BiFunction<Set<Sorte>, Set<Sorte>, Set<Sorte>>
     */
    static BiFunction<Set<Sorte>, Set<Sorte>, Set<Sorte>> task5() {
        BinaryOperator<Set<Sorte>> union = (sorte1, sorte2) -> {
            Set<Sorte> sorten = new HashSet<>(sorte1);
            sorten.addAll(sorte2);
            return sorten;
        };

        return union;
    }


    /**
     * Schreibe einen Lambda-Ausdruck der Saft A und B mischt.
     */
    static BinaryOperator<Saft> task6() {

        BiFunction<Set<Sorte>, Set<Sorte>, Set<Sorte>> union = task5();

        return (aSaft, bSaft) -> new Saft(union.apply(aSaft.getSorte(), bSaft.getSorte())
                , aSaft.getMilliliter() + bSaft.getMilliliter());

    }

    /**
     * Schaue dir das Interface PrimeApi an. Sie enthält eine Methode. Die Implementierung ist komplett unwichtig.
     * Es ist keine "echte" Api, die mit einem entfernten Server über das Internet kommuniziert.
     * Dennoch haben die Methoden ähnliche Eigenschaften. Du weißt nicht genau wann die Methoden
     * terminieren und ob Exceptions fliegen.
     * Spiele ein wenig mit der Methode generatePrime() herum und lasse dir ein paar Primzahlen zurückgeben,
     * um ein Gefühl für die API zu bekommen.
     * Miss die Laufzeit. Falls die Laufzeit für deinen PC viel zu kurz oder zu lang ist, passe die BIT_LENGTH an.
     */
    static void task7(PrimeApi api) {
        Instant start = Instant.now();
        for (int i = 0; i < 10; i++) {
            BigInteger prime = api.generatePrime();
            System.out.println(prime);
        }
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end)); // PT10.9176595S

    }

    /**
     * a) Rufe api.generatePrime() 20 Mal auf und speichere sie ab.
     * b) Rufe api.generatePrime() 20 Mal auf. Nutze dabei CompletableFuture um die Aufrufe zu parallelisieren.
     * c) Miss die Gesamtlaufzeit
     * d) Addiere die Laufzeiten innerhalb der Threads
     *
     * @param api task8(new PrimeApiImpl());
     */
    static void task8(PrimeApi api) {

    }

    /**
     * Gehe in das Interface PrimeApi und setze CHANCE_TO_FAIL auf 30. Ab jetzt musst du damit klarkommen,
     * dass die Api vielleicht kein Ergebnis returned.
     */
    static BigInteger task9(PrimeApi api) throws InterruptedException {

        // Versuche dir in 2 Parallelen Threads jeweils eine Primzahl zu holen.

        // Wenn du zwei Primezahlen hast, dann multipliziere sie.
        // Der Returnvalue soll das Produkt zurückgeben. Falls du nur eine Primzahl bekommst, dann gib diese zurück.
        // Wenn du keine Primzahl bekommst, dann gibt NULL als BigInteger zurück.
        // Lasse den Hauptthread erst terminieren, wenn die beiden anderen Threads terminiert sind.
        // Du darfst dich gerne mathematischer Tricks bedienen.

        CompletableFuture<BigInteger> future1 = null;

        for (int i = 0; i < 1000; i++) {
            Thread.sleep(100);
            System.out.println("Zehntelsekunden gewartet: " + i);
            if (future1.isDone()) {
                break;
            }
        }

        return null;
    }


    /**
     * Implementiere diese Methode so, dass gilt:
     * <p>
     * Diese Methode führt immer einen der angegebenen Callbacks aus. Entweder den callback oder den errorCallback.
     * Diese Methode wirft keine Exceptions. Wenn die API eine Exception wirft, wird der errorCallback mit ihr ausgerufen.
     * Wenn die API eine Sekunde lang keine Antwort liefert, wird der errorCallback mit einer TimeoutException aufgerufen.
     *
     * @param api           die PrimeApi
     * @param callback      wird ausgeführt, wenn der API-Aufruf erfolgreich war
     * @param errorCallback wird ausgeführt, wenn der API-Aufruf nicht erfolgreich war,
     *                      oder noch 10 Sekunden mit einer TimeoutException
     */
    static void task10(PrimeApi api, Consumer<BigInteger> callback, Consumer<Throwable> errorCallback) {

        CompletableFuture.supplyAsync(() -> api.generatePrime())
                .orTimeout(1, TimeUnit.SECONDS)
                .whenComplete((bigInteger, throwable) -> {
                    if (throwable != null) {
                        errorCallback.accept(throwable);
                    } else {
                        callback.accept(bigInteger);
                    }
                });

    }

    /**
     * Nur relevant, falls du viel mit SWT-Basierten Projekten zu tun hast.
     */
    static void task11() {
//        Der Haupt-Thread ist der SWT-Thread. SWT wirft Exceptions, wenn man versucht Controls von einem anderen Thread
//        zu beeinflussen. Zusätzlich gibt es im SWT-Thread eine Queue von Runnables. Diese Queue regelmäßig
//        abgearbeitet und jeder Runnable wird ausgeführt.
//        Schaue dir die zwei polymorphen Methoden in der Klasse Utils an. Überlege dir inwiefern diese Methoden
//        nützlich sein können, wenn man beispielsweise eine thread-blockierende API von einem CompletableFuture-Thread
//        aus aufruf.

    }


    /**
     * Wiederhole Task 2 ohne zu gucken.
     * Es gibt fünf wichtige Functional Interfaces.
     * a) Nenne sie.
     * b) Schreibe den jeweiligen Methodenkopf der abstrakten Methode auf.
     * c) Lerne sie auswendig. In Session04 behandeln wir Streams und Optionals, dann wirst du sie benötigen.
     */
    static void task12() {
    }
}