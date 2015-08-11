package org.vanillaplus.statfacts.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class MostPlayersKilledManager extends Stat{
	
	private final static String statTag = "mostPlayersKilled";
	
	public static void updatePlayerPVPerStat(String pName) {
		if(settings.getData().getString("stats." + statTag + ".PVPer") == "Nobody") {
			settings.getData().set("stats." + statTag + ".PVPer", pName);
			
			settings.getData().set("stats." + statTag + ".playerCount." + pName, 1);
			settings.saveData();
			return;
		}
		
		if(settings.getData().getString("stats." + statTag + ".PVPer") != "Nobody") {
			if(!settings.getData().isSet("stats." + statTag + ".playerCount." + pName)) {
				settings.getData().set("stats." + statTag + ".playerCount." + pName, 1);
				settings.saveData();
				return;
			}
			
			settings.getData().set("stats." + statTag + ".playerCount." + pName, settings.getData().getInt("stats." + statTag + ".playerCount." + pName) + 1);
			settings.saveData();
			
			if(settings.getData().getInt("stats." + statTag + ".playerCount." + pName) > 
			settings.getData().getInt("stats." + statTag + ".playerCount." + 
			settings.getData().getString("stats." + statTag + ".PVPer"))) {
				settings.getData().set("stats." + statTag + ".PVPer", pName);
				settings.saveData();
			}
		}
		settings.saveData();
	}
	
	@Override
	public void broadcastStatMessage() {
		String pName = settings.getData().getString("stats." + statTag + ".PVPer");
		
		Bukkit.getServer().broadcastMessage(ChatColor.GOLD  +  "" + ChatColor.BOLD + pName +
				ChatColor.DARK_AQUA  +  "" + ChatColor.BOLD + " has the most player kills, recking " +
				ChatColor.GOLD  +  "" + ChatColor.BOLD + settings.getData().getInt("stats." + statTag + ".playerCount." + pName) +
				ChatColor.DARK_AQUA  +  "" + ChatColor.BOLD + " of you nubs.");
	}
	
	public void initConfig() {
		if(settings.getData().isSet("stats." + getStatTag()) == false){
			settings.getData().set("stats." + getStatTag() + ".PVPer", "Nobody");
			settings.getData().set("stats." + getStatTag() + ".playerCount", null);
			settings.saveData();
		}
		return;
	}
	
	@Override
	public void initBroadcastingList(){
		BroadcastingManager.putStat(this);
	}
	
	public String getStatTag() {
		return statTag;
	}
}
