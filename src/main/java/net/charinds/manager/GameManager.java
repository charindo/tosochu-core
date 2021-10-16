package net.charinds.manager;

import net.charinds.Core;
import net.charinds.scheduler.Timer;
import net.charinds.store.CustomConfig;
import net.charinds.store.StatusStore;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import java.util.TimerTask;

public class GameManager {

    public static GameManager gameManager;

    public Timer timerTask;
    public Integer status;
    public Integer time;

    public GameManager() {
        this.gameManager = this;
        status = StatusStore.STOPPED;
        time = 0;
        timerTask = new Timer();
        timerTask.runTaskTimer(Core.getInstance(), 0L, 20L);
    }

    public static GameManager getInstance() {
        return GameManager.gameManager;
    }

    public void setStatus(Integer new_status) {
        status = new_status;
    }

    public Integer getStatus() {
        return status;
    }

    public void startGame() {
        //TODO
    }

    public void endGame() {
        //TODO
    }

    public void resetGame() {
        CustomConfig config = ConfigManager.getCustomConfig("config");
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.teleport(new Location(Bukkit.getWorld(config.getConfig().getString("lobby.world")), config.getConfig().getDouble("lobby.x"), config.getConfig().getDouble("lobby.y"), config.getConfig().getDouble("lobby.z")));
        }
        resetStatus();
    }

    public void resetStatus() {
        if (!timerTask.isCancelled()) {
            timerTask.cancel();
        }
        Core.getInstance().gameManager = new GameManager();
    }

    public void stopGame() {
        setStatus(StatusStore.STOPPED);
    }
}
