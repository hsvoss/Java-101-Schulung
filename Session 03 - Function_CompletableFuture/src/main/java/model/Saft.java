package model;

import java.util.Objects;
import java.util.Set;

public class Saft {
    private Set<Sorte> sorte;
    private int milliliter;

    public Saft(Sorte sorte, int milliliter) {
        this.sorte = Set.of(sorte);
        this.milliliter = milliliter;
    }

    public Saft(Set<Sorte> sorte, int milliliter) {
        this.sorte = sorte;
        this.milliliter = milliliter;
    }

    public Set<Sorte> getSorte() {
        return sorte;
    }

    public void setSorte(Set<Sorte> sorte) {
        this.sorte = sorte;
    }

    public int getMilliliter() {
        return milliliter;
    }

    public void setMilliliter(int milliliter) {
        this.milliliter = milliliter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Saft saft = (Saft) o;
        return milliliter == saft.milliliter && Objects.equals(sorte, saft.sorte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sorte, milliliter);
    }

    @Override
    public String toString() {
        return "Saft{" +
                "sorte=" + sorte +
                ", milliliter=" + milliliter +
                '}';
    }
}
