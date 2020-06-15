package ru.lbrhealth.xxcopafumexx.main;

import java.io.File;

import org.bukkit.command.CommandExecutor;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class Main extends JavaPlugin implements CommandExecutor {

	public static BukkitTask task;
	static String PREFIX = "§2[LBRHealth]";

	@Override
	public void onEnable() {
		File config = new File(getDataFolder() + File.separator + "config.yml");
		if (!config.exists()) {
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
			saveConfig();
			getServer().getConsoleSender().sendMessage(PREFIX + "§eСоздан конфигурационный файл плагина.");

		}
		getCommand("LBRHealth").setExecutor(new CommandClass(this));
		task = new RunTaskClass(this).runTaskTimerAsynchronously(this, 0, getConfig().getInt("Delay"));
		
        getLogger().info(PREFIX + "Плагин запущен!");
	}
	
	@Override
	public void onDisable() {
	    getLogger().info(PREFIX + "Плагин выключен!");
	    reloadConfig();
	}

}
