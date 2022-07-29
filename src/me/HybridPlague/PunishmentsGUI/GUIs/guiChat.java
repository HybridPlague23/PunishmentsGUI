package me.HybridPlague.PunishmentsGUI.GUIs;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.HybridPlague.PunishmentsGUI.Main;
import me.HybridPlague.PunishmentsGUI.SubMenus.chat.chatBehavior;
import me.HybridPlague.PunishmentsGUI.SubMenus.chat.chatBlatant;
import me.HybridPlague.PunishmentsGUI.SubMenus.chat.chatExams;
import me.HybridPlague.PunishmentsGUI.SubMenus.chat.chatLanguage;
import me.HybridPlague.PunishmentsGUI.SubMenus.chat.chatNames;
import me.HybridPlague.PunishmentsGUI.SubMenus.chat.chatPolitics;
import me.HybridPlague.PunishmentsGUI.SubMenus.chat.chatProfanity;
import me.HybridPlague.PunishmentsGUI.SubMenus.chat.chatRacism;
import me.HybridPlague.PunishmentsGUI.SubMenus.chat.chatServices;
import me.HybridPlague.PunishmentsGUI.SubMenus.chat.chatSexual;
import me.HybridPlague.PunishmentsGUI.SubMenus.chat.chatSpamming;
import me.HybridPlague.PunishmentsGUI.SubMenus.chat.chatVerbal;

public class guiChat {

	private Main plugin;
	
	public chatBehavior behavior;
	public chatBlatant blatant;
	public chatExams exams;
	public chatLanguage language;
	public chatNames names;
	public chatPolitics politics;
	public chatProfanity profanity;
	public chatRacism racism;
	public chatServices services;
	public chatSexual sexual;
	public chatSpamming spamming;
	public chatVerbal verbal;
	
	public guiChat(Main plugin) {
		this.plugin = plugin;
		
		this.behavior = new chatBehavior(plugin);
		this.blatant = new chatBlatant(plugin);
		this.exams = new chatExams(plugin);
		this.language = new chatLanguage(plugin);
		this.names = new chatNames(plugin);
		this.politics = new chatPolitics(plugin);
		this.profanity = new chatProfanity(plugin);
		this.racism = new chatRacism(plugin);
		this.services = new chatServices(plugin);
		this.sexual = new chatSexual(plugin);
		this.spamming = new chatSpamming(plugin);
		this.verbal = new chatVerbal(plugin);
		
	}
	
	public Inventory chatMenu;
	
	public void openChatMenu(final Player p, UUID target) {
		OfflinePlayer t = Bukkit.getOfflinePlayer(target);
		chatMenu = Bukkit.createInventory(null, 45, ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules > &f" + t.getName()));
		plugin.invs.add(chatMenu);
		p.openInventory(chatMenu);
		
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		
		for (int i = 0; i < 45; i++) {
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			chatMenu.setItem(i, item);
		}
		
		/*
		 * BACK AND CLOSE
		 */
		item.setType(Material.ARROW);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		item.setItemMeta(meta);
		chatMenu.setItem(39, item);
		
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Close");
		item.setItemMeta(meta);
		chatMenu.setItem(41, item);
		
		/*
		 * CATEGORIES
		 */
		  /*
		   * DISRESPECTFUL
		   */
		item.setType(Material.DIRT);
		meta.setDisplayName(ChatColor.YELLOW + "Disrespectful/Immature Behavior");
		item.setItemMeta(meta);
		chatMenu.setItem(10, item);

		  /*
		   * POLITICS
		   */
		item.setType(Material.WHITE_BANNER);
		meta.setDisplayName(ChatColor.YELLOW + "Discussing Real Life Politics/Controversial Topics");
		item.setItemMeta(meta);
		chatMenu.setItem(11, item);

		  /*
		   * RACISM
		   */
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.YELLOW + "Racism/Bigotry");
		item.setItemMeta(meta);
		chatMenu.setItem(12, item);

		  /*
		   * VERBAL HARASSMENT
		   */
		item.setType(Material.BELL);
		meta.setDisplayName(ChatColor.YELLOW + "Verbal Harassment");
		item.setItemMeta(meta);
		chatMenu.setItem(13, item);

		  /*
		   * SEXUAL HARASSMENT
		   */
		item.setType(Material.LEATHER_LEGGINGS);
		meta.setDisplayName(ChatColor.YELLOW + "Sexual Harassment");
		item.setItemMeta(meta);
		chatMenu.setItem(14, item);

		  /*
		   * PROFANITY
		   */
		item.setType(Material.PAPER);
		meta.setDisplayName(ChatColor.YELLOW + "Offensive/Excessive Profanity");
		item.setItemMeta(meta);
		chatMenu.setItem(15, item);

		  /*
		   * SPAMMING
		   */
		item.setType(Material.BOW);
		meta.setDisplayName(ChatColor.YELLOW + "Spamming/Begging");
		item.setItemMeta(meta);
		chatMenu.setItem(16, item);

		  /*
		   * ADVERTISING
		   */
		item.setType(Material.BOOK);
		meta.setDisplayName(ChatColor.YELLOW + "Blatant Advertising");
		item.setItemMeta(meta);
		chatMenu.setItem(20, item);

		  /*
		   * ADVERTISING UNAPPROVED SERVICES
		   */
		item.setType(Material.BOOK);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setDisplayName(ChatColor.YELLOW + "Advertising - Unapproved Services");
		item.setItemMeta(meta);
		chatMenu.setItem(21, item);

		  /*
		   * MENTIONING SERVER NAMES
		   */
		item.setType(Material.NAME_TAG);
		meta.setDisplayName(ChatColor.YELLOW + "Advertising - Mentioning Server Names");
		item.setItemMeta(meta);
		chatMenu.setItem(22, item);
		meta.removeEnchant(Enchantment.DURABILITY);
		meta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);

		  /*
		   * EXAM ANSWERS
		   */
		item.setType(Material.WRITABLE_BOOK);
		meta.setDisplayName(ChatColor.YELLOW + "Giving/Asking for Exam Answers");
		item.setItemMeta(meta);
		chatMenu.setItem(23, item);

		  /*
		   * FOREIGN LANGUAGE
		   */
		item.setType(Material.END_STONE);
		meta.setDisplayName(ChatColor.YELLOW + "Foreign Language in Global Chat");
		item.setItemMeta(meta);
		chatMenu.setItem(24, item);
		
		
	}
	
	
}
