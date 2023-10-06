package com.carterz30cal.orbed.items;

import com.carterz30cal.orbed.Orbed;
import com.carterz30cal.orbed.stats.StatContainer;
import com.carterz30cal.orbed.stats.Statistic;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Item {
    private static Map<UUID, Item> items = new HashMap<>();
    public static final NamespacedKey kItemIdentifier = new NamespacedKey(Orbed.instance, "kItemIdentifier");
    public final UUID identifier;

    private String templateIdentifier;
    private StatContainer stats;

    public int rarityOffset;


    public String getTemplateIdentifier() {
        return templateIdentifier;
    }
    public ItemTemplate getTemplate() {
        return ItemTemplate.getTemplate(templateIdentifier);
    }


    public ItemRarity getRarity() {
        ItemTemplate template = ItemTemplate.getTemplate(templateIdentifier);

        int ordinal = template.baseRarity.ordinal() + rarityOffset;
        ordinal = Math.min(ordinal, ItemRarity.values().length - 1);

        return ItemRarity.values()[ordinal];
    }

    public StatContainer getStats() {
        return stats;
    }

    public Long getStat(Statistic stat) {
        return stats.get(stat, false);
    }

    public static Item getFromItemStack(ItemStack stack) {
        if (stack == null || stack.getItemMeta() == null) return null;
        return getFromItemStack(stack.getItemMeta());
    }
    public static Item getFromItemStack(ItemMeta meta) {
        PersistentDataContainer container = meta.getPersistentDataContainer();

        if (!container.has(kItemIdentifier, PersistentDataType.STRING)) return null;
        String uuid = meta.getPersistentDataContainer().get(
                kItemIdentifier,
                PersistentDataType.STRING
        );
        assert uuid != null;
        return items.getOrDefault(UUID.fromString(uuid), null);
    }

    public Item(@NotNull String templateIdentifier, @NotNull StatContainer stats, int rarityOffset) {
        identifier = UUID.randomUUID();

        this.stats = stats;
        this.templateIdentifier = templateIdentifier;
        this.rarityOffset = rarityOffset;

        items.put(identifier, this);
    }
    public Item(UUID id) {
        identifier = id;
    }
}
