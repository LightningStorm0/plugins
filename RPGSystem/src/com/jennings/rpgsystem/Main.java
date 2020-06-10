package com.jennings.rpgsystem;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	ItemCleaner itemCleaner = new ItemCleaner();
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new EntityHealthBars(), this);
		getServer().getPluginManager().registerEvents(new ArrowHit(), this);

		itemCleaner.runTaskTimer(this, 0, 1200);
	}
	
	@Override
	public void onDisable() {
		
	}
}
