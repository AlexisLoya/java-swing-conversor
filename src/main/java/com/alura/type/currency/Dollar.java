package com.alura.type.currency;

public class Dollar extends BaseCoin {

    // set value of dollar and the correct type of data
    private double value;
    public Dollar() {
        super("Dollar", "$", "USD");
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
