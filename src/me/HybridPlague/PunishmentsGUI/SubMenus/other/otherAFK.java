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

public class otherAFK {

	private Main plugin;
	public otherAFK(Main plugin) {
		this.plugin = plugin;
	}

	public Inventory afkSubMenu;
	
	public void openAFKSubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		afkSubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (AFK) > &f" + t.getName()));
		plugin.invs.add(afkSubMenu);
		p.openInventory(afkSubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			afkSubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		afkSubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		afkSubMenu.setItem(32, item);
		
		item.setType(Material.GREEN_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "First Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fHow many Krunas were obtained during AFK"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oIf unsure, type &f&oNone&7."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " AFK-Kick Advoiding (1st)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 500"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		afkSubMenu.setItem(11, item);
		lore.clear();
		
		item.setType(Material.YELLOW_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Second Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fHow many Krunas were obtained during AFK"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oIf unsure, type &f&oNone&7."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " AFK-Kick Advoiding (2nd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 1w AFK-Kick Advoiding (2nd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 1000"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		afkSubMenu.setItem(13, item);
		lore.clear();
		
		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Third Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fHow many Krunas were obtained during AFK"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oIf unsure, type &f&oNone&7."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/ban " + t.getName() + " AFK-Kick Advoiding (3rd)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		afkSubMenu.setItem(15, item);
		lore.clear();
		
	}
	
}
