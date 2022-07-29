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

public class otherTicketAbuse {

	private Main plugin;
	public otherTicketAbuse(Main plugin) {
		this.plugin = plugin;
	}

	public Inventory ticketabuseSubMenu;
	
	public void openTicketAbuseSubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		ticketabuseSubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (Tickets) > &f" + t.getName()));
		plugin.invs.add(ticketabuseSubMenu);
		p.openInventory(ticketabuseSubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			ticketabuseSubMenu.setItem(i, item);
		}
		
		/*
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		ticketabuseSubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		ticketabuseSubMenu.setItem(32, item);
		
		item.setType(Material.GREEN_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "First Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " Ticket Abuse (1st)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		ticketabuseSubMenu.setItem(11, item);
		lore.clear();
		
		item.setType(Material.LIME_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Second Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Ticket Abuse (2nd)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		ticketabuseSubMenu.setItem(12, item);
		lore.clear();
		
		item.setType(Material.ORANGE_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Third Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Ticket Abuse (3rd)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		ticketabuseSubMenu.setItem(14, item);
		lore.clear();
		
		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Fourth Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Ticket Abuse (4th)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 3d Ticket Abuse (4th)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		ticketabuseSubMenu.setItem(15, item);
		lore.clear();
		
	}
	
}
