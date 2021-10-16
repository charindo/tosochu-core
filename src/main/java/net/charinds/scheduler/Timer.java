package net.charinds.scheduler;

import jdk.net.SocketFlow;
import net.charinds.manager.GameManager;
import net.charinds.store.Status;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable {

    private Integer i;

    @Override
    public void run() {
        GameManager gm = GameManager.getInstance();
        if (gm.getStatus().equals(Status.WAITING)) {
            gm.setTime(gm.getTime() - 1);
            if(gm.getTime() <= 0) {
                gm.startGame();
            }
        }
        for (Player player : Bukkit.getServer().getOnlinePlayers()){
            GameManager.getInstance().updateScoreboard(player);
        }
    }
}
