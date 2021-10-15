package net.charinds.manager;

import net.charinds.Core;
import net.charinds.event.PlayerInteract;
import net.charinds.event.PlayerJoin;
import net.charinds.event.PlayerQuit;
import org.bukkit.Bukkit;

public class EventManager {

    public static void registerEvents(Core core){
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(), core);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerQuit(), core);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteract(), core);
    }
}
