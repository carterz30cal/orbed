package com.carterz30cal.orbed.entities;

import java.util.UUID;

public class GameEntity {
    public final UUID identifier;

    public Health healthSystem;

    public GameEntity() {
        identifier = UUID.randomUUID();
    }


}
