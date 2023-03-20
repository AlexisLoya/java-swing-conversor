package com.alura.type.length;

import com.alura.type.length.utils.LengthBase;
import com.alura.type.length.utils.LengthBaseInterface;
import com.alura.type.length.utils.LengthSlugs;

public class Centimeter extends LengthBase implements LengthBaseInterface {

    public Centimeter(double valueIn) {
        super(1, LengthSlugs.CM.name());
        addConversion(LengthSlugs.MM.name(), 10.0);
        addConversion(LengthSlugs.CM.name(), 1.0);
        addConversion(LengthSlugs.M.name(), 0.01);
        addConversion(LengthSlugs.KM.name(), 0.00001);
        addConversion(LengthSlugs.IN.name(), 0.393701);
        addConversion(LengthSlugs.FT.name(), 0.0328084);
        addConversion(LengthSlugs.YD.name(), 0.0109361);
        addConversion(LengthSlugs.MI.name(), 0.00000621371);

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
