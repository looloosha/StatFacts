package org.vanillaplus.statfacts.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.vanillaplus.statfacts.managers.TotalTNTLitManager;


public class TNTLitListener implements Listener{
	
	@EventHandler
	public void onTNTLitEvent(PlayerInteractEvent e)
	{
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if(e.getMaterial() == Material.FLINT_AND_STEEL)
			{
				if (e.getClickedBlock().getType() == Material.TNT)
				{					
					TotalTNTLitManager.updateTNTStat(e.getPlayer().getName());
					
					TotalTNTLitManager.updatePyromaniac((e.getPlayer().getName()));
				}
			}
		}
	}
}
