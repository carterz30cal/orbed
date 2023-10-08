package com.carterz30cal.orbed.entities;

public class DamageInfo {
    public long damage;
    public DamageType damageType;

    public final GameEntity defender;
    public final GameEntity attacker;

    public DamageInfo(GameEntity defender, GameEntity attacker) {
        this.defender = defender;
        this.attacker = attacker;

        this.damageType = DamageType.PHYSICAL;
    }
}
