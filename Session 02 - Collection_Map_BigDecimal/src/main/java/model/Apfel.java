package model;

public class Apfel implements Obst {
    String sorte;

    public Apfel(String sorte) {
        this.sorte = sorte;
    }

    @Override
    public boolean equals(Object o) {
        Apfel apfel = (Apfel) o;
        return sorte.length() == apfel.sorte.length();
    }

    @Override
    public int hashCode() {
        return sorte.length();
    }
}
