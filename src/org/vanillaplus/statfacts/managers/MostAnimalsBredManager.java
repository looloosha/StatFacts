package org.vanillaplus.statfacts.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;

public class MostAnimalsBredManager extends Stat{
	static SettingsManager settings = SettingsManager.getInstance();
	
	private static String statTag = "mostAnimalsBread";
	
	public void broadcastStatMessage() {
		String breeder = settings.getData().getString("stats." + statTag + ".breeder");
		
		Bukkit.getServer().broadcastMessage(ChatColor.GOLD  +  "" + ChatColor.BOLD + breeder + 
				ChatColor.DARK_AQUA  +  "" + ChatColor.BOLD + " has created " + 
				ChatColor.GOLD  +  "" + ChatColor.BOLD + settings.getData().getInt("stats." + statTag + ".playerCount." + settings.getData().getString("stats." + statTag + ".breeder")) + 
				ChatColor.DARK_AQUA  +  "" + ChatColor.BOLD + " pairs of baby animals. Suuuu cute.");
	}
	
	public void initConfig() {
		if(!settings.getData().isSet("stats." + statTag + ".breeder")) {
			settings.getData().set("stats." + getStatTag() + ".breeder", "Nobody");
			settings.getData().set("stats." + getStatTag() + ".playerCount", null);
			settings.saveData();
		}
	}
	
	@Override
	public void initBroadcastingList(){
		BroadcastingManager.putStat(this);
	}
	
	public String getStatTag() {
		return statTag;
	}
	
	public static void updatePlayerBreederStat(String pName) {
		if(settings.getData().getString("stats." + statTag + ".breeder") == "Nobody") {
			settings.getData().set("stats." + statTag + ".breeder", pName);
			
			settings.getData().set("stats." + statTag + ".playerCount." + pName, 1);
			settings.saveData();
			return;
		}
		
		if(settings.getData().getString("stats." + statTag + ".breeder") != "Nobody") {
			if(!settings.getData().isSet("stats." + statTag + ".playerCount." + pName)) {
				settings.getData().set("stats." + statTag + ".playerCount." + pName, 1);
				settings.saveData();
				return;
			}
			
			settings.getData().set("stats." + statTag + ".playerCount." + pName, settings.getData().getInt("stats." + statTag + ".playerCount." + pName) + 1);
			settings.saveData();
			
			if(settings.getData().getInt("stats." + statTag + ".playerCount." + pName) > 
			settings.getData().getInt("stats." + statTag + ".playerCount." + 
			settings.getData().getString("stats." + statTag + ".breeder"))) {
				settings.getData().set("stats." + statTag + ".breeder", pName);
				settings.saveData();
			}
		}
		settings.saveData();
	}
	
	/**
	 * stats
	 * 	mostAnimalsBred
	 * 		breeder: Nobody
	 * 		playerCount
	 * 			player: int value
	 */

}
