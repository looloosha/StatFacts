package org.vanillaplus.statfacts.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.painting.PaintingPlaceEvent;
import org.vanillaplus.statfacts.managers.PaintingsPlacedManager;

@SuppressWarnings("deprecation")
public class PaintingPlacedListener implements Listener{
	
	@EventHandler
	public void onPaintingPlacedEvent(PaintingPlaceEvent e)
	{
		PaintingsPlacedManager.incrementPaintingCount();
	}
}
