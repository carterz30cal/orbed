package com.carterz30cal.orbed.entities;

import java.util.HashMap;
import java.util.Map;

public abstract class Health {
    public long health = 0;
    public GameEntity owner;
    public Map<DamageType, Integer> resistances = new HashMap<>();
    public abstract void damage(DamageInfo event);

    public Health(GameEntity owner) {
        this.owner = owner;
    }

    protected long getResistedDamage(long damage, DamageType damageType) {
        int resistance = resistances.getOrDefault(damageType, 0);
        if (resistance < 0) {
            return Math.round(damage * -(resistance / 100D));
        }
        else {
            return Math.round(damage * (100 / (resistance + 100D)));
        }
    }
}
