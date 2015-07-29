package org.vanillaplus.statfacts.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BroadcastingManager {
	
	static List<Stat> stats = new ArrayList<Stat>();
	
	//Adds a stat to the "stats" List
	public static void putStat(Stat s) {
		stats.add(s);
	}
	
	
	//Gets a random Stat in the "stats" List
	public static Stat getRandomStat() {
		Random rand = new Random();
		int index = rand.nextInt(stats.size());

		return stats.get(index);
	}
	
	
	//Broadcasts a random Stats message
	public static void broadcastRandomStatMessage() {
		getRandomStat().broadcastStatMessage();
	}
	
}
