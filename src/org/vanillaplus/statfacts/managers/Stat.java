package org.vanillaplus.statfacts.managers;

public class Stat {
	
	static SettingsManager settings = SettingsManager.getInstance();
	
	private final static String statTag = "";
	
	public void broadcastStatMessage() {
		//Broadcast stat message here.
	}
	
	public void initBroadcastingList() {
		BroadcastingManager.putStat(this);
	}
	
	public void initConfig() {
		//Make the ConfigurationSection for the stat and initialize the stats defaults values.
		//See TotalZombiesKilledManager for an example.
	}
	
	
	public String getStatTag() {
		return statTag;
	}
	
}
