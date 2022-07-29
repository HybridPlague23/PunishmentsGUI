package me.HybridPlague.PunishmentsGUI.GUIs;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.HybridPlague.PunishmentsGUI.Main;

public class guiMain {

	private Inventory main;
	
	private Main plugin;
	public guiMain(Main plugin) {
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public void openMainMenu(final Player p, final UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		
		main = Bukkit.createInventory(null, 45, ChatColor.translateAlternateColorCodes('&', "&c&lPunish > &f" + t.getName()));
		plugin.invs.add(main);
		p.openInventory(main);
		
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		/*
		 * SET BACKGROUND
		 */
		for (int i = 0; i < 45; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			main.setItem(i, item);
		}
		
		/*
		 * SET CLOSE BUTTON
		 */
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		main.setItem(40, item);
		
		/*
		 * SET CATERGORIES
		 */
		
		  /*
		   * Accounts
		   */
		ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
		SkullMeta skullmeta = (SkullMeta) skull.getItemMeta();
		
		skullmeta.setOwner(t.getName());
		skullmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cAccount Rules"));
		skull.setItemMeta(skullmeta);
		main.setItem(11, skull);
		
		  /*
		   * Client Mods
		   */
		item.setType(Material.NETHERITE_SWORD);
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cClient Modifications"));
		item.setItemMeta(meta);
		main.setItem(13, item);
		
		  /*
		   * Chat
		   */
		item.setType(Material.PAPER);
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cChat Rules"));
		item.setItemMeta(meta);
		main.setItem(15, item);
		
		  /*
		   * Griefing and Building
		   */
		item.setType(Material.OAK_PLANKS);
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cGriefing and Building Rules"));
		item.setItemMeta(meta);
		main.setItem(20, item);
		
		  /*
		   * Regions
		   */
		item.setType(Material.WOODEN_AXE);
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cRegioning Rules"));
		item.setItemMeta(meta);
		main.setItem(22, item);
		
		  /*
		   * Other Rules
		   */
		item.setType(Material.BOOK);
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cOther Rules"));
		item.setItemMeta(meta);
		main.setItem(24, item);
		
	}
	
	
}
