package com.carterz30cal.orbed.items;

import com.carterz30cal.orbed.stats.StatContainer;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Item {
    public final UUID identifier;

    private String templateIdentifier;
    private StatContainer stats;


    public String getTemplateIdentifier() {
        return templateIdentifier;
    }

    public Item(@NotNull String templateIdentifier, @NotNull StatContainer stats) {
        identifier = UUID.randomUUID();

        this.stats = stats;
        this.templateIdentifier = templateIdentifier;
    }
    public Item(UUID id) {
        identifier = id;
    }
}
