package net.charinds.manager;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import net.charinds.Core;
import net.charinds.scheduler.Timer;
import net.charinds.store.CustomConfig;
import net.charinds.store.Status;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.io.PrintStream;
import java.util.Objects;

public class GameManager {

    public static GameManager gameManager;

    public Timer timerTask;
    public Integer status;
    public Integer time;

    public GameManager() {
        this.gameManager = this;
        status = Status.STOPPED;
        time = ConfigManager.getCustomConfig("config").getConfig().getInt("gameStatus.defaultTime");
        initTimerTask();
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

    public void setTime(Integer new_time) {
        time = new_time;
    }

    public Integer getTime() {
        return time;
    }

    public String getTimeToString() {
        return String.format("%02d:%02d", time / 60, time % 60);
    }

    public void updateAllPlayersScoreBoard() {
        for (Player player : Bukkit.getServer().getOnlinePlayers()){
            updateScoreboard(player);
        }
    }

    public void updateScoreboard(Player player) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = board.registerNewObjective("Main board", "dummy");
        objective.setDisplayName("\u00A7e\u00A7lRunForMoney");
        if (getStatus().equals(Status.STOPPED)) {
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Integer i = 0;
            Score score;
            score = objective.getScore(ChatColor.YELLOW + " ゲーム開始まで");
            score.setScore(i--);
            score = objective.getScore(ChatColor.YELLOW + " しばらくお待ちください...");
            score.setScore(i--);
            player.setScoreboard(board);
        } else if (getStatus().equals(Status.WAITING)) {
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Integer i = 0;
            Score score;
            score = objective.getScore(ChatColor.BLUE + "");
            score.setScore(i--);
            score = objective.getScore(" ゲーム開始まで: " + ChatColor.GREEN + "" + getTimeToString() + " ");
            score.setScore(i--);
            score = objective.getScore(ChatColor.YELLOW + "");
            score.setScore(i--);
            score = objective.getScore(ChatColor.YELLOW + " charinds.net");
            score.setScore(i--);
            player.setScoreboard(board);
        }
    }

    public void startGame() {
        Bukkit.getServer().broadcastMessage("NO PROGRESS");
        resetStatus();
    }

    public void endGame() {
        //TODO
    }

    public void resetGame() {
        CustomConfig config = ConfigManager.getCustomConfig("config");
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.teleport(new Location(Bukkit.getWorld(config.getConfig().getString("lobbyLocation.world")), config.getConfig().getDouble("lobbyLocation.x"), config.getConfig().getDouble("lobbyLocation.y"), config.getConfig().getDouble("lobbyLocation.z")));
        }
        resetStatus();
    }

    public void resetStatus() {
        stopTimerTask();
        Core.getInstance().gameManager = new GameManager();
    }

    public void stopTimerTask() {
        if (!Objects.isNull(timerTask)) {
            if (!timerTask.isCancelled()) {
                timerTask.cancel();
            }
        }
    }

    public void initTimerTask() {
        stopTimerTask();
        timerTask = new Timer();
        timerTask.runTaskTimer(Core.getInstance(), 20L, 20L);
    }

    public void stopGame() {
        setStatus(Status.STOPPED);
    }
}
