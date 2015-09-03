package org.vanillaplus.statfacts;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.vanillaplus.statfacts.listeners.EntityDeathListener;
import org.vanillaplus.statfacts.listeners.NewestPlayerListener;
import org.vanillaplus.statfacts.listeners.EntityDeathListener;
import org.vanillaplus.statfacts.listeners.PaintingPlacedListener;
import org.vanillaplus.statfacts.listeners.PlayerConsumeListener;
import org.vanillaplus.statfacts.listeners.PlayerDeathListener;
import org.vanillaplus.statfacts.listeners.PlayerInteractListener;
import org.vanillaplus.statfacts.listeners.PlayerStatisticIncrementListener;
import org.vanillaplus.statfacts.listeners.TNTLitListener;
import org.vanillaplus.statfacts.managers.*;
import org.vanillaplus.statfacts.tasks.BroadcastTask;

public class StatFacts extends JavaPlugin{
	
	SettingsManager settings = SettingsManager.getInstance();
	
	//Stat Objects
	TotalZombiesKilledManager totalZombiesKilledManager = new TotalZombiesKilledManager();
	NewestPlayerManager newestPlayerManager = new NewestPlayerManager();
	TotalSquidsKilledManager totalSquidsKilledManger = new TotalSquidsKilledManager();
	TotalTNTLitManager totalTNTLitManager = new TotalTNTLitManager();
	TotalHorsesKilledManager totalHorsesKilledManager = new TotalHorsesKilledManager();
	PaintingsPlacedManager paintingsPlacedManager = new PaintingsPlacedManager();
	MostAnimalsBredManager mostAnimalsBredManager = new MostAnimalsBredManager();
	MostPlayersKilledManager mostPlayersKilledManager = new MostPlayersKilledManager();
	TotalGlobalDeathsManager totalGlobablDeathsManager = new TotalGlobalDeathsManager();
	MostPotatosEatenManager mostPotatosEatenManager = new MostPotatosEatenManager();
	MostCakeSlicesEatenManager mostCakeSlicesEatenManger = new MostCakeSlicesEatenManager();
	
	public void onEnable(){
		//Sets up data file
		settings.setup(this);
		
		//Initializers (Note Order)
		initConfigSections();
		initBroadcastingManager();
		
		//Register Events
		registerEvents();
		
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new BroadcastTask(), 0, 20 * 4);
		
	}
	
	//Register Events Here
	public void registerEvents(){
		Bukkit.getServer().getPluginManager().registerEvents(new EntityDeathListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new NewestPlayerListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new TNTLitListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PaintingPlacedListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerStatisticIncrementListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerConsumeListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
	}
	
	//Initialize the BroadcastingManger for use here.
	public void initBroadcastingManager(){
		//totalZombiesKilledManager.initBroadcastingList();
		//newestPlayerManager.initBroadcastingList();
		//totalSquidsKilledManger.initBroadcastingList();
		//totalTNTLitManager.initBroadcastingList();
		//totalHorsesKilledManager.initBroadcastingList();
		//paintingsPlacedManager.initBroadcastingList();
		//mostAnimalsBredManager.initBroadcastingList();
		//mostPlayersKilledManager.initBroadcastingList();
		//totalGlobablDeathsManager.initBroadcastingList();
		mostPotatosEatenManager.initBroadcastingList();
		mostCakeSlicesEatenManger.initBroadcastingList();
	}
	
	//Initialize config sections for individual stats here.
	public void initConfigSections(){
		totalZombiesKilledManager.initConfig();
		newestPlayerManager.initConfig();
		totalSquidsKilledManger.initConfig();
		totalTNTLitManager.initConfig();
		totalHorsesKilledManager.initConfig();
		mostAnimalsBredManager.initConfig();
		paintingsPlacedManager.initConfig();
		mostPlayersKilledManager.initConfig();
		totalGlobablDeathsManager.initConfig();
		mostPotatosEatenManager.initConfig();
		mostCakeSlicesEatenManger.initConfig();
	}
}
