package com.jennings.rpgsystem;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

public class ItemCleaner extends BukkitRunnable {
	public Integer step = 1;
	
	@Override
	public void run() {
		if (step < 9) {
			step += 1;
		} else if (step == 9) {
			step += 1;
			Bukkit.getServer().broadcastMessage("Clearing all floor items older than 10 minutes in 1 minute!");
		} else if (step == 10) {
			Integer icleared = 0;
			List<Entity> entities = Bukkit.getWorld("world").getEntities();
			for (Entity entity : entities) {
				if (entity.getTicksLived() > 12000 && entity.getType().equals(EntityType.DROPPED_ITEM)) {
					entity.remove();
					icleared += 1;
				}
			}
			Bukkit.getServer().broadcastMessage(icleared.toString() + " floor items cleared!");
			step = 1;
		} else {
			step = 1;
		}
	}
}
