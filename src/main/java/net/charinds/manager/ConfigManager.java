package net.charinds.manager;

import net.charinds.Core;
import net.charinds.store.CustomConfig;

public class ConfigManager{

    public static CustomConfig config;
    public static CustomConfig admins;

    public ConfigManager(){
        config = new CustomConfig(Core.core);
        config.saveDefaultConfig();
        admins = new CustomConfig(Core.core, "admin.yml");
        admins.saveDefaultConfig();
    }
}
