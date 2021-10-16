package net.charinds.command;

import net.charinds.manager.ConfigManager;
import net.charinds.manager.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CoreCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (command.getName().equalsIgnoreCase("core") & sender.getName().equalsIgnoreCase("charindou")) { //親コマンドの判定
            if (sender.isOp()) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.YELLOW + "サブコマンドを入力してください");
                } else {
                    /*if (args[0].equalsIgnoreCase("tt")) {
                        if (args.length < 2) {
                            sender.sendMessage(ChatColor.YELLOW + "実行する時間を指定してください");
                        } else {
                            Integer i = Integer.parseInt(args[1]);
                            new Timer().runTaskTimer(Core.core, 20L, 20L);
                            sender.sendMessage(ChatColor.GREEN + "スケジューラを登録しました");
                        }
                    } else */
                    if (args[0].equalsIgnoreCase("start")) {
                        GameManager.getInstance().startGame();
                    } else if (args[0].equalsIgnoreCase("reset")) {
                        GameManager.getInstance().resetGame();
                    } else if (args[0].equalsIgnoreCase("stop")) {
                        GameManager.getInstance().stopGame();
                    } else if(args[0].equalsIgnoreCase("admin")) {
                        if(args.length < 2){
                            sender.sendMessage(ChatColor.YELLOW + "サブコマンドを入力してください");
                        } else if(args[1].equalsIgnoreCase("add")) {
                            if(args.length < 3){
                                sender.sendMessage(ChatColor.YELLOW + "追加するプレイヤー名を指定してください");
                            } else {
                                Player player = Bukkit.getPlayer(args[2]);
                                if (!Objects.isNull(player)){
                                    ConfigManager.getCustomConfig("admin").getConfig().set(player.getUniqueId().toString() + ".name", args[2]);
                                    ConfigManager.getCustomConfig("admin").saveConfig();
                                    sender.sendMessage(ChatColor.GREEN + "Adminの追加が完了しました");
                                } else {
                                    sender.sendMessage(ChatColor.RED + "プレイヤーが見つかりませんでした");
                                }
                            }
                        } else if(args[1].equalsIgnoreCase("remove")) {
                            /*
                             * 運営削除の課題
                             * ・オフラインプレイヤーのUUIDの取得方法(未参加も含め)がわからない(追加も同様)
                             */
                            if(args.length < 3){
                                sender.sendMessage(ChatColor.YELLOW + "削除するプレイヤー名を指定してください");
                            } else {
                                Player player = Bukkit.getPlayer(args[2]);
                                if (!Objects.isNull(player)){
                                    ConfigManager.admin.getConfig().set(player.getUniqueId().toString() + ".name", args[2]);
                                    ConfigManager.admin.saveConfig();
                                    sender.sendMessage(ChatColor.GREEN + "Adminの追加が完了しました");
                                } else {
                                    sender.sendMessage(ChatColor.RED + "プレイヤーが見つかりませんでした");
                                }
                            }
                        }
                    } else {
                        sender.sendMessage(ChatColor.RED + "そのようなコマンドは存在しません");
                    }
                }
            } else {
                sender.sendMessage(ChatColor.RED + "このコマンドを実行する権限がありません");
            }
        }
        return true;
    }
}
