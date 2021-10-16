package net.charinds.event;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.getType().equals(Material.GOLD_AXE) & player.getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
            player.sendMessage("[ID Checker] ItemID: " + block.getType().toString() + ":" + block.getData());//調べたところ、非推奨じゃない方法はなさそう
        }
    }
}
