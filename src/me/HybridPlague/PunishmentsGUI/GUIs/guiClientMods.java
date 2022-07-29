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
import me.HybridPlague.PunishmentsGUI.SubMenus.mods.modsOther;
import me.HybridPlague.PunishmentsGUI.SubMenus.mods.modsXray;

public class guiClientMods {

	private Main plugin;
	public modsXray xray;
	public modsOther other;
	
	
	public guiClientMods(Main plugin) {
		this.plugin = plugin;
		this.xray = new modsXray(plugin);
		this.other = new modsOther(plugin);
	}
	
	public Inventory clientMenu;
	
	public void openClientMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		clientMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lClient Mods > &f" + t.getName()));
		plugin.invs.add(clientMenu);
		p.openInventory(clientMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			clientMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		clientMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		clientMenu.setItem(32, item);
		
		/*
		 * SUB-CATEGORIES
		 */
		  /*
		   * Xray
		   */
		item.setType(Material.DIAMOND_ORE);
		meta.setDisplayName(ChatColor.YELLOW + "X-ray");
		item.setItemMeta(meta);
		clientMenu.setItem(11, item);
		
		  /*
		   * Other
		   */
		item.setType(Material.NETHERITE_SWORD);
		meta.setDisplayName(ChatColor.YELLOW + "Other Mods");
		item.setItemMeta(meta);
		clientMenu.setItem(15, item);
		
	}

}
