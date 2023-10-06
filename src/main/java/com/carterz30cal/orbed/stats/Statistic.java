package com.carterz30cal.orbed.stats;

import org.bukkit.ChatColor;

public enum Statistic {
    DAMAGE("Damage", "\u2BCE", ChatColor.RED, StatType.OFFENSIVE),
    STRENGTH("Strength", "✖", ChatColor.DARK_RED, StatType.OFFENSIVE),
    POWER("Power", "★", ChatColor.DARK_RED, StatType.OFFENSIVE),;
    private String statName;
    private String statIcon;
    private ChatColor statColour;
    private StatType statType;

    private Statistic() {

    }
    private Statistic(String statName, String statIcon, ChatColor statColour, StatType statType) {
        this.statName = statName;
        this.statIcon = statIcon;
        this.statColour = statColour;
        this.statType = statType;
    }

    @Override
    public String toString() {
        return statColour + statIcon + " " + statName;
    }

    public StatType getType() {
        return statType;
    }
}
