package org.vanillaplus.statfacts.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class TotalZombiesKilledManager extends Stat{

	static SettingsManager settings = SettingsManager.getInstance();
	
	private final static String statTag = "totalZombiesKilled";
	
	@Override
	public void broadcastStatMessage() {
		Bukkit.getServer().broadcastMessage(ChatColor.GOLD  +  "" + ChatColor.BOLD + settings.getData().get("stats." + getStatTag()) + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + " zombies brains have been smashed");
	}
	
	//Must have this method and call it in the initBroadcastingManger method in the StatFacts class.
	@Override
	public void initBroadcastingList(){
		BroadcastingManager.putStat(this);
	}
	
	//Must have this static method and call it in the initConfigSections() method in the StatFacts class.
	@Override
	public void initConfig() {
		if(settings.getData().isSet("stats." + getStatTag()) == false){
			settings.getData().set("stats." + getStatTag(), 0);
			settings.saveData();
		}
		return;
	}
	
	//Must have this static method for general use.
	public String getStatTag() {
		return statTag;
	}

	public static void incrementZombieDeathCount(){
		settings.getData().set("stats." + statTag, settings.getData().getInt("stats." + statTag) + 1);
		settings.saveData();
	}
	
}
