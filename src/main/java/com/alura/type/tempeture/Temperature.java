package com.alura.type.tempeture;

import com.alura.type.tempeture.utils.TemperatureTypes;

public class Temperature {

    public double toFahrenheit(double valueIn) {
        return (valueIn * 9 / 5) + 32;
    }

    public double fromFahrenheit(double valueIn) {
        return (valueIn - 32) * 5 / 9;
    }

    public double toKelvin(double valueIn) {
        return valueIn + 273.15;
    }

    public double fromKelvin(double valueIn) {
        return valueIn - 273.15;
    }

    private double getTemperatureInCelsius(double value, TemperatureTypes fromUnit) {
        double result = 0;
        switch (fromUnit) {
            case CELSIUS:
                result = value;
                break;
            case FAHRENHEIT:
                result = fromFahrenheit(value);
                break;
            case KELVIN:
                result = fromKelvin(value);
                break;
            default:
                throw new IllegalArgumentException("Invalid temperature unit index provided");
        }
        return result;
    }

    private double setTemperatureOutCelsius(double value, TemperatureTypes toUnit) {
        double result = 0;
        switch (toUnit) {
            case CELSIUS:
                result = value;
                break;
            case FAHRENHEIT:
                result = toFahrenheit(value);
                break;
            case KELVIN:
                result = toKelvin(value);
                break;
            default:
                throw new IllegalArgumentException("Invalid temperature unit index provided");
        }
        return result;
    }

    public double convert(double value, TemperatureTypes fromUnit, TemperatureTypes toUnit) {
        double valueInCelsius = getTemperatureInCelsius(value, fromUnit);
        return setTemperatureOutCelsius(valueInCelsius, toUnit);
    }

}
