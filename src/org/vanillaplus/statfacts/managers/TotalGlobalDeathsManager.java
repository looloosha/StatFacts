package org.vanillaplus.statfacts.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class TotalGlobalDeathsManager extends Stat{

	static SettingsManager settings = SettingsManager.getInstance();
	
	private final static String statTag = "totalGlobalDeaths";
	
	@Override
	public void broadcastStatMessage() {
		Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA  +  "" + ChatColor.BOLD + "As a community, we've died " +
				ChatColor.GOLD  +  "" + ChatColor.BOLD + settings.getData().getInt("stats." + statTag) + 
				ChatColor.DARK_AQUA  +  "" + ChatColor.BOLD + " times. We're pretty bad at this game.");
	}
	
	@Override
	public void initConfig() {
		if(settings.getData().isSet("stats." + getStatTag()) == false){
			settings.getData().set("stats." + getStatTag(), 0);
			settings.saveData();
		}
		return;
	}
	
	public String getStatTag() {
		return statTag;
	}
	
	public static void incrementGlobalDeathCount(){
		settings.getData().set("stats." + statTag, settings.getData().getInt("stats." + statTag) + 1);
		settings.saveData();
	}
}
