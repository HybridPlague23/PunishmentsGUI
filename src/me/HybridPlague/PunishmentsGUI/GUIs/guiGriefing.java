package me.HybridPlague.PunishmentsGUI.GUIs;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.HybridPlague.PunishmentsGUI.Main;
import me.HybridPlague.PunishmentsGUI.SubMenus.griefing.griefingDestruction;
import me.HybridPlague.PunishmentsGUI.SubMenus.griefing.griefingLocking;
import me.HybridPlague.PunishmentsGUI.SubMenus.griefing.griefingModifications;
import me.HybridPlague.PunishmentsGUI.SubMenus.griefing.griefingStealing;
import me.HybridPlague.PunishmentsGUI.SubMenus.griefing.griefingVulgar;

public class guiGriefing {

	private Main plugin;
	public griefingDestruction destruction;
	public griefingLocking locking;
	public griefingModifications modifications;
	public griefingStealing stealing;
	public griefingVulgar vulgar;
	
	public guiGriefing(Main plugin) {
		this.plugin = plugin;
		this.destruction = new griefingDestruction(plugin);
		this.locking = new griefingLocking(plugin);
		this.modifications = new griefingModifications(plugin);
		this.stealing = new griefingStealing(plugin);
		this.vulgar = new griefingVulgar(plugin);
	}
	
	public Inventory griefingMenu;
	
	public void openGriefingMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		griefingMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lGriefing Rules > &f" + t.getName()));
		plugin.invs.add(griefingMenu);
		p.openInventory(griefingMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		
		for (int i = 0; i < 36; i++) { // Background
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			griefingMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		griefingMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		griefingMenu.setItem(32, item);
		
		/*
		 * SUB-CATEGORIES
		 */
		  /*
		   * VULGAR
		   */
		item.setType(Material.REDSTONE);
		meta.setDisplayName(ChatColor.YELLOW + "Vulgar Builds");
		item.setItemMeta(meta);
		griefingMenu.setItem(11, item);
		  /*
		   * STEALING
		   */
		item.setType(Material.CHEST);
		meta.setDisplayName(ChatColor.YELLOW + "Stealing");
		item.setItemMeta(meta);
		griefingMenu.setItem(12, item);
		  /*
		   * DESTRUCTION
		   */
		item.setType(Material.TNT);
		meta.setDisplayName(ChatColor.YELLOW + "Using Items to cause Destruction");
		item.setItemMeta(meta);
		griefingMenu.setItem(13, item);
		  /*
		   * LOCKING
		   */
		item.setType(Material.TRIPWIRE_HOOK);
		meta.setDisplayName(ChatColor.YELLOW + "Locking");
		item.setItemMeta(meta);
		griefingMenu.setItem(14, item);
		  /*
		   * MODIFICATIONS
		   */
		item.setType(Material.NETHERITE_AXE);
		meta.setDisplayName(ChatColor.YELLOW + "Building Modifications");
		item.setItemMeta(meta);
		griefingMenu.setItem(15, item);
	}

}
