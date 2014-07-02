package me.surferdude999.experiment;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent e) {
		Player p = (Player) e.getPlayer();
		e.getRightClicked().setPassenger(p);
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (p.isInsideVehicle()) {
			if (p.getVehicle().getType() == EntityType.MINECART) {
				Minecart mc = (Minecart) p.getVehicle();
				mc.setVelocity(p.getEyeLocation().getDirection());
			}
		}
			
	}
	
	@EventHandler
	public void onPlayerInteractEntityEvent1(PlayerInteractEntityEvent e) {
				Player p = (Player) e.getPlayer();
				if (e.getRightClicked() instanceof Minecart) {
					if (p.hasPermission("mc.ride"))
					p.setPassenger(e.getRightClicked());
				} else {
					p.sendMessage(ChatColor.RED + "You must donate for this perk!");
					e.getRightClicked().remove();
				}
 			}
	}
	

