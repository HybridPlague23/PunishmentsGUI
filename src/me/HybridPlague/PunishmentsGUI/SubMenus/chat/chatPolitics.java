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

public class chatPolitics {

	private Main plugin;
	public chatPolitics(Main plugin) {
		this.plugin = plugin;
	}
	
	public Inventory politicsSubMenu;
	
	public void openPoliticsSubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		politicsSubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Politics) > &f" + t.getName()));
		plugin.invs.add(politicsSubMenu);
		p.openInventory(politicsSubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			politicsSubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		politicsSubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		politicsSubMenu.setItem(32, item);
		
		item.setType(Material.GREEN_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "First Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " Discussing IRL Politics/"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fControversial Topics (1st)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		politicsSubMenu.setItem(11, item);
		lore.clear();
		
		item.setType(Material.LIME_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Second Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " Discussing IRL Politics/"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fControversial Topics (2nd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempmute " + t.getName() + " 10m Discussing IRL Politics/"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fControversial Topics (2nd)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		politicsSubMenu.setItem(12, item);
		lore.clear();
		
		item.setType(Material.YELLOW_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Third Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Discussing IRL Politics/"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fControversial Topics (3rd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempmute " + t.getName() + " 30m Discussing IRL Politics/"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fControversial Topics (3rd)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		politicsSubMenu.setItem(13, item);
		lore.clear();
		
		item.setType(Material.ORANGE_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Fourth Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Discussing IRL Politics/"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fControversial Topics (4th)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 2d Discussing IRL Politics/"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fControversial Topics (4th)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		politicsSubMenu.setItem(14, item);
		lore.clear();
		
		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Fifth Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Discussing IRL Politics/"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fControversial Topics (5th)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 1w Discussing IRL Politics/"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fControversial Topics (5th)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		politicsSubMenu.setItem(15, item);
		lore.clear();
		
		
	}

}
