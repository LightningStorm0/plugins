package com.jennings.rpgsystem;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntityHealthBars implements Listener{
	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent event) {
		if (event.getEntity() instanceof LivingEntity) {
			LivingEntity entity = (LivingEntity) event.getEntity();
			
			setHealthBar(entity, 0.0);
		}
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof LivingEntity) {
			LivingEntity entity = (LivingEntity) event.getEntity();
			setHealthBar(entity, -event.getDamage());
		}
	}
	
	@EventHandler
	public void onEntityRegainHealthEvent(EntityRegainHealthEvent event) {
		if (event.getEntity() instanceof LivingEntity) {
			LivingEntity entity = (LivingEntity) event.getEntity();
			setHealthBar(entity, event.getAmount());
		}
	}
	
	public void setHealthBar(LivingEntity entity, Double change) {
		Double max = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
		Double health = entity.getHealth() + change;
		
		if (health > max) {health = max;}
		if (health <= 0) {health = 0.0;}
		
		Double s = 10/max;
		
		String name = entity.getType().toString();
		
		name += " §f[";
		
		for (int i = 0; i < 5; i++) {
			if (health*s > i) {
				name += "§a|";
			} else {
				name += "§c|";
			}
		}
		
		name += " ";
		
		name += roundToTenth(health);
		
		name += " ";
		
		for (int i = 5; i < 10; i++) {
			if (health*s > i) {
				name += "§a|";
			} else {
				name += "§c|";
			}
		}
		
		name += "§f]";
		
		entity.setCustomName(name);
		entity.setCustomNameVisible(true);
	}
	
	public static double roundToTenth(double d) {
	    return Math.round(d * 10) / 10.0;
	}
}
