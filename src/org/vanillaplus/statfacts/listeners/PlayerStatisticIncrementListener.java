package org.vanillaplus.statfacts.listeners;

import org.bukkit.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;
import org.vanillaplus.statfacts.managers.MostAnimalsBredManager;

public class PlayerStatisticIncrementListener implements Listener{
	
	@EventHandler
	public void onPlayerStatisticIncrement(PlayerStatisticIncrementEvent e) {
		if(e.getStatistic() == Statistic.ANIMALS_BRED) {
			MostAnimalsBredManager.updatePlayerBreederStat(e.getPlayer().getName());
		}
		
	}

}
