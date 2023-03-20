package com.alura.type.length.utils;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthBase {

    private double value;
    private String slug;
    private Map<String, Double> conversions;

    public LengthBase(double value, String slug) {
        this.value = value;
        this.slug = slug;
        this.conversions =  new HashMap<String, Double>();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Map<String, Double> getConversions() {
        return conversions;
    }
    public void addConversion(String slug, double value) {
        this.conversions.put(slug, value);
    }
    public double getConversion(String unit) {
        return this.conversions.get(unit);
    }
    public void setConversions(Map<String, Double> conversions) {
        this.conversions = conversions;
    }

    //    private int optionIn;
//    private int optionOut;
//    private String typeSlug = "m";
//
//    // Constructor
//    public LengthBase() {
//        this.valueIn = 0.0;
//        this.valueOut = 0.0;
//    }
//
//    // Override methods
//    @Override
//    public double toMillimeters(double valueIn) {
//        // valueIn is in meters
//        // check if the output is in millimeters
//        if (optionIn)
//        return valueIn * 1000;
//    }
//
//    @Override
//    public double toCentimeters(double valueIn) {
//        // valueIn is in meters
//        return valueIn * 100;
//    }
//
//    @Override
//    public double toMeters(double valueIn) {
//        // valueIn is in meters
//        return valueIn;
//    }
//
//    @Override
//    public double toKilometers(double valueIn) {
//        // valueIn is in meters
//        return valueIn / 1000;
//
//    }
//
//    @Override
//    public double toInches(double valueIn) {
//        // valueIn is in meters
//        return valueIn * 39.3701;
//    }
//
//    @Override
//    public double toFeet(double valueIn) {
//        // valueIn is in meters
//        return valueIn * 3.28084;
//    }
//
//    @Override
//    public double toYards(double valueIn) {
//        // valueIn is in meters
//        return valueIn * 1.09361;
//    }
//
//    @Override
//    public double toMiles(double valueIn) {
//        // valueIn is in meters
//        return valueIn * 0.000621371;
//    }
//
//    @Override
//    public double toNauticalMiles(double valueIn) {
//        // valueIn is in meters
//        return valueIn * 0.000539957;
//    }
//
//    @Override
//    public double toMils(double valueIn) {
//        // valueIn is in meters
//        return valueIn * 39370.1;
//    }
//
//    @Override
//    public String getResult() {
//
//        return null;
//    }
//
//
//    // Getters and Setters
//    public double getValueIn() {
//        return valueIn;
//    }
//    public void setValueIn(double valueIn) {
//        this.valueIn = valueIn;
//    }
//
//    public double getValueOut() {
//        return valueOut;
//    }
//
//    public void setValueOut(double valueOut) {
//        this.valueOut = valueOut;
//    }
//
//    public String getTypeSlug() {
//        return typeSlug;
//    }
//
//    public void setTypeSlug(String typeSlug) {
//        this.typeSlug = typeSlug;
//    }


}
