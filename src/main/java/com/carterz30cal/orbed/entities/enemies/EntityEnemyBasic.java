package com.carterz30cal.orbed.entities.enemies;

import com.carterz30cal.orbed.entities.GameEntity;
import org.bukkit.configuration.ConfigurationSection;

/**
 * Essentially the base class for most enemies.
 * Implements all the abstract methods from GameEntity, and therefore should
 * be derived from if those implementations are satisfactory for the use case.
 *
 * @version 1.0.0
 * @since 1.0.0
 * @author carterz30cal
 */
public class EntityEnemyBasic extends GameEntity {

    public final EnemyTemplate template;

    public EntityEnemyBasic(EnemyTemplate template) {
        super();

        this.template = template;
        this.healthSystem = new HealthEnemy(this);


    }


    @Override
    public void loadData(ConfigurationSection section) {

    }

    @Override
    public void saveData(ConfigurationSection section) {

    }

    @Override
    protected void register() {

    }

    @Override
    protected void deregister() {

    }

    @Override
    protected void tick() {

    }
}
