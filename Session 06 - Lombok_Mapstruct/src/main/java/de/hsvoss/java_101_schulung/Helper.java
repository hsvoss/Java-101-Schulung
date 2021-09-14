package de.hsvoss.java_101_schulung;


import de.hsvoss.java_101_schulung.domain.Berater;
import de.hsvoss.java_101_schulung.domain.Branche;
import de.hsvoss.java_101_schulung.domain.Kunde;

import java.util.List;
import java.util.Set;

public class Helper {

    public static List<Berater> generateData() {
        return List.of(
                new Berater("Alice", 36, "Adidas", Set.of(
                        new Kunde("Audi", Branche.AUTOMOBIL),
                        new Kunde("BMW", Branche.AUTOMOBIL))),
                new Berater("Bob", 46, "Buffalo", Set.of(
                        new Kunde("Bayer", Branche.CHEMIE),
                        new Kunde("Henkel", Branche.CHEMIE),
                        new Kunde("Aldi", Branche.EINZELHANDEL))),
                new Berater("Charlie", 42, "Clarks", Set.of(
                        new Kunde("Bayer", Branche.EDV),
                        new Kunde("Aldi", Branche.EINZELHANDEL),
                        new Kunde("Lidl", Branche.EINZELHANDEL),
                        new Kunde("Netto", Branche.EINZELHANDEL))),
                new Berater("Dave", 42, "Dr. Martens", Set.of(
                        new Kunde("Lidl", Branche.EDV))),
                new Berater("Eve", 38, "Esprit", Set.of(
                        new Kunde("Lidl", Branche.EDV),
                        new Kunde("BMW", Branche.AUTOMOBIL))),
                new Berater("Frank", 48, "Fila", Set.of(
                        new Kunde("Lidl", Branche.EDV)
                )),
                new Berater("George", 46, "Geox", Set.of(
                        new Kunde("Aldi", Branche.EDV)
                )));
    }
}
