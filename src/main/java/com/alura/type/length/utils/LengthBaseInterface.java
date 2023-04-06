package com.alura.type.length.utils;

public interface LengthBaseInterface {
    double toMillimeters(double valueIn);
    double toCentimeters(double valueIn);
    double toMeters(double valueIn);
    double toKilometers(double valueIn);
    double toInches(double valueIn);
    double toFeet(double valueIn);
    double toYards(double valueIn);
    double toMiles(double valueIn);

    double fromMillimeters(double valueIn);
    double fromCentimeters(double valueIn);
    double fromMeters(double valueIn);
    double fromKilometers(double valueIn);
    double fromInches(double valueIn);
    double fromFeet(double valueIn);
    double fromYards(double valueIn);
    double fromMiles(double valueIn);


    public String getResult();
}
