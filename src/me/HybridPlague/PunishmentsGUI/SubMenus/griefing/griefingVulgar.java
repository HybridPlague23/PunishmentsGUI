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

public class griefingVulgar {

	private Main plugin;
	public griefingVulgar(Main plugin) {
		this.plugin = plugin;
	}

	public Inventory vulgarSubMenu;
	
	public void openVulgarSubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		vulgarSubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lGriefing Rules (Vulgar) > &f" + t.getName()));
		plugin.invs.add(vulgarSubMenu);
		p.openInventory(vulgarSubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			vulgarSubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		vulgarSubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		vulgarSubMenu.setItem(32, item);
		
		item.setType(Material.GREEN_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "First Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c? &f/warn " + t.getName() + " Vulgar Build (1st)"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		vulgarSubMenu.setItem(11, item);
		lore.clear();
		
		item.setType(Material.LIME_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Second Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c? &f/warn " + t.getName() + " Vulgar Build (2nd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c? &f/fee " + t.getName() + " 500"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		vulgarSubMenu.setItem(12, item);
		lore.clear();
		
		item.setType(Material.ORANGE_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Third Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c? &f/warn " + t.getName() + " Vulgar Build (3rd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c? &f/tempban " + t.getName() + " 1d Vulgar Build (3rd)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c? &f/fee " + t.getName() + " 500"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		vulgarSubMenu.setItem(14, item);
		lore.clear();
		
		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Fourth Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c? &f/warn " + t.getName() + " -p 2 Vulgar Build (4th)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c? &f/tempban " + t.getName() + " 1w Vulgar Build (4th)"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c? &f/fee " + t.getName() + " 500"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		vulgarSubMenu.setItem(15, item);
		lore.clear();
		
	}
	
	
}
