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

public class otherSettingHomes {

	private Main plugin;
	
	public otherSettingHomes(Main plugin) {
		this.plugin = plugin;
	}
	
	public Inventory settinghomesSubMenu;
	
	public void openSettingHomesSubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		settinghomesSubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (Homes) > &f" + t.getName()));
		plugin.invs.add(settinghomesSubMenu);
		p.openInventory(settinghomesSubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			settinghomesSubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		settinghomesSubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		settinghomesSubMenu.setItem(32, item);

		item.setType(Material.GREEN_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "First Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fName of home"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oHome names can be found using"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&o/homes " + t.getName() + ":"));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Setting a Home in"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fa Restricted Area (1st)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &7&o(Console) &f/delhome " + t.getName() + ":<INPUT>"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		settinghomesSubMenu.setItem(11, item);
		lore.clear();

		item.setType(Material.LIME_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Second Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fName of home"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oHome names can be found using"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&o/homes " + t.getName() + ":"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oIf area is Government owned,"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&ouse &f&oBusinessCraftGov&7."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Setting a Home in"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fa Restricted Area (2nd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &7&o(Console) &f/delhome " + t.getName() + ":<INPUT>"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 300"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 300"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		settinghomesSubMenu.setItem(12, item);
		lore.clear();

		item.setType(Material.ORANGE_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Third Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fName of home"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oHome names can be found using"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&o/homes " + t.getName() + ":"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oIf area is Government owned,"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&ouse &f&oBusinessCraftGov&7."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Setting a Home in"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fa Restricted Area (3rd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 3d Setting a Home in"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fa Restricted Area (3rd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &7&o(Console) &f/delhome " + t.getName() + ":<INPUT>"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 300"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 300"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		settinghomesSubMenu.setItem(14, item);
		lore.clear();

		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Fourth Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fName of home"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oHome names can be found using"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&o/homes " + t.getName() + ":"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oIf area is Government owned,"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&ouse &f&oBusinessCraftGov&7."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " -p 2 Setting a Home in"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fa Restricted Area (4th)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 1w Setting a Home in"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &fa Restricted Area (4th)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &7&o(Console) &f/delhome " + t.getName() + ":<INPUT>"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 300"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 300"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		settinghomesSubMenu.setItem(15, item);
		lore.clear();
		
	}

}
