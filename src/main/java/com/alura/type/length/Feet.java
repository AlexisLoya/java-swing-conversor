package com.alura.type.length;

import com.alura.type.length.utils.LengthBase;
import com.alura.type.length.utils.LengthBaseInterface;
import com.alura.type.length.utils.LengthSlugs;

public class Feet extends LengthBase implements LengthBaseInterface {

    public Feet() {
        super(1.0, LengthSlugs.FT.name());
        addConversion(LengthSlugs.MM.name(), 304.8);
        addConversion(LengthSlugs.CM.name(), 30.48);
        addConversion(LengthSlugs.M.name(), 0.3048);
        addConversion(LengthSlugs.KM.name(), 0.0003048);
        addConversion(LengthSlugs.IN.name(), 12.0);
        addConversion(LengthSlugs.FT.name(), 1.0);
        addConversion(LengthSlugs.YD.name(), 0.333333);
        addConversion(LengthSlugs.MI.name(), 0.000189394);

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
