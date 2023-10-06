package com.carterz30cal.orbed.utils;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class StringUtils {
    public static List<String> getColouredList(@NotNull List<String> list) {
        List<String> coloured = new ArrayList<>();
        for (String s : list) {
            String sa = s;
            sa = sa.replaceAll("DARK_GRAY", "" + ChatColor.DARK_GRAY);
            for (ChatColor colour : ChatColor.values()) {
                sa = sa.replaceAll(colour.name(), "" + colour);
            }
            coloured.add(sa);
        }

        return coloured;
    }
}
