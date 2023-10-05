package com.carterz30cal.orbed.items;

import com.carterz30cal.orbed.maths.Range;
import com.carterz30cal.orbed.stats.StatContainer;
import com.carterz30cal.orbed.stats.Statistic;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public final class ItemFactory {

    public static Item generateItem(ItemTemplate template) {
        StatContainer stats = new StatContainer();

        for (Statistic forcedStat : template.forcedStats.keySet()) {
            stats.add(forcedStat, template.forcedStats.get(forcedStat));
        }
        int choices = 3;
        List<Statistic> statChoices = new ArrayList<>(template.chosenStats.keySet());
        StatContainer chosen = new StatContainer();
        for (int c = 0; c < choices; c++) {
            int choice = Range.getWithin(0, statChoices.size() - 1);
            Statistic stat = statChoices.get(choice);
            chosen.set(stat, Math.max(chosen.get(stat, true), template.chosenStats.get(stat).getValueWithin()));
        }
        stats.add(chosen);

        return new Item(template.templateIdentifier, stats);
    }
}
