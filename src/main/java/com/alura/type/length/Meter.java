package com.alura.type.length;

import com.alura.type.length.utils.LengthBase;
import com.alura.type.length.utils.LengthBaseInterface;
import com.alura.type.length.utils.LengthSlugs;
import com.alura.type.length.utils.LengthUnits;


public class Meter extends LengthBase implements LengthBaseInterface {

    public Meter() {
        super(1, LengthSlugs.M.name());
        addConversion(LengthSlugs.MM.name(), 1000.0);
        addConversion(LengthSlugs.CM.name(), 100.0);
        addConversion(LengthSlugs.M.name(), 1.0);
        addConversion(LengthSlugs.KM.name(), 1000);
        addConversion(LengthSlugs.IN.name(), 39.3701);
        addConversion(LengthSlugs.FT.name(), 3.28084);
        addConversion(LengthSlugs.YD.name(), 1.09361);
        addConversion(LengthSlugs.MI.name(), 1609.34);
    }
    // Millimeters
    @Override
    public double fromMillimeters(double valueIn) {
        return valueIn / getConversion(LengthSlugs.MM.name());
    }
    @Override

    public double toMillimeters(double valueIn) {
        return valueIn * getConversion(LengthSlugs.MM.name());
    }
    // Centimeters
    @Override
    public double fromCentimeters(double valueIn) {
        return valueIn / getConversion(LengthSlugs.CM.name());
    }
    @Override
    public double toCentimeters(double valueIn) {
        return valueIn * getConversion(LengthSlugs.CM.name());
    }

    // Meters
    @Override
    public double toMeters(double valueIn) {
        return valueIn * getConversion(LengthSlugs.M.name());
    }

    @Override
    public double fromMeters(double valueIn) {
        return valueIn / getConversion(LengthSlugs.M.name());
    }

    // Kilometers
    @Override
    public double fromKilometers(double valueIn) {
        return valueIn * getConversion(LengthSlugs.KM.name());
    }
    @Override
    public double toKilometers(double valueIn) {
        return valueIn / getConversion(LengthSlugs.KM.name());
    }


    // Inches
    @Override
    public double fromInches(double valueIn) {
        return valueIn * getConversion(LengthSlugs.IN.name());
    }
    @Override
    public double toInches(double valueIn) {
        return valueIn * getConversion(LengthSlugs.IN.name());
    }
    // Feet
    @Override
    public double fromFeet(double valueIn) {
        return valueIn * getConversion(LengthSlugs.FT.name());
    }
    @Override
    public double toFeet(double valueIn) {
        return valueIn * getConversion(LengthSlugs.FT.name());
    }
    // Yards
    @Override
    public double fromYards(double valueIn) {
        return valueIn * getConversion(LengthSlugs.YD.name());
    }
    @Override
    public double toYards(double valueIn) {
        return valueIn * getConversion(LengthSlugs.YD.name());
    }

    // Miles
    @Override
    public double fromMiles(double valueIn) {
        return valueIn * getConversion(LengthSlugs.MI.name());
    }
    @Override
    public double toMiles(double valueIn) {
        return valueIn / getConversion(LengthSlugs.MI.name());
    }

    // get value in meters
    public double getValueInMeters(double value, LengthUnits fromUnit) {
        double valueInMeters = 0.0;

        switch (fromUnit) {
            case MILLIMETERS:
                valueInMeters = fromMillimeters(value);
                break;
            case CENTIMETERS:
                valueInMeters = fromCentimeters(value);
                break;
            case METERS:
                valueInMeters = value;
                break;
            case KILOMETERS:
                valueInMeters = fromKilometers(value);
                break;
            case INCHES:
                valueInMeters = fromInches(value);
                break;
            case FEETS:
                valueInMeters = fromFeet(value);
                break;
            case YARDS:
                valueInMeters = fromYards(value);
                break;
            case MILES:
                valueInMeters = fromMiles(value);
                break;
            default:
                throw new IllegalArgumentException("Invalid LengthUnits provided");
        }
        return valueInMeters;
    }
    public double setValueFromMeters(double valueInMeters, LengthUnits toUnit) {
        double convertedValue = 0.0;

        switch (toUnit) {
            case MILLIMETERS:
                convertedValue = toMillimeters(valueInMeters);
                break;
            case CENTIMETERS:
                convertedValue = toCentimeters(valueInMeters);
                break;
            case METERS:
                convertedValue = toMeters(valueInMeters);
                break;
            case KILOMETERS:
                convertedValue = toKilometers(valueInMeters);
                break;
            case INCHES:
                convertedValue = toInches(valueInMeters);
                break;
            case FEETS:
                convertedValue = toFeet(valueInMeters);
                break;
            case YARDS:
                convertedValue = toYards(valueInMeters);
                break;
            case MILES:
                convertedValue = toMiles(valueInMeters);
                break;
            default:
                throw new IllegalArgumentException("Invalid LengthUnits provided");
        }

        return convertedValue;
    }
    public String getResult() {
        return null;
    }
}
