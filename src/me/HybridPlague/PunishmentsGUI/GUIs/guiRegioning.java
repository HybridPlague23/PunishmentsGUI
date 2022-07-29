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
import me.HybridPlague.PunishmentsGUI.SubMenus.regioning.regioningPortals;

public class guiRegioning {

	private Main plugin;
	public regioningPortals portal;
	
	public guiRegioning(Main plugin) {
		this.plugin = plugin;
		this.portal = new regioningPortals(plugin);
	}
	
	public Inventory regioningMenu;

	public void openRegioningMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		regioningMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lRegioning Rules > &f" + t.getName()));
		plugin.invs.add(regioningMenu);
		p.openInventory(regioningMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			regioningMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		regioningMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		regioningMenu.setItem(32, item);
		
		/*
		 * CATEGORY
		 */
		item.setType(Material.END_PORTAL_FRAME);
		meta.setDisplayName(ChatColor.YELLOW + "Portal/Monument Regioning");
		item.setItemMeta(meta);
		regioningMenu.setItem(13, item);
		
	}
	
}
