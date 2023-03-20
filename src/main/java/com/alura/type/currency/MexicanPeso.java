package com.alura.type.currency;

public class MexicanPeso extends BaseCoin {

    private double value;
    public MexicanPeso() {
        super("Peso Mexicano", "$", "MXN");
        this.value = 0.0;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

