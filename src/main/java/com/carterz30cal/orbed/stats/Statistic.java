package com.carterz30cal.orbed.stats;

import org.bukkit.ChatColor;

public enum Statistic {
    ;
    private String statName;
    private String statIcon;
    private ChatColor statColour;
    private StatType statType;

    @Override
    public String toString() {
        return statColour + statIcon + " " + statName;
    }
}
