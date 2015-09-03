package org.vanillaplus.statfacts.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.vanillaplus.statfacts.managers.MostCakeSlicesEatenManager;

public class PlayerInteractListener implements Listener{
	
	
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType() == Material.CAKE_BLOCK && e.getPlayer().getFoodLevel() < 20) {
				MostCakeSlicesEatenManager.updatePlayerCakeEaterStat(e.getPlayer().getName());
			}
		}
	}
}
