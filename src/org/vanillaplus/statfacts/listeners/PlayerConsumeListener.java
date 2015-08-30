package org.vanillaplus.statfacts.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.vanillaplus.statfacts.managers.MostPotatosEatenManager;

public class PlayerConsumeListener implements Listener{
	
	@EventHandler
	public void onPlayerEat(PlayerItemConsumeEvent e) {
		//Potato Consumed
		
		if(e.getItem().getType() == Material.BAKED_POTATO) {
			MostPotatosEatenManager.updatePotatoEaterStat(e.getPlayer().getName());
		}
	}
}
