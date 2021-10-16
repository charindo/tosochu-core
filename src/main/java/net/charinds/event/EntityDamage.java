package net.charinds.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {

    @EventHandler
    public void onTouch(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player) {
            if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                event.setCancelled(true);
            }
        }
    }
}
