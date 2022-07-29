package me.HybridPlague.PunishmentsGUI.SubMenus.chat;

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

public class chatProfanity {

	private Main plugin;
	public chatProfanity(Main plugin) {
		this.plugin = plugin;
	}
	
	public Inventory profanitySubMenu;
	
	public void openProfanitySubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		profanitySubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Profanity) > &f" + t.getName()));
		plugin.invs.add(profanitySubMenu);
		p.openInventory(profanitySubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			profanitySubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		profanitySubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		profanitySubMenu.setItem(32, item);
		
		item.setType(Material.GREEN_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "First Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " Profanity (1st)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempmute " + t.getName() + " 5m Profanity (1st)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		profanitySubMenu.setItem(11, item);
		lore.clear();
		
		item.setType(Material.LIME_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Second Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " Profanity (2nd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempmute " + t.getName() + " 15m Profanity (2nd)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		profanitySubMenu.setItem(12, item);
		lore.clear();
		
		item.setType(Material.YELLOW_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Third Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " Profanity (3rd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempmute " + t.getName() + " 2h Profanity (3rd)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		profanitySubMenu.setItem(13, item);
		lore.clear();
		
		item.setType(Material.ORANGE_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Fourth Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Profanity (4th)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 3d Profanity (4th)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		profanitySubMenu.setItem(14, item);
		lore.clear();
		
		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Fifth Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Profanity (5th)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 1w Profanity (5th)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		profanitySubMenu.setItem(15, item);
		lore.clear();
		
	}

}
