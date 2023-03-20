package com.alura.type.length.utils;

public interface LengthBaseInterface {
    public double toMillimeters(double valueIn);
    public double toCentimeters(double valueIn);
    public double toMeters(double valueIn);
    public double toKilometers(double valueIn);
    public double toInches(double valueIn);
    public double toFeet(double valueIn);
    public double toYards(double valueIn);
    public double toMiles(double valueIn);
    public String getResult();
}
