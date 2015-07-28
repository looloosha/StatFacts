package org.vanillaplus.statfacts.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.vanillaplus.statfacts.managers.NewestPlayerManager;

public class NewestPlayerListener implements Listener{
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) {
		if(!e.getPlayer().hasPlayedBefore()){
			NewestPlayerManager.setNewestPlayer(e.getPlayer().getName());
		}
		return;
	}
}
