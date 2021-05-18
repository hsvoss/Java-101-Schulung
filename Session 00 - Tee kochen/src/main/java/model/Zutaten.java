package model;

public enum Zutaten {
    WASSER("Wasser"),
    KAKAO("Kakao"),
    TEEBLAETTER("Teeblätter"),
    MAYONNAISE("Mayonnaise"),
    PFEFFER("Pfeffer"),
    KAFFEEPULVER("Kaffeepulver"),
    APFELSAFT("Apfelsaft"),
    MILCH("Milch"),
    OLIVENOEL("Olivenöl"),
    SALZ("Salz"),
    ZUCKER("Zucker");

    private String name;

    Zutaten(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
