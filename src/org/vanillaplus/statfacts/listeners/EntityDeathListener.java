package org.vanillaplus.statfacts.listeners;


import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.vanillaplus.statfacts.managers.TotalHorsesKilledManager;
import org.vanillaplus.statfacts.managers.TotalSquidsKilledManager;
import org.vanillaplus.statfacts.managers.TotalZombiesKilledManager;

public class EntityDeathListener implements Listener{
	
	@EventHandler
	public void onZombieDeathEvent(EntityDeathEvent e){
		
		//Zombie Death
		if (e.getEntity() instanceof Zombie){
			Zombie zombie = (Zombie) e.getEntity();
			
			if(zombie.getKiller() instanceof Player){
				TotalZombiesKilledManager.incrementZombieDeathCount();
			}
		}
		
		//Squid Death
		if(e.getEntity() instanceof Squid){
			Squid squid = (Squid) e.getEntity();
			
			if(squid.getKiller() instanceof Player){
				TotalSquidsKilledManager.incrementSquidDeathCount();
			}
		}
		
		//Horse Death
		if(e.getEntity() instanceof Horse){
			Horse horse = (Horse) e.getEntity();
			
			if(horse.getKiller() instanceof Player){
				TotalHorsesKilledManager.incrementHorseDeathCount();
			}
		}
			
	}
}
