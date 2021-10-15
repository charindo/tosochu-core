package net.charinds.command;

import net.charinds.Core;
import net.charinds.scheduler.Timer;
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
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("hub")) { //親コマンドの判定
            if(sender instanceof Player) {
                ((Player) sender).teleport(new Location(Bukkit.getWorld("lobby"), -5.5,66,-5.5));
            }else{
                sender.sendMessage(ChatColor.RED + "このコマンドはゲーム内で実行してください");
            }
        }
        return true;
    }
}
