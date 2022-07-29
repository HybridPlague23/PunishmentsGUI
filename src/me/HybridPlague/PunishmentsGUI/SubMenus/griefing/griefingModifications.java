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

public class griefingModifications {

	private Main plugin;
	public griefingModifications(Main plugin) {
		this.plugin = plugin;
	}

	public Inventory modificationsSubMenu;
	
	public void openModificationsSubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		modificationsSubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lGriefing Rules (Modifications) > &f" + t.getName()));
		plugin.invs.add(modificationsSubMenu);
		p.openInventory(modificationsSubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			modificationsSubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		modificationsSubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		modificationsSubMenu.setItem(32, item);
		
		item.setType(Material.GREEN_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Stage A (1-50 Blocks)");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME of the griefing"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oIf griefed area is Government owned,"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oUse &f&oBusinessCraftGov&7."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " Griefing Stage A"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 1d Griefing Stage A"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 100"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 100"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		modificationsSubMenu.setItem(11, item);
		lore.clear();
		
		item.setType(Material.YELLOW_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Stage B (51-100 Blocks)");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME of the griefing"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oIf griefed area is Government owned,"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oUse &f&oBusinessCraftGov&7."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " Griefing Stage B"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 1w Griefing Stage B"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 150"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 150"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		modificationsSubMenu.setItem(13, item);
		lore.clear();
		
		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "Stage C (101+ Blocks)");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fVictim's USERNAME of the griefing"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oIf griefed area is Government owned,"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "      &7&oUse &f&oBusinessCraftGov&7."));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/warn " + t.getName() + " Griefing Stage C"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/tempban " + t.getName() + " 2w Griefing Stage C"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " 200"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/unfee <INPUT> 200"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		modificationsSubMenu.setItem(15, item);
		lore.clear();
	}
	
	
}
