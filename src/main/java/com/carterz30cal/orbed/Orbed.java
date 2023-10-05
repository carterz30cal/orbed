package com.carterz30cal.orbed;

import com.carterz30cal.orbed.items.ItemFactory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Orbed extends JavaPlugin {
    public static Orbed instance;

    public Orbed() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemFactory.initItems();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
