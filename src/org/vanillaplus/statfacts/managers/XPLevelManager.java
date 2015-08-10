package org.vanillaplus.statfacts.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class XPLevelManager extends Stat {
	
	static SettingsManager settings = SettingsManager.getInstance();
	
	private final static String statTag = "topLevel";
	
	@Override
	public void broadcastStatMessage(){
		Bukkit.getServer().broadcastMessage(ChatColor.GOLD  +  "" + ChatColor.BOLD + settings.getData().get("stats." + getStatTag()) + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + " zombie brains have been smashed");
	}
	
	public String getStatTag() {
		return statTag;
	}
	
	@Override
	public void initConfig() {
		if(settings.getData().isSet("stats." + getStatTag()) == false){
			settings.getData().set("stats." + getStatTag(), "Nobody");
			settings.saveData();
		}
		return;
	}
	
	@Override
	public void initBroadcastingList(){
		BroadcastingManager.putStat(this);
	}
	public int getMaxLevel()
	{
		return settings.getData().getInt("stats.XPLevel." + getStatTag());
	}
	
	public static void incrementMaxXP(String pName, Player p)
	{
		if(settings.getData().isSet("stats.XPLevel." + pName) && settings.getData().getInt("stats.XPLevel." + pName) < p.getLevel())
		{
			settings.getData().set("stats.XPLevel." + pName, settings.getData().getInt("stats.XPLevel." + pName) + 1);
		}
		else
		{
			settings.getData().set("stats.XPLevel." + pName, 1);
		}
	}
	
	public static void updateTopLevel(String pName)
	{
		if(settings.getData().getString("stats." + statTag).equals("Nobodoy"))
		{
			settings.getData().set("stats." + statTag, pName);
		}
		else if(settings.getData().getInt("stats.XPLevel." + settings.getData().getString("stats." + statTag)) < settings.getData().getInt("stats.XPLevel." + pName))
		{
			settings.getData().set("stats." + statTag, pName);
		}
	}
}
