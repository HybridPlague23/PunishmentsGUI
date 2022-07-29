package me.HybridPlague.PunishmentsGUI.SubMenus.griefing;

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

public class griefingDestruction {

	private Main plugin;
	public griefingDestruction(Main plugin) {
		this.plugin = plugin;
	}
	
	public Inventory destructionSubMenu;

	public void openDestructionSubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		destructionSubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lGriefing Rules (Destruction) > &f" + t.getName()));
		plugin.invs.add(destructionSubMenu);
		p.openInventory(destructionSubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			destructionSubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		destructionSubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		destructionSubMenu.setItem(32, item);
		
		item.setType(Material.GREEN_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "First Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME of the destruction"));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " Using Items to cause"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fDestruction (1st)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 250"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 250"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		destructionSubMenu.setItem(11, item);
		lore.clear();
		
		item.setType(Material.LIME_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Second Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME of the destruction"));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " Using Items to cause"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fDestruction (2nd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 1d Using Items to cause"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fDestruction (2nd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 500"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 500"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		destructionSubMenu.setItem(12, item);
		lore.clear();
		
		item.setType(Material.ORANGE_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Third Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME of the destruction"));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Using Items to cause"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fDestruction (3rd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 1w Using Items to cause"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fDestruction (3rd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 750"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 750"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		destructionSubMenu.setItem(14, item);
		lore.clear();
		
		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Fourth Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME of the destruction"));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Using Items to cause"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fDestruction (4th)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 2w Using Items to cause"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fDestruction (4th)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 1000"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 1000"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		destructionSubMenu.setItem(15, item);
		lore.clear();
		
	}
	
}
