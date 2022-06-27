package me.raimuakuna.yeetthechat.commands;

import me.raimuakuna.yeetthechat.Yeetthechat;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;


public class Yeetchat implements CommandExecutor {

    Yeetthechat plugin = Yeetthechat.getPlugin(Yeetthechat.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String pluginPrefix = plugin.getConfig().getString("plugin-prefix");
        String broadcastPrefix = plugin.getConfig().getString("broadcast-prefix");
        String noPerms = plugin.getConfig().getString("no-permission-error");

        String successMessage = Objects.requireNonNull(plugin.getConfig().getString("successful-clear")).replace("%p", sender.getName());

        // If you don't have the ability to Clear, do this
        if (!sender.hasPermission("yeetchat.clear")){

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',pluginPrefix + noPerms));
            return true;
        }

        for (Player player: Bukkit.getOnlinePlayers()) {

            //If the player does NOT have a bypass, clear their chat
            if (!player.hasPermission("yeetchat.bypass")) {
                for (int i = 0; i < 101; i++) {
                    player.sendMessage(" ");
                }

                //Send to everyone
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', broadcastPrefix + successMessage));

            }

            //If they have bypass, do this
            if (player.hasPermission("yeetchat.notify")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', pluginPrefix + successMessage));
            }
        }

        return true;
    }
}
