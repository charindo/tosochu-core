package net.charinds.manager;

import net.charinds.Core;
import net.charinds.store.CustomConfig;

public class ConfigManager{

    public static CustomConfig config;
    public static CustomConfig admin;

    public ConfigManager(){
        config = new CustomConfig(Core.core);
        config.saveDefaultConfig();
        admin = new CustomConfig(Core.core, "admin.yml");
        admin.saveDefaultConfig();
    }

    public static CustomConfig getCustomConfig(String configName) {
        if (configName.equalsIgnoreCase("config")) {
            return config;
        } else if (configName.equalsIgnoreCase("admin")) {
            return admin;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
