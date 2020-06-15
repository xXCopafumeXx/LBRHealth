package ru.lbrhealth.xxcopafumexx.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CommandClass implements CommandExecutor {

	private Main plugin;

	public CommandClass(Main plugin) {
		this.plugin = plugin;
	}
	
 
	@SuppressWarnings("static-access")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if (!sender.hasPermission("LBRHealth.flow")) {
			sender.sendMessage(plugin.PREFIX + " §cУ вас нету прав!");
			return false;
		}
		if (args.length < 1) {
			sender.sendMessage(plugin.PREFIX + " §cВведите аргументы!");
			return false;
		}

		switch (args[0]) {
		case "stop":

			if (!Main.task.isCancelled()) {
				Main.task.cancel();
				
				sender.sendMessage(plugin.PREFIX + " §2Поток отключен!");
				return true;
			} else {
				sender.sendMessage(plugin.PREFIX + " §cПоток уже отключен!");
				return false;
			}
			
		case "start":

			if (Main.task.isCancelled()) {
				
				Main.task  = new RunTaskClass(plugin).runTaskTimerAsynchronously(plugin, 0, plugin.getConfig().getInt("Delay"));
				
				
				sender.sendMessage(plugin.PREFIX + " §2Поток включен!");
				return true;
			} else {
				sender.sendMessage(plugin.PREFIX + " §cПоток уже включен!");
				return false;
			}
		case "reload":
			plugin.reloadConfig();
			sender.sendMessage(plugin.PREFIX + " §2Файл конфигурации перезагружен!");
			return true;
		default:
			sender.sendMessage(plugin.PREFIX + " §cАргумента не существует!");
			return false;
		}

	}

}
