package net.charinds;

import net.charinds.manager.CommandManager;
import net.charinds.manager.ConfigManager;
import net.charinds.manager.EventManager;
import net.charinds.manager.GameManager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin implements Listener {

    public static String VERSION = "1.0.0";

    public static Core core;

    @Override
    public void onEnable(){
        this.core = this;
        //===============================================//
        EventManager eventManager = new EventManager();
        eventManager.registerEvents(this);
        CommandManager commandManager = new CommandManager();
        commandManager.registerCommands();
        GameManager gameManager = new GameManager();
        ConfigManager configManager = new ConfigManager();
        //===============================================//
        getLogger().info("プラグインを読み込みました。");
    }

    @Override
    public void onDisable(){
        // Plugin shutdown logic
    }
}
