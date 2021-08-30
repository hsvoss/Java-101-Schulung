package model;

import java.util.Objects;

public class Apfel implements Obst {
    String sorte;

    public Apfel(String sorte) {
        this.sorte = sorte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apfel apfel = (Apfel) o;
        return Objects.equals(sorte, apfel.sorte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sorte);
    }
}
