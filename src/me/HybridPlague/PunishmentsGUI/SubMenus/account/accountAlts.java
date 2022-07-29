package me.HybridPlague.PunishmentsGUI.SubMenus.account;

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

public class accountAlts {

	private Main plugin;
	public accountAlts(Main plugin) {
		this.plugin = plugin;
	}
	
	public Inventory altSubMenu;

	public void openAltSubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		altSubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lAccount Rules (Alts) > &f" + t.getName()));
		plugin.invs.add(altSubMenu);
		p.openInventory(altSubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) { // Background
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			altSubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		altSubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		altSubMenu.setItem(32, item);
		
		/*
		 * OFFENCES
		 */
		item.setType(Material.LIME_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "First Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6No prompts"));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/ban " + t.getName() + " Alt Account"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		altSubMenu.setItem(11, item);
		lore.clear();

		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Second Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6No prompts."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/ban " + t.getName() + " Alt Account"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/banip " + t.getName() + " Multiple Alt Accounts"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		altSubMenu.setItem(15, item);
		lore.clear();
		
	}
	
}
