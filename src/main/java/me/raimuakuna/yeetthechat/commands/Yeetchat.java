package me.raimuakuna.yeetthechat.commands;

import me.raimuakuna.yeetthechat.Yeetthechat;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class Yeetchat implements CommandExecutor {

    Yeetthechat plugin = Yeetthechat.getPlugin(Yeetthechat.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String pluginprefix = plugin.getConfig().getString("pluginprefix");
        String broadcastprefix = plugin.getConfig().getString("broadcastprefix");

        if (!sender.hasPermission("yeetchat.clear")){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',pluginprefix + "&cYou do not have the required permission to run this command! (yeetchat.clear)"));
            return true;
        }

        for (Player player: Bukkit.getOnlinePlayers()) {
            if (!player.hasPermission("yeetchat.bypass")) {
                for (int i = 0; i < 101; i++) {
                    player.sendMessage(" ");
                }

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', broadcastprefix + "&cThe chat has been obliterated by " + sender.getName() + "&c. What was said is no more!\n"));

            }

            if (player.hasPermission("yeetchat.notify")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',pluginprefix + "&aThe chat was cleared by &b" + sender.getName() + "&a."));
            }
        }

        return true;
    }
}
