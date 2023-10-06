package com.carterz30cal.orbed.commands;

import com.carterz30cal.orbed.items.Item;
import com.carterz30cal.orbed.items.ItemFactory;
import com.carterz30cal.orbed.items.ItemTemplate;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandItem implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player && commandSender.isOp()) {
            String template = args[0];

            Item gen = ItemFactory.generateItem(ItemTemplate.getTemplate(template));
            ((Player)commandSender).getInventory().addItem(ItemFactory.attachItemStack(gen));
            return true;
        }
        else return false;
    }
}
