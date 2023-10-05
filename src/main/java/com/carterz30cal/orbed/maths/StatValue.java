package com.carterz30cal.orbed.maths;

public class StatValue {
    public long value;
    public double multiplier;
    public double additiveMultiplier;


    public StatValue() {
        value = 0L;
        multiplier = 1;
        additiveMultiplier = 1;
    }

    public long getValue() {
        return Math.round(value * multiplier * additiveMultiplier);
    }
}
