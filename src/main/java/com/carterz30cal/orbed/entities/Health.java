package com.carterz30cal.orbed.entities;

public abstract class Health {
    public long health = 0;
    public abstract void damage(DamageInfo event);
}
