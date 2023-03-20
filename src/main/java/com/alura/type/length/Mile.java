package com.alura.type.length;

import com.alura.type.length.utils.LengthBase;
import com.alura.type.length.utils.LengthBaseInterface;
import com.alura.type.length.utils.LengthSlugs;

public class Mile extends LengthBase implements LengthBaseInterface {

    public Mile() {
        super(1, LengthSlugs.MI.name());
        addConversion(LengthSlugs.MI.name(), 1.0);
        addConversion(LengthSlugs.MM.name(), 1609344.0);
        addConversion(LengthSlugs.CM.name(), 160934.4);
        addConversion(LengthSlugs.M.name(), 1609.344);
        addConversion(LengthSlugs.KM.name(), 1.609344);
        addConversion(LengthSlugs.IN.name(), 63360.0);
        addConversion(LengthSlugs.FT.name(), 5280.0);
        addConversion(LengthSlugs.YD.name(), 1760.0);

    }

    @Override
    public double toMillimeters(double valueIn) {
        return 0;
    }

    @Override
    public double toCentimeters(double valueIn) {
        return 0;
    }

    @Override
    public double toMeters(double valueIn) {
        return 0;
    }

    @Override
    public double toKilometers(double valueIn) {
        return 0;
    }

    @Override
    public double toInches(double valueIn) {
        return 0;
    }

    @Override
    public double toFeet(double valueIn) {
        return 0;
    }

    @Override
    public double toYards(double valueIn) {
        return 0;
    }

    @Override
    public double toMiles(double valueIn) {
        return 0;
    }

    @Override
    public String getResult() {
        return null;
    }
}
