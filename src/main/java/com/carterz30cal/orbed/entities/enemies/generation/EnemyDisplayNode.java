package com.carterz30cal.orbed.entities.enemies.generation;

import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class EnemyDisplayNode {
    public final Entity entity;
    public EnemyDisplayNode parent;
    public List<EnemyDisplayNode> children = new ArrayList<>();

    public EnemyDisplayNode(Entity entity, EnemyDisplayNode parent) {
        this.entity = entity;
        this.parent = parent;
    }
}
