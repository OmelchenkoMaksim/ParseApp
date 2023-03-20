package com.example.parsingapp.yandex;

public enum ElementJava {
    H("Hydrogen", 3),
    HE("Helium", 2),
    NE("Neon", 10);

    public final String label;
    public final int number;

    ElementJava(String label, int number) {
        this.label = label;
        this.number = number;
    }
}

