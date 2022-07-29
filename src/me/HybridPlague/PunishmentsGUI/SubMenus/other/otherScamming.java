package me.HybridPlague.PunishmentsGUI.SubMenus.other;

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

public class otherScamming {
	private Main plugin;
	public otherScamming(Main plugin) {
		this.plugin = plugin;
	}
	
	public Inventory scammingSubMenu;
	
	public void openScammingSubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		scammingSubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (Scamming) > &f" + t.getName()));
		plugin.invs.add(scammingSubMenu);
		p.openInventory(scammingSubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			scammingSubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		scammingSubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		scammingSubMenu.setItem(32, item);
		
		item.setType(Material.GREEN_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "First Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 4 Scamming (1st)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 1w Scamming (1st)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		scammingSubMenu.setItem(11, item);
		lore.clear();
		
		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Second Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/ban " + t.getName() + " Scamming (2nd)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		scammingSubMenu.setItem(15, item);
		lore.clear();
		
	}

}
