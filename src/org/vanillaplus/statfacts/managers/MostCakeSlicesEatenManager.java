package org.vanillaplus.statfacts.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class MostCakeSlicesEatenManager extends Stat{
	static SettingsManager settings = SettingsManager.getInstance();
	
	private static String statTag = "mostCakeSlicesEaten";
	
	public void broadcastStatMessage() {
		String cakeEater = settings.getData().getString("stats." + statTag + ".cakeEater");
		
		Bukkit.getServer().broadcastMessage(ChatColor.GOLD  +  "" + ChatColor.BOLD + cakeEater +
				ChatColor.DARK_AQUA  +  "" + ChatColor.BOLD + " is now overweight because they ate " +
				ChatColor.GOLD  +  "" + ChatColor.BOLD + settings.getData().getInt("stats." + getStatTag() + ".playerCount." + cakeEater) +
				ChatColor.DARK_AQUA  +  "" + ChatColor.BOLD + " cake slices.");
	}
	
	public void initConfig() {
		if(!settings.getData().isSet("stats." + statTag + ".cakeEater")) {
			settings.getData().set("stats." + getStatTag() + ".cakeEater", "Nobody");
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
	
	public static void updatePlayerCakeEaterStat(String pName) {
		if(settings.getData().getString("stats." + statTag + ".cakeEater") == "Nobody") {
			settings.getData().set("stats." + statTag + ".cakeEater", pName);
			
			settings.getData().set("stats." + statTag + ".playerCount." + pName, 1);
			settings.saveData();
			return;
		}
		
		if(settings.getData().getString("stats." + statTag + ".cakeEater") != "Nobody") {
			if(!settings.getData().isSet("stats." + statTag + ".playerCount." + pName)) {
				settings.getData().set("stats." + statTag + ".playerCount." + pName, 1);
				settings.saveData();
				return;
			}
			
			settings.getData().set("stats." + statTag + ".playerCount." + pName, settings.getData().getInt("stats." + statTag + ".playerCount." + pName) + 1);
			settings.saveData();
			
			if(settings.getData().getInt("stats." + statTag + ".playerCount." + pName) > 
			settings.getData().getInt("stats." + statTag + ".playerCount." + 
			settings.getData().getString("stats." + statTag + ".cakeEater"))) {
				settings.getData().set("stats." + statTag + ".cakeEater", pName);
				settings.saveData();
			}
		}
		settings.saveData();
	}
	
}
