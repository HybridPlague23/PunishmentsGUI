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

public class chatExams {

	private Main plugin;
	public chatExams(Main plugin) {
		this.plugin = plugin;
	}
	
	public Inventory examsSubMenu;
	
	public void openExamSubMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		examsSubMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Exams) > &f" + t.getName()));
		plugin.invs.add(examsSubMenu);
		p.openInventory(examsSubMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		for (int i = 0; i < 36; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			examsSubMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		examsSubMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		examsSubMenu.setItem(32, item);
		
		item.setType(Material.YELLOW_WOOL);
		meta.setDisplayName(ChatColor.YELLOW + "First Offence");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Will prompt you with:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &fHow many questions were asked/answered"));
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Executes:"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "    &c• &f/fee " + t.getName() + " <input>*25"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		examsSubMenu.setItem(13, item);
		lore.clear();
		
		
	}

}
