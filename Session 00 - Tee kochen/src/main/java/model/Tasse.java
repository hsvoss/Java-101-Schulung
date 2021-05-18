package model;

import java.util.List;

public class Tasse {

    private final List<Zutaten> zutaten;

    public Tasse(List<Zutaten> zutaten) {
        this.zutaten = zutaten;
    }

    public List<Zutaten> getZutaten() {
        return zutaten;
    }
}
