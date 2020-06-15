package ru.lbrhealth.xxcopafumexx.main;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;


public class RunTaskClass extends BukkitRunnable {

	private Main plugin;
	
	public RunTaskClass(Main plugin) {
		plugin = this.plugin;
	}

	@Override
	public void run() {
         for(Player p : Bukkit.getOnlinePlayers()) {
        	 p.setHealthScaled(true);
			p.spigot().sendMessage(ChatMessageType.ACTION_BAR,
					TextComponent.fromLegacyText("§4§l❤§r " + (int) p.getHealth() + "/"
							+ (int) p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue()));
         }
         
	}

	
}
