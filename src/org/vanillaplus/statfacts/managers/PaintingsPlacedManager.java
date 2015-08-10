package org.vanillaplus.statfacts.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class PaintingsPlacedManager extends Stat{
	
	static SettingsManager settings = SettingsManager.getInstance();
	
	private final static String statTag = "totalPaintingsPlaced";
	
	@Override
	public void broadcastStatMessage(){
		Bukkit.getServer().broadcastMessage(ChatColor.GOLD  +  "" + ChatColor.BOLD + settings.getData().get("stats." + getStatTag()) + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + " paintings have been painted");
	}
	public void initBroadcastingList(){
		BroadcastingManager.putStat(this);
	}
		
	@Override
	public void initConfig() {
		if(settings.getData().isSet("stats." + getStatTag()) == false)
		{
			settings.getData().set("stats." + getStatTag(), 0);;
			settings.saveData();
		}
	}
	
	public String getStatTag(){
		return statTag;
	}
	
	public static void incrementPaintingCount(){
		settings.getData().set("stats." + statTag,  settings.getData().getInt("stats." + statTag) + 1);
		settings.saveData();
	}
	
}
