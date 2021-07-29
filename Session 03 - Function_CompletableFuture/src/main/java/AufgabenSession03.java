import model.Saft;
import model.Sorte;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class AufgabenSession03 {

//    Stöbert in:
//    https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
//    https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html
//    https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html


    public static void main(String[] args) {
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

        Function<Saft, Integer> ermittelMenge2 = saft -> saft.getMilliliter();
        Function<Saft, Integer> ermittelMenge3 = (Saft saft) -> saft.getMilliliter();
        Function<Saft, Integer> ermittelMenge4 = Saft::getMilliliter;
    }


    static void task4() {
        Saft aSaft = new Saft(Sorte.APFEL, 500);
        Saft bSaft = new Saft(Sorte.BIRNE, 1000);

        Function<Saft, Integer> ermittelMenge3 = (Saft saft) -> saft.getMilliliter();
        // Führe die Function 'ermittelMenge3' aus.
        Integer milliliter3 = ermittelMenge3.apply(aSaft);

        // Schaue dir den Rückgabetypen an: Es ist der große Integer. Kannst du einen analogen
        // Lambda-Ausdruck aufschreiben, der den kleinen int zurück gibt?
        ToIntFunction<Saft> ermittelMenge6 = (Saft saft) -> saft.getMilliliter();
        int milliliter6 = ermittelMenge6.applyAsInt(aSaft);


    }


    /**
     * Wiederhole Task 2 ohne zu gucken.
     * Es gibt fünf wichtige Functional Interfaces.
     * a) Nenne sie.
     * b) Schreibe den jeweiligen Methodenkopf der abstrakten Methode auf.
     * c) Lerne sie auswendig :-P
     */
    static void task10() {
    }
}