package com.carterz30cal.orbed.entities;

public class DamageInfo {
    public long damage;

    public final GameEntity defender;
    public final GameEntity attacker;

    public DamageInfo(GameEntity defender, GameEntity attacker) {
        this.defender = defender;
        this.attacker = attacker;
    }
}
