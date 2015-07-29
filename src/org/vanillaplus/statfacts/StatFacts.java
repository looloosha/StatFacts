package org.vanillaplus.statfacts;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.vanillaplus.statfacts.listeners.EntityDeathListener;
import org.vanillaplus.statfacts.listeners.NewestPlayerListener;
import org.vanillaplus.statfacts.listeners.EntityDeathListener;
import org.vanillaplus.statfacts.managers.*;
import org.vanillaplus.statfacts.tasks.BroadcastTask;

public class StatFacts extends JavaPlugin{
	
	SettingsManager settings = SettingsManager.getInstance();
	
	//Stat Objects
	TotalZombiesKilledManager totalZombiesKilledManager = new TotalZombiesKilledManager();
	NewestPlayerManager newestPlayerManager = new NewestPlayerManager();
	TotalSquidsKilledManager totalSquidsKilledManger = new TotalSquidsKilledManager();
	
	public void onEnable(){
		//Sets up data file
		settings.setup(this);
		
		//Initializers (Note Order)
		initConfigSections();
		initBroadcastingManger();
		
		//Register Events
		registerEvents();
		
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new BroadcastTask(), 0, 20 * 4);
		
	}
	
	//Register Events Here
	public void registerEvents(){
		Bukkit.getServer().getPluginManager().registerEvents(new EntityDeathListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new NewestPlayerListener(), this);
	}
	
	//Initialize the BroadcastingManger for use here.
	public void initBroadcastingManger(){
		totalZombiesKilledManager.initBroadcastingList();
		newestPlayerManager.initBroadcastingList();
		totalSquidsKilledManger.initBroadcastingList();
		
	}
	
	//Initialize config sections for individual stats here.
	public void initConfigSections(){
		totalZombiesKilledManager.initConfig();
		newestPlayerManager.initConfig();
		totalSquidsKilledManger.initConfig();
	}
}
