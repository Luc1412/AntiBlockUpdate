package de.luc1412.abu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiBlockUpdate extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);

		Bukkit.getConsoleSender().sendMessage("§8[" + this.getDescription().getName() + "§8] §2§lThe Plugin was successfully enabled!");
	}

	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§8[" + this.getDescription().getName() + "§8] §2§lThe Plugin was successfully disabled!");
	}

	@EventHandler(priority = EventPriority.LOW)
	public void onBlockChange(BlockPhysicsEvent event) {
		try {
			Block block = event.getBlock();

			if (block != null) {
				if (block.getType() != null) {
					if (block.getType() == Material.LEAVES |
							block.getType() == Material.LEAVES_2 |
							block.getType() == Material.RED_ROSE |
							block.getType() == Material.DOUBLE_PLANT |
							block.getType() == Material.GRASS |
							block.getType() == Material.LONG_GRASS |
							block.getType() == Material.YELLOW_FLOWER) {
						event.setCancelled(true);
					}
				}
			}
		} catch (Exception ex) {
			Bukkit.getConsoleSender().sendMessage("§8[" + this.getDescription().getName() + "§8] §4§lAn error occurred while running the plugin. Please notify the developer!");
		}
	}
}
