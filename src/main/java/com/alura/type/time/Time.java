package com.alura.type.time;

import com.alura.type.time.utils.TimeUnits;

public class Time {
    public double convertTime(double value, int fromUnit, int toUnit) {
        TimeUnits fromTimeUnit = TimeUnits.values()[fromUnit];
        TimeUnits toTimeUnit = TimeUnits.values()[toUnit];

        double[] timeFactors = {
                1, // Milliseconds
                1000, // Seconds
                60 * 1000, // Minutes
                60 * 60 * 1000, // Hours
                24 * 60 * 60 * 1000, // Days
                7 * 24 * 60 * 60 * 1000, // Weeks
                365.25 * 24 * 60 * 60 * 1000 // Years (approximate)
        };

        double fromFactor = timeFactors[fromUnit];
        double toFactor = timeFactors[toUnit];

        return value * (fromFactor / toFactor);
    }
}
