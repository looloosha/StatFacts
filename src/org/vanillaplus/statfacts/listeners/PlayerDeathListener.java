package org.vanillaplus.statfacts.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.vanillaplus.statfacts.managers.MostPlayersKilledManager;

public class PlayerDeathListener implements Listener {
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		
		if(e.getEntityType() == EntityType.PLAYER) {
			Player p = e.getEntity();
			MostPlayersKilledManager.updatePlayerPVPerStat(p.getKiller().getName());
		}
	}
}
