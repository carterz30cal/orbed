package com.carterz30cal.orbed.entities.enemies.generation;

import org.bukkit.Location;

public class EnemyDisplayRoot implements Cloneable {
    public EnemyDisplayNode rootNode;

    private final EnemyDisplayTemplateNode template;
    private Location lastLocation;

    public EnemyDisplayRoot(EnemyDisplayTemplateNode templateRootNode, Location location) {
        rootNode = templateRootNode.getNewNode(location, null);
        template = templateRootNode;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public EnemyDisplayRoot clone() {

        return new EnemyDisplayRoot(template, lastLocation);
    }
}
