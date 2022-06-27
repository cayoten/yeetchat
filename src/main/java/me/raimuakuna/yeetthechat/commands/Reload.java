package me.raimuakuna.yeetthechat.commands;

import me.raimuakuna.yeetthechat.Yeetthechat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {

    Yeetthechat plugin = Yeetthechat.getPlugin(Yeetthechat.class);

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String pluginPrefix = plugin.getConfig().getString("plugin-prefix");
        String noPerms = plugin.getConfig().getString("no-permission-error");

        if (!sender.hasPermission("Yeetchat.reload")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',pluginPrefix + noPerms));
            return true;
        }

        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', pluginPrefix + "&aUgh, fine. It's done. &cPlugin reloaded!"));
        return true;
    }
}