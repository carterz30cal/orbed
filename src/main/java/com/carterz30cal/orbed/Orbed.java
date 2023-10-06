package com.carterz30cal.orbed;

import com.carterz30cal.orbed.commands.CommandItem;
import com.carterz30cal.orbed.items.ItemFactory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Orbed extends JavaPlugin {
    public static Orbed instance;

    public Orbed() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemFactory.initItems();

        Objects.requireNonNull(getCommand("item")).setExecutor(new CommandItem());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
