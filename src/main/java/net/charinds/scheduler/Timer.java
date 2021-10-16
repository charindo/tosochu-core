package net.charinds.scheduler;

import net.charinds.manager.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable {

    private Integer i;

    @Override
    public void run() {
        for (Player player : Bukkit.getServer().getOnlinePlayers()){
            GameManager.getInstance().updateScoreboard(player);
        }
    }
}
