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

public class accountCompromised {

	private Main plugin;
	public accountCompromised(Main plugin) {
		this.plugin = plugin;
	}
	public Inventory compSubMenu;

	public void openCompSubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		compSubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lAccount Rules (Comp) > &f" + t.getName()));
		plugin.invs.add(compSubMenu);
		p.openInventory(compSubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) { // Background
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			compSubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		compSubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		compSubMenu.setItem(32, item);
		
		/*
		 * OFFENCES
		 */
		item.setType(Material.LIME_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "First Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fName of OTHER account"));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7&oIf no other account is known, respond with &f&lNone"));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn <MAIN> -p 2 Sharing/Compromised Accounts"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn <OTHER> -p 2 Sharing/Compromised Accounts"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		compSubMenu.setItem(11, item);
		lore.clear();
		

		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Second Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fName of ALT account"));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7&oIf no alt account is known, respond with &f&lNone"));
		lore.add("");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/ban <MAIN> Sharing/Compromised Accounts"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/ban <OTHER> Sharing/Compromised Accounts"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		compSubMenu.setItem(15, item);
		lore.clear();
	}
	
}
