package com.carterz30cal.orbed.entities;

import com.carterz30cal.orbed.stats.Statistic;
import org.bukkit.ChatColor;

public enum DamageType {
    PHYSICAL("Physical", ChatColor.WHITE, Statistic.DEFENCE_PHYSICAL);
    public final String typeName;
    public final ChatColor typeColour;
    public final Statistic protectionStat;

    private DamageType(String typeName, ChatColor typeColour, Statistic protectionStat) {
        this.typeName = typeName;
        this.typeColour = typeColour;
        this.protectionStat = protectionStat;
    }
}
