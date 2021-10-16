package net.charinds.manager;

import net.charinds.Core;
import net.charinds.event.*;
import org.bukkit.Bukkit;

public class EventManager{

    public static void registerEvents(Core core){
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(), core);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerQuit(), core);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteract(), core);
        Bukkit.getServer().getPluginManager().registerEvents(new EntityDamage(), core);
        Bukkit.getServer().getPluginManager().registerEvents(new BlockBreak(), core);
    }
}
