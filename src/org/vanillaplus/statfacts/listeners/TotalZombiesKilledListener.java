package org.vanillaplus.statfacts.listeners;


import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.vanillaplus.statfacts.managers.TotalZombiesKilledManager;

public class TotalZombiesKilledListener implements Listener{
	
	@EventHandler
	public void onZombieDeathEvent(EntityDeathEvent e){
		if (e.getEntity() instanceof Zombie){
			Zombie zombie = (Zombie) e.getEntity();
			
			if(zombie.getKiller() instanceof Player){
				TotalZombiesKilledManager.incrementZombieDeathCount();
			}
		}
	}
}
