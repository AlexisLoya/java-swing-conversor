package com.alura.type.length.utils;


import java.util.HashMap;
import java.util.Map;

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



}
