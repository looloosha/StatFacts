package org.vanillaplus.statfacts.tasks;

import org.bukkit.scheduler.BukkitRunnable;
import org.vanillaplus.statfacts.managers.BroadcastingManager;

public class BroadcastTask extends BukkitRunnable{

	@Override
	public void run() {
		BroadcastingManager.broadcastRandomStatMessage();
	}

}
