package com.carterz30cal.orbed.items;

import java.util.UUID;

public class Item {
    public final UUID identifier;

    public Item() {
        identifier = UUID.randomUUID();
    }
    public Item(UUID id) {
        identifier = id;
    }
}
