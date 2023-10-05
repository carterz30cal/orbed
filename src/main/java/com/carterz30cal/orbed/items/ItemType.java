package com.carterz30cal.orbed.items;

public enum ItemType {
    WEAPON("Weapon");
    private final String prettyName;
    private ItemType(String prettyName) {
        this.prettyName = prettyName;
    }

    public String getName() {
        return prettyName;
    }
}
