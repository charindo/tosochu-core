package net.charinds.command;

import net.charinds.Core;
import net.charinds.manager.ConfigManager;
import net.charinds.scheduler.Timer;
import net.charinds.store.CustomConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HubCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (command.getName().equalsIgnoreCase("hub")) { //親コマンドの判定
            if (sender instanceof Player) {
                CustomConfig config = ConfigManager.getCustomConfig("config");
                ((Player) sender).teleport(new Location(Bukkit.getWorld(config.getConfig().getString("lobbyLocation.world")), config.getConfig().getDouble("lobbyLocation.x"), config.getConfig().getDouble("lobbyLocation.y"), config.getConfig().getDouble("lobbyLocation.z")));
            } else {
                sender.sendMessage(ChatColor.RED + "このコマンドはゲーム内で実行してください");
            }
        }
        return true;
    }
}
