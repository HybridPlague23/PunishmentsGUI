package me.HybridPlague.PunishmentsGUI.SubMenus.mods;

import java.util.ArrayList;
import java.util.List;
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

public class modsXray {

	private Main plugin;
	public modsXray(Main plugin) {
		this.plugin = plugin;
	}

	public Inventory xraySubMenu;
	
	public void openXraySubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		xraySubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lClient Mods (X-ray) > &f" + t.getName()));
		plugin.invs.add(xraySubMenu);
		p.openInventory(xraySubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			xraySubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		xraySubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		xraySubMenu.setItem(32, item);
		
		/*
		 * OFFENCES
		 */
		  /*
		   * FIRST
		   */
		item.setType(Material.LIME_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "First Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 2d X-ray First Offence"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 200"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 4 X-ray First Offence"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fRemoves all ores if player is ONLINE"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		xraySubMenu.setItem(11, item);
		lore.clear();
		
		  /*
		   * SECOND
		   */
		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Second Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/ban " + t.getName() + " X-ray Second Offence"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fRemoves all ores if player is ONLINE"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		xraySubMenu.setItem(15, item);
		lore.clear();
	}
	
}
