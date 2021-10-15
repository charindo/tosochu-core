package net.charinds.manager;

import net.charinds.scheduler.Timer;
import net.charinds.store.StatusStore;

public class GameManager {

    public Timer timerTask;
    public Integer status;

    public GameManager(){
        status = StatusStore.STOPPED;
    }

    public void startGame() {
        //TODO
    }

    public void endGame() {
        //TODO
    }

    public void resetGame() {
        //TODO
    }

    public void resetStatus() {
        //TODO
    }
}
