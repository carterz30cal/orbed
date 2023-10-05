package com.carterz30cal.orbed.items;

import com.carterz30cal.orbed.maths.Range;
import com.carterz30cal.orbed.stats.StatContainer;
import com.carterz30cal.orbed.stats.Statistic;
import com.carterz30cal.orbed.utils.StringUtils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

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

        int rarityOffset = 0;
        while (Range.getWithin(1, 100) <= 20) {
            rarityOffset++;
        }

        return new Item(template.templateIdentifier, stats, rarityOffset);
    }

    public static ItemStack attachItemStack(Item item) {
        ItemStack stack = new ItemStack(item.getTemplate().baseMaterial);
        ItemMeta meta = stack.getItemMeta();


        assert meta != null;
        meta.getPersistentDataContainer().set(Item.kItemIdentifier, PersistentDataType.STRING, item.identifier.toString());
        stack.setItemMeta(meta);

        return stack;
    }

    public static void updateItemMeta(ItemStack stack) {
        Item item = Item.getFromItemStack(stack);
        if (item == null) return;
        ItemMeta meta = stack.getItemMeta();
        if (meta == null) return;
        ItemRarity itemRarity = item.getRarity();

        String name = item.getTemplate().itemName;
        List<String> lore = new ArrayList<>();
        lore.add("DARK_GRAY" + itemRarity.getRawName() + "-Rank " + item.getTemplate().itemType.getName());

        meta.setDisplayName(itemRarity.getColour() + name);
        meta.setLore(StringUtils.getColouredList(lore));
        stack.setItemMeta(meta);
    }
}
