package com.carterz30cal.orbed.stats;

import com.carterz30cal.orbed.maths.StatValue;

import java.util.HashMap;
import java.util.Map;

public class StatContainer implements Cloneable {
    private Map<Statistic, StatValue> stats = new HashMap<>();

    @Override
    public StatContainer clone() {
        try {
            StatContainer clone = (StatContainer) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void add(StatContainer stats) {
        for (Statistic stat : stats.stats.keySet()) {
            add(stat, stats.get(stat));
        }
    }
    public void add(Statistic stat, long value) {
        stats.putIfAbsent(stat, new StatValue());
        stats.get(stat).value += value;
    }
    public void set(Statistic stat, long value) {
        stats.putIfAbsent(stat, new StatValue());
        stats.get(stat).value = value;
    }
    public void multiply(Statistic stat, double value) {
        stats.putIfAbsent(stat, new StatValue());
        stats.get(stat).multiplier *= value;
    }
    public void addMultiplier(Statistic stat, double value) {
        stats.putIfAbsent(stat, new StatValue());
        stats.get(stat).additiveMultiplier += value;
    }

    public long get(Statistic stat) {
        return get(stat, false);
    }

    /**
     *
     * @param stat Which stat are we looking at?
     * @param raw Do we want the raw value or the manipulated value?
     * @return The value of the stat.
     */
    public long get(Statistic stat, boolean raw) {
        StatValue val = stats.getOrDefault(stat, new StatValue());
        if (raw) return val.value;
        else return val.getValue();
    }
}
