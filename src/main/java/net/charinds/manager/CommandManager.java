package net.charinds.manager;

import net.charinds.command.CoreCommand;
import net.charinds.command.HubCommand;
import org.bukkit.Bukkit;

public class CommandManager{

    public static void registerCommands(){
        Bukkit.getPluginCommand("core").setExecutor(new CoreCommand());
        Bukkit.getPluginCommand("hub").setExecutor(new HubCommand());
    }
}
