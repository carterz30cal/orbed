package com.carterz30cal.orbed.stats;

import java.util.HashMap;
import java.util.Map;

public class StatContainer implements Cloneable {
    private Map<Statistic, Long> stats = new HashMap<>();

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
}
