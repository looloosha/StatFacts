package org.vanillaplus.statfacts.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.vanillaplus.statfacts.managers.MostPlayersKilledManager;
import org.vanillaplus.statfacts.managers.TotalGlobalDeathsManager;

public class PlayerDeathListener implements Listener {
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		
		if(e.getEntity().getPlayer().getKiller() instanceof Player) {
			Player p = e.getEntity();
			MostPlayersKilledManager.updatePlayerPVPerStat(p.getKiller().getName());
		}
		
		TotalGlobalDeathsManager.incrementGlobalDeathCount();
	}
}
