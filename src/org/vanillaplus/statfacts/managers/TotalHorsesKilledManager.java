package org.vanillaplus.statfacts.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class TotalHorsesKilledManager extends Stat{
	static SettingsManager settings = SettingsManager.getInstance();
	private final static String statTag = "totalHorsesKilled";

	@Override
	public void broadcastStatMessage(){
		Bukkit.getServer().broadcastMessage(ChatColor.GOLD  +  "" + ChatColor.BOLD + settings.getData().get("stats." + getStatTag()) + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + " horses had their throats slit.");
	}
	
	@Override
	public void initBroadcastingList(){
		BroadcastingManager.putStat(this);
	}
	
	public void initConfig() {
		if(settings.getData().isSet("stats." + getStatTag()) == false){
			settings.getData().set("stats." + getStatTag(), 0);
			settings.saveData();
		}
		return;
	}
	public String getStatTag(){
		return statTag;
	}
	
	public static void incrementHorseDeathCount(){
		settings.getData().set("stats." + statTag, settings.getData().getInt("stats." + statTag) + 1);
		settings.saveData();
	}
}
