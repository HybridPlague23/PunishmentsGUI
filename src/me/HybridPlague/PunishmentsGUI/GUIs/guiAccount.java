package me.HybridPlague.PunishmentsGUI.GUIs;

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
import me.HybridPlague.PunishmentsGUI.SubMenus.account.accountAlts;
import me.HybridPlague.PunishmentsGUI.SubMenus.account.accountCompromised;
import me.HybridPlague.PunishmentsGUI.SubMenus.account.accountName;

public class guiAccount {

	private Main plugin;
	public accountAlts alts;
	public accountCompromised compromised;
	public accountName name;
	
	public guiAccount(Main plugin) {
		this.plugin = plugin;
		this.alts = new accountAlts(plugin);
		this.compromised = new accountCompromised(plugin);
		this.name = new accountName(plugin);
	}
	
	public Inventory accountMenu;
	
	public void openAccountMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		accountMenu = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&c&lAccount Rules > &f" + t.getName()));
		plugin.invs.add(accountMenu);
		p.openInventory(accountMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		
		for (int i = 0; i < 36; i++) { // Background
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			accountMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		accountMenu.setItem(30, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		accountMenu.setItem(32, item);
		
		/*
		 * SUB-CATEGORIES
		 */
		  /*
		   * Alt Accounts
		   */
		item.setType(Material.MINECART);
		meta.setDisplayName(ChatColor.YELLOW + "Alt Accounts");
		item.setItemMeta(meta);
		accountMenu.setItem(11, item);
		
		  /*
		   * Compromised Accounts
		   */
		item.setType(Material.PAPER);
		meta.setDisplayName(ChatColor.YELLOW + "Compromised Accounts");
		item.setItemMeta(meta);
		accountMenu.setItem(13, item);
		
		  /*
		   * Account Name
		   */
		item.setType(Material.NAME_TAG);
		meta.setDisplayName(ChatColor.YELLOW + "Account Name");
		item.setItemMeta(meta);
		accountMenu.setItem(15, item);
		
	}
	
}
