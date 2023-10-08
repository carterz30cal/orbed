package com.carterz30cal.orbed.entities.enemies;

import com.carterz30cal.orbed.entities.DamageInfo;
import com.carterz30cal.orbed.entities.GameEntity;
import com.carterz30cal.orbed.entities.Health;
import org.jetbrains.annotations.NotNull;

public class HealthEnemy extends Health {
    private GameEntity lastDamager;

    public HealthEnemy(GameEntity owner) {
        super(owner);
    }

    @Override
    public void damage(@NotNull DamageInfo event) {
        long damage = getResistedDamage(event.damage, event.damageType);

        health -= damage;
        lastDamager = event.attacker;

        updateDisplay();
        if (health <= 0) owner.onKill();
    }

    public void updateDisplay() {

    }

    public GameEntity getLastAttacker() {
        return lastDamager;
    }
}
