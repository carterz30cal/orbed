package com.carterz30cal.orbed.items;

import org.bukkit.ChatColor;

public enum ItemRarity {
    S("S", ChatColor.RED),
    A("A", ChatColor.GOLD),
    B("B", ChatColor.YELLOW),
    C("C", ChatColor.GREEN),
    D("D", ChatColor.BLUE),
    E("E", ChatColor.DARK_AQUA);
    private final String rarityName;
    private final ChatColor rarityColour;

    private ItemRarity(String rarityName, ChatColor rarityColour) {
        this.rarityName = rarityName;
        this.rarityColour = rarityColour;
    }

    public String getName() {
        return rarityColour + rarityName;
    }
    public String getRawName() {
        return rarityName;
    }
    public ChatColor getColour() {
        return rarityColour;
    }
}
