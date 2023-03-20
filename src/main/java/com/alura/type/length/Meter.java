package com.alura.type.length;

import com.alura.type.length.utils.LengthBase;
import com.alura.type.length.utils.LengthBaseInterface;
import com.alura.type.length.utils.LengthSlugs;

public class Meter extends LengthBase implements LengthBaseInterface {

    public Meter() {
        super(1, LengthSlugs.M.name());
        addConversion(LengthSlugs.MM.name(), 1000.0);
        addConversion(LengthSlugs.CM.name(), 100.0);
        addConversion(LengthSlugs.M.name(), 1.0);
        addConversion(LengthSlugs.KM.name(), 0.001);
        addConversion(LengthSlugs.IN.name(), 39.3701);
        addConversion(LengthSlugs.FT.name(), 3.28084);
        addConversion(LengthSlugs.YD.name(), 1.09361);
        addConversion(LengthSlugs.MI.name(), 0.000621371);
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
