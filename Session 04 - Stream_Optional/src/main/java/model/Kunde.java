package model;

import java.util.Objects;

public class Kunde {
    private String firmenname;
    private Branche branche;

    public Kunde(String firmenname, Branche branche) {
        this.firmenname = firmenname;
        this.branche = branche;
    }

    public String getFirmenname() {
        return firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }

    public Branche getBranche() {
        return branche;
    }

    public void setBranche(Branche branche) {
        this.branche = branche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kunde kunde = (Kunde) o;
        return Objects.equals(firmenname, kunde.firmenname) && branche == kunde.branche;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firmenname, branche);
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "firmenname='" + firmenname + '\'' +
                ", branche=" + branche +
                '}';
    }
}
