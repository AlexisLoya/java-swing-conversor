package com.alura.type.length;

import com.alura.type.length.utils.LengthBase;
import com.alura.type.length.utils.LengthBaseInterface;
import com.alura.type.length.utils.LengthSlugs;

public class Millimeter extends LengthBase implements LengthBaseInterface {

    public Millimeter() {
        super(1, LengthSlugs.MM.name());
        addConversion(LengthSlugs.MM.name(), 1.0);
        addConversion(LengthSlugs.CM.name(), 0.1);
        addConversion(LengthSlugs.M.name(), 0.001);
        addConversion(LengthSlugs.KM.name(), 0.000001);
        addConversion(LengthSlugs.IN.name(), 0.0393701);
        addConversion(LengthSlugs.FT.name(), 0.00328084);
        addConversion(LengthSlugs.YD.name(), 0.00109361);
        addConversion(LengthSlugs.MI.name(), 0.000000621371);

    }
    @Override
    public double toMillimeters(double valueIn) {
        return valueIn * getConversion(LengthSlugs.MM.name());
    }

    @Override
    public double toCentimeters(double valueIn) {
        return valueIn * getConversion(LengthSlugs.CM.name());
    }

    @Override
    public double toMeters(double valueIn) {
        return valueIn * getConversion(LengthSlugs.M.name());
    }

    @Override
    public double toKilometers(double valueIn) {
        return valueIn * getConversion(LengthSlugs.KM.name());
    }

    @Override
    public double toInches(double valueIn) {
        return valueIn * getConversion(LengthSlugs.IN.name());
    }

    @Override
    public double toFeet(double valueIn) {
        return valueIn * getConversion(LengthSlugs.FT.name());
    }

    @Override
    public double toYards(double valueIn) {
        return valueIn * getConversion(LengthSlugs.YD.name());
    }

    @Override
    public double toMiles(double valueIn) {
        return valueIn * getConversion(LengthSlugs.MI.name());
    }

    @Override
    public String getResult() {
        return null;
    }
}
