import model.Berater;
import model.Branche;
import model.Kunde;

import java.util.List;
import java.util.Set;

public class Helper {

    public static List<Berater> generateData() {
        return List.of(
                new Berater("Alice", 36, Set.of(
                        new Kunde("Audi", Branche.AUTOMOBIL),
                        new Kunde("BMW", Branche.AUTOMOBIL))),
                new Berater("Bob", 46, Set.of(
                        new Kunde("Bayer", Branche.CHEMIE),
                        new Kunde("Henkel", Branche.CHEMIE),
                        new Kunde("Aldi", Branche.EINZELHANDEL))),
                new Berater("Charlie", 42, Set.of(
                        new Kunde("Bayer", Branche.EDV),
                        new Kunde("Aldi", Branche.EINZELHANDEL),
                        new Kunde("Lidl", Branche.EINZELHANDEL),
                        new Kunde("Netto", Branche.EINZELHANDEL))),
                new Berater("Dave", 42, Set.of(
                        new Kunde("Lidl", Branche.EDV))),
                new Berater("Eve", 38, Set.of(
                        new Kunde("Lidl", Branche.EDV),
                        new Kunde("BMW", Branche.AUTOMOBIL))),
                new Berater("Frank", 48, Set.of(
                        new Kunde("Lidl", Branche.EDV)
                )),
                new Berater("George", 46, Set.of(
                        new Kunde("Aldi", Branche.EDV)
                )));
    }
}
