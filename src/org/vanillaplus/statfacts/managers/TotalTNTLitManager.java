package org.vanillaplus.statfacts.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class TotalTNTLitManager extends Stat{
	static SettingsManager settings = SettingsManager.getInstance();

	private final static String pyroTag = "pyromaniac";
	
	
	@Override
	public void broadcastStatMessage(){
		Bukkit.getServer().broadcastMessage(ChatColor.GOLD  +  "" + ChatColor.BOLD + settings.getData().get("stats." + getPyroTag()) + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + " is a pyromaniac, lighting " + ChatColor.GOLD  +  "" + ChatColor.BOLD + settings.getData().getInt("stats.TNTLit." + settings.getData().getString("stats." + pyroTag)) +  " TNT.");
	}
	
	@Override
	public void initBroadcastingList(){
		BroadcastingManager.putStat(this);
	}
	
	public void initConfig(){
		if(settings.getData().isSet("stats." + getPyroTag()) == false){
			settings.getData().set("stats." + getPyroTag(), "Nobody");
			settings.saveData();
		}
		return;
	}
	
	public String getPyroTag(){
		return pyroTag;
	}
		
	public static void updateTNTStat(String pName)
	{
		if(settings.getData().isSet("stats.TNTLit." + pName))
		{
			settings.getData().set("stats.TNTLit." + pName, settings.getData().getInt("stats.TNTLit." + pName) + 1);
		}
		else
		{
			settings.getData().set("stats.TNTLit." + pName, 1);
		}
		settings.saveData();
	}
	
	public static void updatePyromaniac(String pName)
	{
		if(settings.getData().getString("stats." + pyroTag).equals("Nobody"))
		{
			settings.getData().set("stats." + pyroTag, pName);
		}
		else if(settings.getData().getInt("stats.TNTLit." + settings.getData().getString("stats." + pyroTag)) < settings.getData().getInt("stats.TNTLit." + pName))
		{
			settings.getData().set("stats." + pyroTag, pName);
			settings.saveData();
		}
	}
}

