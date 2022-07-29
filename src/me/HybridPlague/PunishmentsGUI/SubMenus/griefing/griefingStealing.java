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

public class griefingStealing {

	private Main plugin;
	
	public griefingStealing(Main plugin) {
		this.plugin = plugin;
	}

	public Inventory stealingSubMenu;
	
	public void openStealingSubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		stealingSubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lGriefing Rules (Stealing) > &f" + t.getName()));
		plugin.invs.add(stealingSubMenu);
		p.openInventory(stealingSubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			stealingSubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		stealingSubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		stealingSubMenu.setItem(32, item);
		
		item.setType(Material.GREEN_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "First Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME of the griefing"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oIf stolen items are Government owned,"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oUse &f&oBusinessCraftGov&7."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Stealing (1st)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 1d Stealing (1st)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 100"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 100"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		stealingSubMenu.setItem(11, item);
		lore.clear();
		
		item.setType(Material.LIME_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Second Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME of the griefing"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oIf stolen items are Government owned,"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oUse &f&oBusinessCraftGov&7."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Stealing (2nd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 1w Stealing (2nd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 200"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 200"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		stealingSubMenu.setItem(12, item);
		lore.clear();
		
		item.setType(Material.ORANGE_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Third Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME of the griefing"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oIf stolen items are Government owned,"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oUse &f&oBusinessCraftGov&7."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Stealing (3rd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 2w Stealing (3rd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 300"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 300"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		stealingSubMenu.setItem(14, item);
		lore.clear();
		
		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Fourth Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME of the griefing"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oIf stolen items are Government owned,"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oUse &f&oBusinessCraftGov&7."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/ban " + t.getName() + " Stealing (4th)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 400"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 400"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		stealingSubMenu.setItem(15, item);
		lore.clear();
		
	}
	
}
