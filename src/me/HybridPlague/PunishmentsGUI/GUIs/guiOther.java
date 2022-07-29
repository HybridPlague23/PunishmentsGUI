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

import me.HybridPlague.PunishmentsGUI.Main;
import me.HybridPlague.PunishmentsGUI.SubMenus.other.otherAFK;
import me.HybridPlague.PunishmentsGUI.SubMenus.other.otherAutoFarms;
import me.HybridPlague.PunishmentsGUI.SubMenus.other.otherDoxing;
import me.HybridPlague.PunishmentsGUI.SubMenus.other.otherExploitingBugs;
import me.HybridPlague.PunishmentsGUI.SubMenus.other.otherKillingStaff;
import me.HybridPlague.PunishmentsGUI.SubMenus.other.otherScamming;
import me.HybridPlague.PunishmentsGUI.SubMenus.other.otherSettingHomes;
import me.HybridPlague.PunishmentsGUI.SubMenus.other.otherThreateningPlayers;
import me.HybridPlague.PunishmentsGUI.SubMenus.other.otherThreateningServer;
import me.HybridPlague.PunishmentsGUI.SubMenus.other.otherTicketAbuse;

public class guiOther {

	private Main plugin;
	public otherAutoFarms farms;
	public otherAFK afk;
	public otherDoxing doxing;
	public otherExploitingBugs bugs;
	public otherKillingStaff killingstaff;
	public otherScamming scamming;
	public otherSettingHomes homes;
	public otherThreateningPlayers threatPlayers;
	public otherThreateningServer threatServer;
	public otherTicketAbuse ticketabuse;
	
	
	public guiOther(Main plugin) {
		this.plugin = plugin;
		this.farms = new otherAutoFarms(plugin);
		this.afk = new otherAFK(plugin);
		this.doxing = new otherDoxing(plugin);
		this.bugs = new otherExploitingBugs(plugin);
		this.killingstaff = new otherKillingStaff(plugin);
		this.scamming = new otherScamming(plugin);
		this.homes = new otherSettingHomes(plugin);
		this.threatPlayers = new otherThreateningPlayers(plugin);
		this.threatServer = new otherThreateningServer(plugin);
		this.ticketabuse = new otherTicketAbuse(plugin);
	}
	
	public Inventory otherMenu;
	
	public void openOtherMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		otherMenu = Bukkit.createInventory(null, 45, ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules > &f" + t.getName()));
		plugin.invs.add(otherMenu);
		p.openInventory(otherMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		for (int i = 0; i < 45; i++) { // Background
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			otherMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		otherMenu.setItem(39, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		otherMenu.setItem(41, item);
		
		/*
		 * SUB-CATEGORIES
		 */
		  /*
		   * THREATENING THE SERVER
		   */
		item.setType(Material.COMMAND_BLOCK);
		meta.setDisplayName(ChatColor.YELLOW + "Threatening the Server");
		item.setItemMeta(meta);
		otherMenu.setItem(11, item);
		  /*
		   * THREATENING PLAYERS
		   */
		item.setType(Material.NETHERITE_SWORD);
		meta.setDisplayName(ChatColor.YELLOW + "Threatening Players/Staff");
		item.setItemMeta(meta);
		otherMenu.setItem(12, item);
		  /*
		   * DOXING
		   */
		item.setType(Material.BOOK);
		meta.setDisplayName(ChatColor.YELLOW + "Doxing Players");
		item.setItemMeta(meta);
		otherMenu.setItem(13, item);
		  /*
		   * TICKET ABUSE
		   */
		item.setType(Material.PAPER);
		meta.setDisplayName(ChatColor.YELLOW + "Ticket Abuse");
		item.setItemMeta(meta);
		otherMenu.setItem(14, item);
		  /*
		   * KILLING STAFF ON TICKET
		   */
		item.setType(Material.SKELETON_SKULL);
		meta.setDisplayName(ChatColor.YELLOW + "Killing Staff on a Ticket");
		item.setItemMeta(meta);
		otherMenu.setItem(15, item);
		  /*
		   * EXPLOITING A BUG
		   */
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.YELLOW + "Exploiting a Bug");
		item.setItemMeta(meta);
		otherMenu.setItem(20, item);
		  /*
		   * AFK-KICK AVOIDING
		   */
		item.setType(Material.WATER_BUCKET);
		meta.setDisplayName(ChatColor.YELLOW + "AFK-Kick Avoiding");
		item.setItemMeta(meta);
		otherMenu.setItem(21, item);
		  /*
		   * AUTO FARMS
		   */
		item.setType(Material.OBSERVER);
		meta.setDisplayName(ChatColor.YELLOW + "Automatic Farms");
		item.setItemMeta(meta);
		otherMenu.setItem(22, item);
		  /*
		   * SETTING HOMES
		   */
		item.setType(Material.OAK_PLANKS);
		meta.setDisplayName(ChatColor.YELLOW + "Setting Homes in Restricted Areas");
		item.setItemMeta(meta);
		otherMenu.setItem(23, item);
		  /*
		   * SCAMMING
		   */
		item.setType(Material.EMERALD);
		meta.setDisplayName(ChatColor.YELLOW + "Scamming");
		item.setItemMeta(meta);
		otherMenu.setItem(24, item);
	}

}
