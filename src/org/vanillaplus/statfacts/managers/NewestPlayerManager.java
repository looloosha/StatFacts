package org.vanillaplus.statfacts.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class NewestPlayerManager extends Stat{
	static SettingsManager settings = SettingsManager.getInstance();
	
	private final static String statTag = "newestPlayer";
	
	public static void setNewestPlayer(String name) {
		settings.getData().set("stats." + statTag, name);
	}
	
	@Override
	public void broadcastStatMessage() {
		Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA  +  "" 
				+ ChatColor.BOLD + "Make sure everyone welcomes " + ChatColor.GOLD  
				+  "" + ChatColor.BOLD + settings.getData().getString("stats." + getStatTag()) 
				+ ChatColor.DARK_AQUA  +  "" + ChatColor.BOLD 
				+ ", they are the newest member to VanillaPlus!");
	}
	
	@Override
	public void initBroadcastingList(){
		BroadcastingManager.putStat(this);
	}
	
	@Override
	public void initConfig() {
		if(settings.getData().isSet("stats." + getStatTag()) == false){
			settings.getData().set("stats." + getStatTag(), "nobody");
			settings.saveData();
		}
		return;
	}
	
	public String getStatTag() {
		return statTag;
	}
	
	
}
