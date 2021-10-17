package net.charinds.event;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerInteract implements Listener{

    @EventHandler
    public void onTouch(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        PlayerInventory inventory = player.getInventory();
        ItemStack item = inventory.getItemInMainHand();
        if (item.getType().equals(Material.EMERALD)) {
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                item.setAmount(item.getAmount() - 1);
                inventory.setItemInMainHand(item);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10 * 20, 3, true));
                player.sendMessage("\u00A7aスピエメの力で、足が速くなった！");
                player.playSound(new Location(Bukkit.getWorld(player.getWorld().getName()), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ()), Sound.ENTITY_WITHER_SHOOT, (float) 0.75, (float) 1.5);
            }
        }
    }
}
