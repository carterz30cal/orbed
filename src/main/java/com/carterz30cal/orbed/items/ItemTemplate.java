package com.carterz30cal.orbed.items;

import com.carterz30cal.orbed.maths.Range;
import com.carterz30cal.orbed.stats.Statistic;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * ItemTemplate is how items are defined in our .yml files.
 * These are accessible using both the 'resources' and also
 * custom files made by server owners.
 * @author carterz30cal
 * @version 1.0.0
 */
public class ItemTemplate {
    private static Map<String, ItemTemplate> templates = new HashMap<>();

    public String itemName;
    public final String templateIdentifier;
    public ItemRarity baseRarity;

    public Map<Statistic, Long> forcedStats = new HashMap<>();
    public Map<Statistic, Range> chosenStats = new HashMap<>();

    public ItemTemplate(FileConfiguration data) {
        templateIdentifier = data.getName();

        itemName = data.getString("name");
        baseRarity = ItemRarity.valueOf(data.getString("rarity"));

        if (data.contains("stats")) {
            if (data.contains("forced-stats")) {
                ConfigurationSection section = data.getConfigurationSection("stats.forced-stats");
                assert section != null;
                for (String key : section.getKeys(false)) {
                    forcedStats.put(Statistic.valueOf(key), section.getLong(key, 0));
                }
            }
            if (data.contains("chosen-stats")) {
                ConfigurationSection section = data.getConfigurationSection("stats.chosen-stats");
                assert section != null;
                for (String key : section.getKeys(false)) {
                    chosenStats.put(Statistic.valueOf(key), new Range(data.getString(key, "0")));
                }
            }
        }

        templates.put(templateIdentifier, this);
    }

    public static ItemTemplate getTemplate(String id) {
        return templates.getOrDefault(id, null);
    }
}
