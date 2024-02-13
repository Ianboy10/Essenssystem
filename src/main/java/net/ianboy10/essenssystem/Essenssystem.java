package net.ianboy10.essenssystem;

import net.ianboy10.essenssystem.listener.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class Essenssystem extends JavaPlugin {

    @Override
    public void onEnable() {
        FileManager.setStandard();
        FileManager.readConfig();
        MySQL.connect();

        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
    }

    @Override
    public void onDisable() {
        MySQL.close();
    }
}
