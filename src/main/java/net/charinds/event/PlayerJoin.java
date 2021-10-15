package net.charinds.event;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        List<String> builder_list = new ArrayList<String>();
        Player player = event.getPlayer();
        String name = player.getName();
        event.setJoinMessage("\u00A7b"+ name + "がログインしました(管理者モード)");
        if(player.getName().equals("charindou")){//俺だったら
            player.setDisplayName("\u00A7c\u00A7l[*]\u00A7r" + player.getName());
            player.setPlayerListName("\u00A7c\u00A7l[*]\u00A7r" + player.getName());
        }
        //----------------------------------------//
        player.setGameMode(GameMode.CREATIVE);
        player.setFlying(true);
        //----------------------------------------//
    }
}
