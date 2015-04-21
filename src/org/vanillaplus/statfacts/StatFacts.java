package org.vanillaplus.statfacts;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class StatFacts extends JavaPlugin{
	
	public void onEnable(){
		Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "StatFacts has been enabled!");
	}
	
	public void onDisable(){
		Bukkit.getServer().broadcastMessage(ChatColor.RED + "StatFacts has been disabled!");
	}
}
