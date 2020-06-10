package com.jennings.rpgsystem;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowHit implements Listener{
	@EventHandler
	public void onProjectileHitEvent(ProjectileHitEvent event) {
		if (event.getHitEntity() != null) {
			Player player = (Player) event.getEntity().getShooter();
			Location loc = player.getLocation();
			
			player.playSound(loc, Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);
		}
		
		event.getEntity().remove();
	}

}
