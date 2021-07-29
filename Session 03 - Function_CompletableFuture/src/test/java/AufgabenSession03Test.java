import model.Saft;
import model.Sorte;

import java.util.function.Function;
import java.util.function.ToIntFunction;

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


}
