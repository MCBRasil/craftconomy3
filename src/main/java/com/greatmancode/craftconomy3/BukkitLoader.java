package com.greatmancode.craftconomy3;

import org.bukkit.plugin.java.JavaPlugin;

public class BukkitLoader extends JavaPlugin {

	private static BukkitLoader instance = null;
	public void onEnable() {
		instance = this;
		new Common(true,getLogger());
	}
	
	public void onDisable() {
		
	}
	
	public static BukkitLoader getInstance() {
		return instance;
	}
}
