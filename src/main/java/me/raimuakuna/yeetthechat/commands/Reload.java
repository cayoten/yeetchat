package me.raimuakuna.yeetthechat.commands;

import me.raimuakuna.yeetthechat.Yeetthechat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {

    Yeetthechat plugin = Yeetthechat.getPlugin(Yeetthechat.class);

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String pluginprefix = plugin.getConfig().getString("pluginprefix");

        if (!sender.hasPermission("Yeetchat.reload")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',pluginprefix + "&cYou do not have the required permission to run this command! (yeetchat.reload)"));
            return true;
        }

        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', pluginprefix + "&aUgh, fine. It's done."));
        return true;
    }
}