package com.carterz30cal.orbed.maths;

public final class Range {
    public final long lowerBound;
    public final long upperBound;

    public Range(long l, long u) {
        lowerBound = l;
        upperBound = u;
    }

    public Range(String range) {
        String[] split = range.split("-");
        lowerBound = Long.getLong(split[0]);

        if (split.length == 1) {
            upperBound = lowerBound;
        }
        else {
            upperBound = Long.getLong(split[1]);
        }
    }

    public long getValueWithin() {
        if (lowerBound == upperBound) return lowerBound;

        double f = Math.random()/Math.nextDown(1);
        return Math.round(f * upperBound + lowerBound * (1 - f));
    }

    public static long getWithin(long lowerBound, long upperBound) {
        if (lowerBound == upperBound) return lowerBound;

        double f = Math.random()/Math.nextDown(1);
        return Math.round(f * upperBound + lowerBound * (1 - f));
    }

    public static int getWithin(int lowerBound, int upperBound) {
        if (lowerBound == upperBound) return lowerBound;

        float f = (float)Math.random()/Math.nextDown(1);
        return Math.round(f * upperBound + lowerBound * (1 - f));
    }
}
