package org.vanillaplus.statfacts.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;

public class MostPotatosEatenManager extends Stat{
	
	static SettingsManager settings = SettingsManager.getInstance();
	
	private static String statTag = "mostPotatosEaten";
	
	public void broadcastStatMessage() {
		String potatoEater = settings.getData().getString("stats." + statTag + ".potatoEater");
		
		Bukkit.getServer().broadcastMessage(ChatColor.GOLD  +  "" + ChatColor.BOLD + potatoEater +
				ChatColor.DARK_AQUA  +  "" + ChatColor.BOLD + " has chowed down " + 
				ChatColor.GOLD  +  "" + ChatColor.BOLD + settings.getData().getInt("stats." + statTag + ".playerCount." + potatoEater) +
				ChatColor.DARK_AQUA  +  "" + ChatColor.BOLD + " potatos, which is the most out of everyone... Bruh, you are what ya' eat.");
	}
	
	public void initConfig() {
		if(!settings.getData().isSet("stats." + statTag + ".potatoEater")) {
			settings.getData().set("stats." + getStatTag() + ".potatoEater", "Nobody");
			settings.getData().set("stats." + getStatTag() + ".playerCount", null);
			settings.saveData();
		}
	}
	
	@Override
	public void initBroadcastingList() {
		BroadcastingManager.putStat(this);
	}
	
	public String getStatTag() {
		return statTag;
	}
	
	public static void updatePotatoEaterStat(String pName) {
		if(settings.getData().getString("stats." + statTag + ".potatoEater") == "Nobody") {
			settings.getData().set("stats." + statTag + ".potatoEater", pName);
			
			settings.getData().set("stats." + statTag + ".playerCount." + pName, 1);
			settings.saveData();
			return;
		}
		
		if(settings.getData().getString("stats." + statTag + ".potatoEater") != "Nobody") {
			if(!settings.getData().isSet("stats." + statTag + ".playerCount." + pName)) {
				settings.getData().set("stats." + statTag + ".playerCount." + pName, 1);
				settings.saveData();
				return;
			}
			
			settings.getData().set("stats." + statTag + ".playerCount." + pName, settings.getData().getInt("stats." + statTag + ".playerCount." + pName) + 1);
			settings.saveData();
			
			if(settings.getData().getInt("stats." + statTag + ".playerCount." + pName) > 
			settings.getData().getInt("stats." + statTag + ".playerCount." + 
			settings.getData().getString("stats." + statTag + ".potatoEater"))) {
				settings.getData().set("stats." + statTag + ".potatoEater", pName);
				settings.saveData();
			}
		}
		settings.saveData();
	}

}
