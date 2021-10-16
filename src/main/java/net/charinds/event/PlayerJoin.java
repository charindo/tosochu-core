package net.charinds.event;

import net.charinds.manager.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        List<String> builder_list = new ArrayList<String>();
        Player player = event.getPlayer();
        String name = player.getName();
        event.setJoinMessage("\u00A7a\u00A7l[+]\u00A7r "+ name + "");
        if (player.getName().equals("charindou")) {//俺だったら
            player.setDisplayName("\u00A7a\u00A7l[*]\u00A7r" + player.getName());
            player.setPlayerListName("\u00A7a\u00A7l[*]\u00A7r" + player.getName());
        } else if (ConfigManager.admins.getConfig().contains(player.getUniqueId().toString())) {
            player.setDisplayName("\u00A7c\u00A7l[*]\u00A7r" + player.getName());
            player.setPlayerListName("\u00A7c\u00A7l[*]\u00A7r" + player.getName());
        }
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 2147483647, 0, false));
    }
}
