package com.alura.type.length;

import com.alura.type.length.utils.LengthBase;
import com.alura.type.length.utils.LengthBaseInterface;
import com.alura.type.length.utils.LengthSlugs;

public class Yard extends LengthBase implements LengthBaseInterface {
    public Yard() {
        super(1.0, LengthSlugs.YD.name());
        addConversion(LengthSlugs.MM.name(), 914.4);
        addConversion(LengthSlugs.CM.name(), 91.44);
        addConversion(LengthSlugs.M.name(), 0.9144);
        addConversion(LengthSlugs.KM.name(), 0.0009144);
        addConversion(LengthSlugs.IN.name(), 36.0);
        addConversion(LengthSlugs.FT.name(), 3.0);
        addConversion(LengthSlugs.YD.name(), 1.0);
        addConversion(LengthSlugs.MI.name(), 0.000568182);

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
        return "Yard";
    }
}
