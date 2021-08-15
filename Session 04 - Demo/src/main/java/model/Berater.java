package model;

import java.util.Objects;
import java.util.Set;

public class Berater {

    private String name;
    private int schuhgroesse;
    private Set<Kunde> kunden;

    public Berater(String name, int schuhgroesse, Set<Kunde> kunden) {
        this.name = name;
        this.schuhgroesse = schuhgroesse;
        this.kunden = kunden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSchuhgroesse() {
        return schuhgroesse;
    }

    public void setSchuhgroesse(int schuhgroesse) {
        this.schuhgroesse = schuhgroesse;
    }

    public Set<Kunde> getKunden() {
        return kunden;
    }

    public void setKunden(Set<Kunde> kunden) {
        this.kunden = kunden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Berater berater = (Berater) o;
        return schuhgroesse == berater.schuhgroesse && Objects.equals(name, berater.name) && Objects.equals(kunden, berater.kunden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, schuhgroesse, kunden);
    }

    @Override
    public String toString() {
        return "Berater{" +
                "name='" + name + '\'' +
                ", schuhgroesse=" + schuhgroesse +
                ", kunden=" + kunden +
                '}';
    }
}
