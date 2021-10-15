package net.charinds.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable {

    private Integer i;

    public Timer(Integer i) {
        this.i = i;
    }

    @Override
    public void run() {
        i -= 1;
        Bukkit.getServer().broadcastMessage(i.toString());
        if (i <= 0) {
            cancel();
        }
    }
}
