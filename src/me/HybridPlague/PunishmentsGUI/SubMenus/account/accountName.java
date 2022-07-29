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

public class accountName {

	private Main plugin;
	public accountName(Main plugin) {
		this.plugin = plugin;
	}

	public Inventory nameSubMenu;

	public void openNameSubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		nameSubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lAccount Rules (Name) > &f" + t.getName()));
		plugin.invs.add(nameSubMenu);
		p.openInventory(nameSubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) { // Background
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			nameSubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		nameSubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		nameSubMenu.setItem(32, item);
		
		/*
		 * OFFENCES
		 */
		item.setType(Material.NAME_TAG);
		meta.setDisplayName(ChatColor.YELLOW + "Inappropriate Name");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6No prompts."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/ban " + Bukkit.getOfflinePlayer(plugin.targeted.get(p)).getName() + " Your name was found inappropriate."));
		lore.add(ChatColor.WHITE + "    Please appeal on the forums when your ");
		lore.add(ChatColor.WHITE + "    name has been changed to something more appropriate.");
		meta.setLore(lore);
		item.setItemMeta(meta);
		nameSubMenu.setItem(11, item);
		lore.clear();

		item.setType(Material.NAME_TAG);
		meta.setDisplayName(ChatColor.YELLOW + "Similar Name");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6No prompts."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/ban " + Bukkit.getOfflinePlayer(plugin.targeted.get(p)).getName() + " Your name was found too similar"));
		lore.add(ChatColor.WHITE + "    to someone else's. Please appeal on the forums");
		lore.add(ChatColor.WHITE + "    when your name has been changed to something else.");
		meta.setLore(lore);
		item.setItemMeta(meta);
		nameSubMenu.setItem(15, item);
		lore.clear();
	}
	
}
