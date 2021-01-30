package me.raimuakuna.yeetthechat;

import me.raimuakuna.yeetthechat.commands.Reload;
import org.bukkit.plugin.java.JavaPlugin;
import me.raimuakuna.yeetthechat.commands.Yeetchat;


import java.util.Objects;

public final class Yeetthechat extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Objects.requireNonNull(getCommand("yeetchat")).setExecutor(new Yeetchat());
        Objects.requireNonNull(getCommand("ycreload")).setExecutor(new Reload());
    }

    @Override
    public void onDisable() {
    }
}
