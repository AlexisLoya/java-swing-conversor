package com.alura.type.length;

import com.alura.type.length.utils.LengthBase;
import com.alura.type.length.utils.LengthBaseInterface;
import com.alura.type.length.utils.LengthSlugs;

public class Inche extends LengthBase implements LengthBaseInterface {

    public Inche() {
        super(1.0, LengthSlugs.IN.name());
        addConversion(LengthSlugs.MM.name(), 25.4);
        addConversion(LengthSlugs.CM.name(), 2.54);
        addConversion(LengthSlugs.M.name(), 0.0254);
        addConversion(LengthSlugs.KM.name(), 0.0000254);
        addConversion(LengthSlugs.IN.name(), 1.0);
        addConversion(LengthSlugs.FT.name(), 0.0833333);
        addConversion(LengthSlugs.YD.name(), 0.0277778);
        addConversion(LengthSlugs.MI.name(), 0.0000157828);
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
        return "Inches";
    }
}
