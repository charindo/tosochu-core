package net.charinds.command;

import net.charinds.Core;
import net.charinds.scheduler.Timer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.sql.Time;

public class CoreCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("core")) { //親コマンドの判定
            if (sender.isOp()) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.YELLOW + "サブコマンドを入力してください");
                } else {
                    if (args[0].equalsIgnoreCase("tt")) {
                        if (args.length < 2) {
                            sender.sendMessage(ChatColor.YELLOW + "実行する時間を指定してください");
                        } else {
                            Integer i = Integer.parseInt(args[1]);
                            new Timer(i).runTaskTimer(Core.core, 20L, 20L);
                            sender.sendMessage(ChatColor.GREEN + "スケジューラを登録しました");
                        }
                    } else {
                        sender.sendMessage(ChatColor.RED + "そのようなコマンドは存在しません");
                    }
                }
            }else{
                sender.sendMessage(ChatColor.RED + "このコマンドを実行する権限がありません");
            }
        }
        return true;
    }
}
