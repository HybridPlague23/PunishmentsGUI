package me.HybridPlague.PunishmentsGUI;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.wiefferink.areashop.regions.BuyRegion;
import me.wiefferink.areashop.regions.GeneralRegion;

public class PunishmentsEvents implements Listener {

	private Main plugin;
	public PunishmentsEvents(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onButtonClicks(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (plugin.invs.contains(e.getInventory())) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			e.setCancelled(true);
			OfflinePlayer t = Bukkit.getOfflinePlayer(plugin.targeted.get(p));
			/*
			 * CLOSE + BACK
			 */
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Close")) { // Close
				p.closeInventory();
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Back")
					&& (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&c&lAccount Rules > &f" + t.getName()))
							|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&c&lClient Mods > &f" + t.getName()))
							|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules > &f" + t.getName()))
							|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&c&lGriefing Rules > &f" + t.getName()))
							|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&c&lRegioning Rules > &f" + t.getName()))
							|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules > &f" + t.getName())))) { // Back
				plugin.main.openMainMenu(p, plugin.targeted.get(p));
			}
		}
	}
	
	
	/* * * * * * * * * 
	 *               *
	 *   MAIN MENU   *
	 *               *
	 * * * * * * * * */
	
	@EventHandler
	public void onAccountClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (plugin.invs.contains(e.getInventory())) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			e.setCancelled(true);
			  /*
			   * ACCOUNT
			   */
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Account Rules")) {
				plugin.account.openAccountMenu(p, plugin.targeted.get(p));
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Back")
					&& (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lAccount Rules (")))) { // BACK BUTTON
						plugin.account.openAccountMenu(p, plugin.targeted.get(p));
					}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Alt Accounts")) {
				plugin.account.alts.openAltSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Compromised Accounts")) {
				plugin.account.compromised.openCompSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Account Name")) {
				plugin.account.name.openNameSubMenu(p, plugin.targeted.get(p));
			}
		}
	}
	
	
	@EventHandler
	public void onModsClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (plugin.invs.contains(e.getInventory())) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			e.setCancelled(true);
			  /*
			   * MODS
			   */
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Client Modifications")) {
				plugin.mods.openClientMenu(p, plugin.targeted.get(p));
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "X-ray")) {
				plugin.mods.xray.openXraySubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Other Mods")) {
				plugin.mods.other.openOtherSubMenu(p, plugin.targeted.get(p));
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Back")
					&& (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lClient Mods (")))) { // BACK BUTTON
						plugin.mods.openClientMenu(p, plugin.targeted.get(p));
					}
		}
		
	}
	
	
	@EventHandler
	public void onChatClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (plugin.invs.contains(e.getInventory())) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			e.setCancelled(true);
			  /*
			   * CHAT
			   */
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Chat Rules")) {
				plugin.chat.openChatMenu(p, plugin.targeted.get(p));
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Back")
					&&	e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules ("))) { // BACK BUTTON
						plugin.chat.openChatMenu(p, plugin.targeted.get(p));
					}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Disrespectful/Immature Behavior")) {
				plugin.chat.behavior.openBehaviorSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Blatant Advertising")) {
				plugin.chat.blatant.openBlatantSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Giving/Asking for Exam Answers")) {
				plugin.chat.exams.openExamSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Foreign Language in Global Chat")) {
				plugin.chat.language.openLanguageSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Advertising - Mentioning Server Names")) {
				plugin.chat.names.openNameSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Discussing Real Life Politics/Controversial Topics")) {
				plugin.chat.politics.openPoliticsSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Racism/Bigotry")) {
				plugin.chat.racism.openRacismSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Verbal Harassment")) {
				plugin.chat.verbal.openVerbalSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Sexual Harassment")) {
				plugin.chat.sexual.openSexualSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Offensive/Excessive Profanity")) {
				plugin.chat.profanity.openProfanitySubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Spamming/Begging")) {
				plugin.chat.spamming.openSpammingSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Advertising - Unapproved Services")) {
				plugin.chat.services.openServicesSubMenu(p, plugin.targeted.get(p));
			}
		}
	}
	
	
	@EventHandler
	public void onGriefingClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (plugin.invs.contains(e.getInventory())) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			e.setCancelled(true);
			  /*
			   * GRIEFING
			   */
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Griefing and Building Rules")) {
				plugin.griefing.openGriefingMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Back")
					&&	e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lGriefing Rules ("))) { // BACK BUTTON
						plugin.griefing.openGriefingMenu(p, plugin.targeted.get(p));
					}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Vulgar Builds")) {
				plugin.griefing.vulgar.openVulgarSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Stealing")) {
				plugin.griefing.stealing.openStealingSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Using Items to cause Destruction")) {
				plugin.griefing.destruction.openDestructionSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Locking")) {
				plugin.griefing.locking.openLockingSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Building Modifications")) {
				plugin.griefing.modifications.openModificationsSubMenu(p, plugin.targeted.get(p));
			}
		}
	}
	
	
	@EventHandler
	public void onRegioningClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (plugin.invs.contains(e.getInventory())) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			e.setCancelled(true);
			  /*
			   * REGIONING
			   */
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Regioning Rules")) {
				plugin.regioning.openRegioningMenu(p, plugin.targeted.get(p));
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Back")
					&&	e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lRegioning Rules ("))) { // BACK BUTTON
						plugin.regioning.openRegioningMenu(p, plugin.targeted.get(p));
					}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Portal/Monument Regioning")) {
				plugin.regioning.portal.openPortalsSubMenu(p, plugin.targeted.get(p));
			}
		}
	}
	
	
	@EventHandler
	public void onOtherClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (plugin.invs.contains(e.getInventory())) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			e.setCancelled(true);
			  /*
			   * OTHER
			   */
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Other Rules")) {
				plugin.other.openOtherMenu(p, plugin.targeted.get(p));
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Back")
					&&	e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules ("))) { // BACK BUTTON
						plugin.other.openOtherMenu(p, plugin.targeted.get(p));
					}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Threatening the Server")) {
				plugin.other.threatServer.openThreateningServerSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Threatening Players/Staff")) {
				plugin.other.threatPlayers.openThreateningPlayersSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Doxing Players")) {
				plugin.other.doxing.openDoxingSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Ticket Abuse")) {
				plugin.other.ticketabuse.openTicketAbuseSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Killing Staff on a Ticket")) {
				plugin.other.killingstaff.openKillingStaffSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Exploiting a Bug")) {
				plugin.other.bugs.openBugsSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "AFK-Kick Avoiding")) {
				plugin.other.afk.openAFKSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Automatic Farms")) {
				plugin.other.farms.openAutoFarmsSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Setting Homes in Restricted Areas")) {
				plugin.other.homes.openSettingHomesSubMenu(p, plugin.targeted.get(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Scamming")) {
				plugin.other.scamming.openScammingSubMenu(p, plugin.targeted.get(p));
			}
		}
	}
	
	
	/* * * * * * * * 
	 *             *
	 *  SUB MENUS  *
	 *             *
	 * * * * * * * */
	
	public void compAccount(final Player p, String type) {
		plugin.prompt.put(p, type);
		p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the &cOTHER account&7's full username."));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
		p.sendMessage("");
		return;
	}
	
	public void regioning(final Player p) {
		plugin.prompt.put(p, "RegioningPrompt");
		p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the name of the &cREGION"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
		p.sendMessage("");
		return;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPromptResponse(AsyncPlayerChatEvent e) {
		Player p = (Player) e.getPlayer(); // Sender
		
		if (plugin.targeted.get(p) == null) return;
		if (plugin.prompt.get(p) == null) return;
		
			OfflinePlayer t = Bukkit.getOfflinePlayer(plugin.targeted.get(p)); // Menued player
			
			OfflinePlayer account = Bukkit.getOfflinePlayer(e.getMessage()); // Other account
			UUID id = account.getUniqueId(); // Account uuid
			
			switch (plugin.prompt.get(p)) {
			case "ExamsFirst":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String exams = e.getMessage();
				if (!isNum(exams)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fNaN -> &e" + e.getMessage()));
					return;
				}
				if (Integer.parseInt(exams) < 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fInteger be below 0 -> &e" + e.getMessage()));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						p.performCommand("fee " + t.getName() + " " + Integer.parseInt(exams)*25);
						return;
					}
				}.runTask(plugin);
				return;
			case "SexualFirst":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " -p 2 Sexual Harassment (1st)");
							p.performCommand("tempban " + t.getName() + " 1d Sexual Harassment (1st)");
							p.performCommand("fee " + t.getName() + " 100");
							p.performCommand("unfee " + account.getName() + " 100");
							return;
						}
					}.runTask(plugin);
					return;
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
			case "SexualSecond":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " -p 2 Sexual Harassment (2nd)");
							p.performCommand("tempban " + t.getName() + " 3d Sexual Harassment (2nd)");
							p.performCommand("fee " + t.getName() + " 100");
							p.performCommand("unfee " + account.getName() + " 100");
							return;
						}
					}.runTask(plugin);
					return;
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
			case "SexualThird":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " -p 2 Sexual Harassment (3rd)");
							p.performCommand("tempban " + t.getName() + " 1w Sexual Harassment (3rd)");
							p.performCommand("fee " + t.getName() + " 100");
							p.performCommand("unfee " + account.getName() + " 100");
							return;
						}
					}.runTask(plugin);
					return;
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
			case "SexualFourth":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("ban " + t.getName() + " Sexual Harassment (4th)");
							p.performCommand("fee " + t.getName() + " 100");
							p.performCommand("unfee " + account.getName() + " 100");
							return;
						}
					}.runTask(plugin);
					return;
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
			case "VerbalFirst":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " Verbal Harassment (1st)");
							p.performCommand("fee " + t.getName() + " 50");
							p.performCommand("unfee " + account.getName() + " 50");
							return;
						}
					}.runTask(plugin);
					return;
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
			case "VerbalSecond":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " Verbal Harassment (2nd)");
							p.performCommand("tempmute " + t.getName() + " 15m Verbal Harassment (2nd)");
							p.performCommand("fee " + t.getName() + " 50");
							p.performCommand("unfee " + account.getName() + " 50");
							return;
						}
					}.runTask(plugin);
					return;
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
			case "VerbalThird":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " Verbal Harassment (3rd)");
							p.performCommand("tempmute " + t.getName() + " 1h Verbal Harassment (3rd)");
							p.performCommand("fee " + t.getName() + " 50");
							p.performCommand("unfee " + account.getName() + " 50");
							return;
						}
					}.runTask(plugin);
					return;
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
			case "VerbalFourth":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " Verbal Harassment (4th)");
							p.performCommand("tempban " + t.getName() + " 3d Verbal Harassment (4th)");
							p.performCommand("fee " + t.getName() + " 50");
							p.performCommand("unfee " + account.getName() + " 50");
							return;
						}
					}.runTask(plugin);
					return;
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
			case "VerbalFifth":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " Verbal Harassment (5th)");
							p.performCommand("tempban " + t.getName() + " 2w Verbal Harassment (5th)");
							p.performCommand("fee " + t.getName() + " 50");
							p.performCommand("unfee " + account.getName() + " 50");
							return;
						}
					}.runTask(plugin);
					return;
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
			case "FarmsFirst":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String farmkrunas = e.getMessage();
				if (!isNum(farmkrunas)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fNaN -> &e" + e.getMessage()));
					return;
				}
				if (Integer.parseInt(farmkrunas) < 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fInteger cannot be below 0 -> &e" + e.getMessage()));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						int extra = Integer.parseInt(farmkrunas);
						int amount = extra + 500;
						p.performCommand("warn " + t.getName() + " Auto-Farming (1st)");
						p.performCommand("fee " + t.getName() + " " + String.valueOf(amount));
						return;
					}
				}.runTask(plugin);
				return;
			case "FarmsSecond":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String farmkrunas2 = e.getMessage();
				if (!isNum(farmkrunas2)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fNaN -> &e" + e.getMessage()));
					return;
				}
				if (Integer.parseInt(farmkrunas2) < 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fInteger cannot be below 0 -> &e" + e.getMessage()));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						int extra = Integer.parseInt(farmkrunas2);
						int amount = extra + 1000;
						p.performCommand("warn " + t.getName() + " Auto-Farming (2nd)");
						p.performCommand("tempban " + t.getName() + " 1w Auto-Farming (2nd)");
						p.performCommand("fee " + t.getName() + " " + String.valueOf(amount));
						return;
					}
				}.runTask(plugin);
				return;
			case "FarmsThird":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String farmkrunas3 = e.getMessage();
				if (!isNum(farmkrunas3)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fNaN -> &e" + e.getMessage()));
					return;
				}
				if (Integer.parseInt(farmkrunas3) < 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fInteger cannot be below 0 -> &e" + e.getMessage()));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						p.performCommand("ban " + t.getName() + " Auto-Farming (3rd)");
						p.performCommand("fee " + t.getName() + " " + Integer.parseInt(farmkrunas3));
						return;
					}
				}.runTask(plugin);
				return;
			case "AFKFirst":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String afkkrunas = e.getMessage();
				if (!isNum(afkkrunas)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fNaN -> &e" + e.getMessage()));
					return;
				}
				if (Integer.parseInt(afkkrunas) < 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fInteger cannot be below 0 -> &e" + e.getMessage()));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						int extra = Integer.parseInt(afkkrunas);
						int amount = extra + 500;
						p.performCommand("warn " + t.getName() + " AFK-Kick Avoiding (1st)");
						p.performCommand("fee " + t.getName() + " " + String.valueOf(amount));
						return;
					}
				}.runTask(plugin);
				return;
			case "AFKSecond":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String afkkrunas2 = e.getMessage();
				if (!isNum(afkkrunas2)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fNaN -> &e" + e.getMessage()));
					return;
				}
				if (Integer.parseInt(afkkrunas2) < 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fInteger cannot be below 0 -> &e" + e.getMessage()));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						int extra = Integer.parseInt(afkkrunas2);
						int amount = extra + 1000;
						p.performCommand("warn " + t.getName() + " AFK-Kick Avoiding (2nd)");
						p.performCommand("tempban " + t.getName() + " 1w AFK-Kick Avoiding (2nd)");
						p.performCommand("fee " + t.getName() + " " + String.valueOf(amount));
						return;
					}
				}.runTask(plugin);
				return;
			case "AFKThird":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String afkkrunas3 = e.getMessage();
				if (!isNum(afkkrunas3)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fNaN -> &e" + e.getMessage()));
					return;
				}
				if (Integer.parseInt(afkkrunas3) < 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fInteger cannot be below 0 -> &e" + e.getMessage()));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						p.performCommand("ban " + t.getName() + " AFK-Kick Avoiding (3rd)");
						p.performCommand("fee " + t.getName() + " " + Integer.parseInt(afkkrunas3));
						return;
					}
				}.runTask(plugin);
				return;
			case "BugsFirst":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String krunas = e.getMessage();
				if (!isNum(krunas)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fNaN -> &e" + e.getMessage()));
					return;
				}
				if (Integer.parseInt(krunas) < 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fInteger cannot be below 0 -> &e" + e.getMessage()));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						int extra = Integer.parseInt(krunas);
						int amount = extra + 500;
						p.performCommand("warn " + t.getName() + " -p 2 Exploiting a Bug (1st)");
						p.performCommand("fee " + t.getName() + " " + String.valueOf(amount));
						return;
					}
				}.runTask(plugin);
				return;
			case "BugsSecond":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String krunas2 = e.getMessage();
				if (!isNum(krunas2)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fNaN -> &e" + e.getMessage()));
					return;
				}
				if (Integer.parseInt(krunas2) < 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fInteger cannot be below 0 -> &e" + e.getMessage()));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						int extra = Integer.parseInt(krunas2);
						int amount = extra + 1000;
						p.performCommand("warn " + t.getName() + " -p 2 Exploiting a Bug (2nd)");
						p.performCommand("tempban " + t.getName() + " 1w Exploiting a Bug (2nd)");
						p.performCommand("fee " + t.getName() + " " + String.valueOf(amount));
						return;
					}
				}.runTask(plugin);
				return;
			case "BugsThird":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String krunas3 = e.getMessage();
				if (!isNum(krunas3)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fNaN -> &e" + e.getMessage()));
					return;
				}
				if (Integer.parseInt(krunas3) < 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fInteger cannot be below 0 -> &e" + e.getMessage()));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						p.performCommand("ban " + t.getName() + " Exploiting a Bug (3rd)");
						p.performCommand("fee " + t.getName() + " " + Integer.parseInt(krunas3));
						return;
					}
				}.runTask(plugin);
				return;
			case "DestructionFirst":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " Using Items to cause Destruction (1st)");
							p.performCommand("fee " + t.getName() + " 250");
							p.performCommand("unfee " + account.getName() + " 250");
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
				return;
			case "DestructionSecond":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " Using Items to cause Destruction (2nd)");
							p.performCommand("tempban " + t.getName() + " 1d Using Items to cause Destruction (2nd)");
							p.performCommand("fee " + t.getName() + " 500");
							p.performCommand("unfee " + account.getName() + " 500");
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
				return;
			case "DestructionThird":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " -p 2 Using Items to cause Destruction (3rd)");
							p.performCommand("tempban " + t.getName() + " 1w Using Items to cause Destruction (3rd)");
							p.performCommand("fee " + t.getName() + " 750");
							p.performCommand("unfee " + account.getName() + " 750");
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
				return;
			case "DestructionFourth":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " -p 2 Using Items to cause Destruction (4th)");
							p.performCommand("tempban " + t.getName() + " 2w Using Items to cause Destruction (4th)");
							p.performCommand("fee " + t.getName() + " 1000");
							p.performCommand("unfee " + account.getName() + " 1000");
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
				return;
			case "StealingFirst":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " -p 2 Stealing (1st)");
							p.performCommand("tempban " +  t.getName() + " 1d Stealing (1st)");
							p.performCommand("fee " + t.getName() + " 100");
							p.performCommand("unfee " + account.getName() + " 100");
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
				return;
			case "StealingSecond":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " -p 2 Stealing (2nd)");
							p.performCommand("tempban " +  t.getName() + " 1w Stealing (2nd)");
							p.performCommand("fee " + t.getName() + " 200");
							p.performCommand("unfee " + account.getName() + " 200");
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
				return;
			case "StealingThird":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " -p 2 Stealing (3rd)");
							p.performCommand("tempban " +  t.getName() + " 2w Stealing (3rd)");
							p.performCommand("fee " + t.getName() + " 300");
							p.performCommand("unfee " + account.getName() + " 300");
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
				return;
			case "StealingFourth":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("ban " +  t.getName() + " Stealing (4th)");
							p.performCommand("fee " + t.getName() + " 400");
							p.performCommand("unfee " + account.getName() + " 400");
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
				return;
			case "ModificationsFirst":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " Griefing Stage A");
							p.performCommand("tempban " +  t.getName() + " 1d Griefing Stage A");
							p.performCommand("fee " + t.getName() + " 100");
							p.performCommand("unfee " + account.getName() + " 100");
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
				return;
			case "ModificationsSecond":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " Griefing Stage B");
							p.performCommand("tempban " +  t.getName() + " 1w Griefing Stage B");
							p.performCommand("fee " + t.getName() + " 150");
							p.performCommand("unfee " + account.getName() + " 150");
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
				return;
			case "ModificationsThird":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM | t is CRIMINAL
							plugin.prompt.remove(p);
							p.performCommand("warn " + t.getName() + " Griefing Stage C");
							p.performCommand("tempban " +  t.getName() + " 2w Griefing Stage C");
							p.performCommand("fee " + t.getName() + " 200");
							p.performCommand("unfee " + account.getName() + " 200");
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
				return;
			case "LockingFirst":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String n = e.getMessage();
				if (!isNum(n)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fNaN -> &e" + e.getMessage()));
					return;
				}
				if (Integer.parseInt(n) < 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fInteger be below 0 -> &e" + e.getMessage()));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						p.performCommand("warn " + t.getName() + " Unlawfully Locking Items (1st)");
						p.performCommand("fee " + t.getName() + " " + Integer.parseInt(n)*20);
						return;
					}
				}.runTask(plugin);
				return;
			case "LockingSecond":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String n2 = e.getMessage();
				if (!isNum(n2)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fNaN -> &e" + e.getMessage()));
					return;
				}
				if (Integer.parseInt(n2) < 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fInteger be below 0 -> &e" + e.getMessage()));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						p.performCommand("warn " + t.getName() + " Unlawfully Locking Items (2nd)");
						p.performCommand("fee " + t.getName() + " " + Integer.parseInt(n2)*40);
						return;
					}
				}.runTask(plugin);
				return;
			case "LockingThird":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String n3 = e.getMessage();
				if (!isNum(n3)) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fNaN -> &e" + e.getMessage()));
					return;
				}
				if (Integer.parseInt(n3) < 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fInteger be below 0 -> &e" + e.getMessage()));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						p.performCommand("warn " + t.getName() + " Unlawfully Locking Items (3rd)");
						p.performCommand("fee " + t.getName() + " " + Integer.parseInt(n3)*60);
						return;
					}
				}.runTask(plugin);
				return;
			case "RegioningPrompt":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				new BukkitRunnable() {
					@Override
					public void run() {
						String region = e.getMessage();
						GeneralRegion rg = plugin.fileMan.getRegion(region);
						BuyRegion buy = (BuyRegion) rg;
						try {
							if (!buy.isSold()) { 
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fThat region is not sold!"));
								return;
							}
							if (!buy.getOwner().equals(t.getUniqueId())) {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &e" + t.getName() + " &fdoes not own that region -> &e" + region));
								return;
							}
							plugin.prompt.remove(p);
							p.performCommand("as sell " + rg);
							p.performCommand("as del " + rg);
							p.performCommand("rg remove " + rg);
							p.performCommand("fee " + t.getName() + " " + buy.getFormattedPrice());
							return;
						} catch (Exception ex) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fThat region cannot be found!"));
							return;
						}
					}
				}.runTask(plugin);
				return;
			case "CompPromptFirst":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() {
							plugin.prompt.remove(p);
							p.performCommand("warn " + account.getName() + " -p 2 Sharing/Compromised Accounts");
							p.performCommand("warn " + t.getName() + " -p 2 Sharing/Compromised Accounts");
							return;
						}
					}.runTask(plugin);
					return;
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
				
			case "CompPromptSecond":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() {
							plugin.prompt.remove(p);
							p.performCommand("ban " + account.getName() + " Sharing/Compromised Accounts");
							p.performCommand("ban " + t.getName() + " Sharing/Compromised Accounts");
							return;
						}
					}.runTask(plugin);
					return;
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
			case "HomesFirst":
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String home = e.getMessage();
				if (!plugin.ess.getUser(t.getUniqueId()).getHomes().contains(home)) {
					// Home not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fHome not found -> &e" + home));
					return;
				}
				// Home found
				new BukkitRunnable() {
					@Override
					public void run() {
						plugin.prompt.remove(p);
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.prefix + "&e" + t.getName() + "&f's home has been removed -> &e" + home));
						p.performCommand("warn " + t.getName() + " -p 2 Setting a Home in a Restricted Area (1st)");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "delhome " + t.getName() + ":" + home);
						return;
					}
				}.runTask(plugin);
				return;
			case "HomesSecond.1": // Get home name
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String home2 = e.getMessage().toLowerCase();
				if (!plugin.ess.getUser(t.getUniqueId()).getHomes().contains(home2)) {
					// Home not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fHome not found -> &e" + home2));
					return;
				}
				// Home found
				plugin.homeArg.put(p, home2);
				this.homes2(p, "HomesSecond.2");
				return;
			case "HomesSecond.2": // Get victim name
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM
							plugin.prompt.remove(p);
							String finalhome = plugin.homeArg.get(p); // get home name from memory
							p.performCommand("warn " + t.getName() + " -p 2 Setting a Home in a Restricted Area (2nd)");
							p.performCommand("fee " + t.getName() + " 300");
							p.performCommand("unfee " + account.getName() + " 300");
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "delhome " + t.getName() + ":" + finalhome);
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
			case "HomesThird.1": // Get home name
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String home3 = e.getMessage().toLowerCase();
				if (!plugin.ess.getUser(t.getUniqueId()).getHomes().contains(home3)) {
					// Home not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fHome not found -> &e" + home3));
					return;
				}
				// Home found
				plugin.homeArg.put(p, home3);
				this.homes2(p, "HomesThird.2");
				return;
			case "HomesThird.2": // Get victim name
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM
							plugin.prompt.remove(p);
							String finalhome = plugin.homeArg.get(p); // get home name from memory
							p.performCommand("warn " + t.getName() + " -p 2 Setting a Home in a Restricted Area (3rd)");
							p.performCommand("tempban " + t.getName() + " 3d Setting a Home in a Restricted Area (3rd)");
							p.performCommand("fee " + t.getName() + " 300");
							p.performCommand("unfee " + account.getName() + " 300");
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "delhome " + t.getName() + ":" + finalhome);
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
			case "HomesFourth.1": // Get home name
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				String home4 = e.getMessage().toLowerCase();
				if (!plugin.ess.getUser(t.getUniqueId()).getHomes().contains(home4)) {
					// Home not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fHome not found -> &e" + home4));
					return;
				}
				// Home found
				plugin.homeArg.put(p, home4);
				this.homes2(p, "HomesFourth.2");
				return;
			case "HomesFourth.2": // Get victim name
				e.setCancelled(true);
				if (e.getMessage().equalsIgnoreCase("Stop") || e.getMessage().equalsIgnoreCase("None")) {
					plugin.prompt.remove(p);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Cancelled) &fPrompt has been cancelled."));
					return;
				}
				if (Bukkit.getOfflinePlayer(id).hasPlayedBefore() || Bukkit.getOfflinePlayer(id).isOnline()) {
					new BukkitRunnable() {
						@Override
						public void run() { // account is VICTIM
							plugin.prompt.remove(p);
							String finalhome = plugin.homeArg.get(p); // get home name from memory
							p.performCommand("warn " + t.getName() + " -p 2 Setting a Home in a Restricted Area (4th)");
							p.performCommand("tempban " + t.getName() + " 1w Setting a Home in a Restricted Area (4th)");
							p.performCommand("fee " + t.getName() + " 300");
							p.performCommand("unfee " + account.getName() + " 300");
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "delhome " + t.getName() + ":" + finalhome);
							return;
						}
					}.runTask(plugin);
				} else {
					// Account not found
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(Try Again) &fAccount not found -> &e" + account.getName()));
					return;
				}
			}
	}
	
	
	@EventHandler
	public void onAccountActions(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (plugin.invs.contains(e.getInventory())) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			e.setCancelled(true);
			OfflinePlayer t = Bukkit.getOfflinePlayer(plugin.targeted.get(p));
			
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lAccount Rules (Alts)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("ban " + t.getName() + " Alt Account");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("ban " + t.getName() + " Alt Account");
					p.performCommand("banip " + t.getName() + " Multiple Alts Accounts");
					return;
				}
			}
			
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lAccount Rules (Comp)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					this.compAccount(p, "CompPromptFirst");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					this.compAccount(p, "CompPromptSecond");
					return;
				}
			}
			
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lAccount Rules (Name)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Inappropriate Name")) {
					p.closeInventory();
					p.performCommand("ban " + t.getName() + " Your name was found inappropriate. Please appeal on the forums when your name has been changed to something more appropriate.");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Similar Name")) {
					p.closeInventory();
					p.performCommand("ban " + t.getName() + " Your name was found too similar to someone else's. Please appeal on the forums when your name has been changed to something else.");
					return;
				}
			}
			
		}
		
	}
	
	
	public void banXray(final Player p, OfflinePlayer t, int offence) {
		switch (offence) {
		case 1:
			if (t.isOnline()) {
				clearInv(p, t);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lPunish &8⼁ &fAll ores have been automatically removed from " + t.getName() + "'s inventory."));
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lPunish &8⼁ &f" + t.getName() + " is not online, so ores could not be automatically removed from their inventory."));
			}
			p.performCommand("tempban " + t.getName() + " 2d X-ray First Offence");
			p.performCommand("fee " + t.getName() + " 200");
			p.performCommand("warn " + t.getName() + " -p 4 X-ray First Offence");
			break;
		case 2:
			if (t.isOnline()) {
				clearInv(p, t);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lPunish &8⼁ &fAll ores have been automatically removed from " + t.getName() + "'s inventory."));
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lPunish &8⼁ &f" + t.getName() + " is not online, so ores could not be automatically removed from their inventory."));
			}
			p.performCommand("ban " + t.getName() + " X-ray Second Offence");
			break;
		}
		return;
	}
	
	public void clearInv(final Player p, final OfflinePlayer target) {
		ItemStack[] items = new ItemStack[plugin.getConfig().getStringList("Items").size()];
		ItemStack item = null;
		int position = 0;
		
		for (String i : plugin.getConfig().getStringList("Items")) {
			try {
				item = new ItemStack(Material.matchMaterial(i), 3000);
			} catch(Exception e) {
				// do nothing
			}
			items[position] = item;
			position++;
		}
		target.getPlayer().getInventory().removeItem(items);
	}
	
	@EventHandler
	public void onModsActions(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (plugin.invs.contains(e.getInventory())) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			e.setCancelled(true);
			OfflinePlayer t = Bukkit.getOfflinePlayer(plugin.targeted.get(p));

			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lClient Mods (X-ray)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					this.banXray(p, t, 1);
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					this.banXray(p, t, 2);
					return;
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lClient Mods (Other)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("tempban " + t.getName() + " 2d Client Mods First Offence");
					p.performCommand("fee " + t.getName() + " 150");
					p.performCommand("warn " + t.getName() + " -p 4 Client Mods First Offence");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("ban " + t.getName() + " Client Mods Second Offence");
					return;
				}
			}
		}
	}
	
	
	@EventHandler
	public void onChatActions(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (plugin.invs.contains(e.getInventory())) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			e.setCancelled(true);
			OfflinePlayer t = Bukkit.getOfflinePlayer(plugin.targeted.get(p));
			
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Behavior)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Disrespectful/Immature Behavior (1st)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Disrespectful/Immature Behavior (2nd)");
					p.performCommand("tempmute " + t.getName() + " 10m Disrespectful/Immature Behavior (2nd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Disrespectful/Immature Behavior (3rd)");
					p.performCommand("tempmute " + t.getName() + " 30m Disrespectful/Immature Behavior (3rd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Disrespectful/Immature Behavior (4th)");
					p.performCommand("tempban " + t.getName() + " 2d Disrespectful/Immature Behavior (4th)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fifth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Disrespectful/Immature Behavior (5th)");
					p.performCommand("tempban " + t.getName() + " 1w Disrespectful/Immature Behavior (5th)");
				}
			}
			/*----------------------------------------------------------------------------------------------------------------*/
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Politics)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Discussing IRL Politics/Controversial Topics (1st)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Discussing IRL Politics/Controversial Topics (2nd)");
					p.performCommand("tempmute " + t.getName() + " 10m Discussing IRL Politics/Controversial Topics (2nd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Discussing IRL Politics/Controversial Topics (3rd)");
					p.performCommand("tempmute " + t.getName() + " 30m Discussing IRL Politics/Controversial Topics (3rd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Discussing IRL Politics/Controversial Topics (4th)");
					p.performCommand("tempban " + t.getName() + " 2d Discussing IRL Politics/Controversial Topics (4th)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fifth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Discussing IRL Politics/Controversial Topics (5th)");
					p.performCommand("tempban " + t.getName() + " 1w Discussing IRL Politics/Controversial Topics (5th)");
				}
			}
			/*----------------------------------------------------------------------------------------------------------------*/
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Racism)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Racism/Bigotry (1st)");
					p.performCommand("tempmute " + t.getName() + " 30m Racism/Bigotry (1st)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Racism/Bigotry (2nd)");
					p.performCommand("tempban " + t.getName() + " 1w Racism/Bigotry (2nd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					p.performCommand("ban " + t.getName() + " Racism/Bigotry (3rd)");
				}
			}
			/*----------------------------------------------------------------------------------------------------------------*/
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Profanity)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Profanity (1st)");
					p.performCommand("tempmute " + t.getName() + " 5m Profanity (1st)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Profanity (2nd)");
					p.performCommand("tempmute " + t.getName() + " 15m Profanity (2nd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Profanity (3rd)");
					p.performCommand("tempmute " + t.getName() + " 2h Profanity (3rd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Profanity (4th)");
					p.performCommand("tempban " + t.getName() + " 3d Profanity (4th)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fifth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Profanity (5th)");
					p.performCommand("tempban " + t.getName() + " 1w Profanity (5th)");
				}
			}
			/*----------------------------------------------------------------------------------------------------------------*/
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Spam)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Spamming/Begging (1st)");
					p.performCommand("tempmute " + t.getName() + " 5m Spamming/Begging (1st)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Spamming/Begging (2nd)");
					p.performCommand("tempmute " + t.getName() + " 10m Spamming/Begging (2nd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Spamming/Begging (3rd)");
					p.performCommand("tempmute " + t.getName() + " 30m Spamming/Begging (3rd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Spamming/Begging (4th)");
					p.performCommand("tempban " + t.getName() + " 1h Spamming/Begging (4th)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fifth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Spamming/Begging (5th)");
					p.performCommand("tempban " + t.getName() + " 3d Spamming/Begging (5th)");
				}
			}
			/*----------------------------------------------------------------------------------------------------------------*/
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Blatant Ad)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("ban " + t.getName() + " Blatant Advertising");
				}
			}
			/*----------------------------------------------------------------------------------------------------------------*/
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Services Ad)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Mentioning Unapproved Services (1st)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Mentioning Unapproved Services (2nd)");
					p.performCommand("tempmute " + t.getName() + " 1h Mentioning Unapproved Services (2nd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Mentioning Unapproved Services (3rd)");
					p.performCommand("tempmute " + t.getName() + " 1d Mentioning Unapproved Services (3rd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Mentioning Unapproved Services (4th)");
					p.performCommand("tempban " + t.getName() + " 1w Mentioning Unapproved Services (4th)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fifth Offence")) {
					p.closeInventory();
					p.performCommand("ban " + t.getName() + " Mentioning Unapproved Services (5th)");
				}
			}
			/*----------------------------------------------------------------------------------------------------------------*/
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Names Ad)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Mentioning Server Names (1st)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Mentioning Server Names (2nd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Mentioning Server Names (3rd)");
					p.performCommand("tempmute " + t.getName() + " 1h Mentioning Server Names (3rd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Mentioning Server Names (4th)");
					p.performCommand("tempban " + t.getName() + " 1w Mentioning Server Names (4th)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fifth Offence")) {
					p.closeInventory();
					p.performCommand("ban " + t.getName() + " Mentioning Server Names (5th)");
				}
			}
			/*----------------------------------------------------------------------------------------------------------------*/
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Language)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Foreign Language in Global Chat (1st)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Foreign Language in Global Chat (2nd)");
					p.performCommand("tempmute " + t.getName() + " 10m Foreign Language in Global Chat (2nd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Foreign Language in Global Chat (3rd)");
					p.performCommand("tempmute " + t.getName() + " 30m Foreign Language in Global Chat (3rd)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Foreign Language in Global Chat (4th)");
					p.performCommand("tempmute " + t.getName() + " 2h Foreign Language in Global Chat (4th)");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fifth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Foreign Language in Global Chat (5th)");
					p.performCommand("tempban " + t.getName() + " 1w Foreign Language in Global Chat (5th)");
				}
			}
			/*----------------------------------------------------------------------------------------------------------------*/
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Verbal)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					this.verbal(p, "VerbalFirst");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					this.verbal(p, "VerbalSecond");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					this.verbal(p, "VerbalThird");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					this.verbal(p, "VerbalFourth");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fifth Offence")) {
					p.closeInventory();
					this.verbal(p, "VerbalFifth");
				}
			}
			/*----------------------------------------------------------------------------------------------------------------*/
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Sexual)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					this.sexual(p, "SexualFirst");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					this.sexual(p, "SexualSecond");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					this.sexual(p, "SexualThird");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					this.sexual(p, "SexualFourth");
				}
			}
			/*----------------------------------------------------------------------------------------------------------------*/
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lChat Rules (Exams)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					this.exams(p, "ExamsFirst");
				}
			}
			
		}
	}
	
	public void exams(final Player p, String type) {
		plugin.prompt.put(p, type);
		p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the &cTOTAL &7number of exam questions &cASKED/ANSWERED"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
		p.sendMessage("");
		return;
	}
	public void sexual(final Player p, String type) {
		plugin.prompt.put(p, type);
		p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the &cVICTIM&7's full username"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
		p.sendMessage("");
		return;
	}
	public void verbal(final Player p, String type) {
		plugin.prompt.put(p, type);
		p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the &cVICTIM&7's full username"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
		p.sendMessage("");
		return;
	}

	
	public void locking(final Player p, String type) {
		plugin.prompt.put(p, type);
		p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the &cTOTAL &7number of locked items"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
		p.sendMessage("");
		return;
	}
	
	public void modifications(final Player p, String type) {
		plugin.prompt.put(p, type);
		p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the &cVICTIM&7's full username. If unsure who, or if Government owned, use &eBusinessCraftGov"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
		p.sendMessage("");
		return;
	}
	
	public void stealing(final Player p, String type) {
		plugin.prompt.put(p, type);
		p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the &cVICTIM&7's full username. If unsure who, or if Government owned, use &eBusinessCraftGov"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
		p.sendMessage("");
		return;
	}
	
	public void destruction(final Player p, String type) {
		plugin.prompt.put(p, type);
		p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the &cVICTIM&7's full username. If unsure who, or if Government owned, use &eBusinessCraftGov"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
		p.sendMessage("");
		return;
	}
	
	@EventHandler
	public void onGriefingActions(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (plugin.invs.contains(e.getInventory())) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			e.setCancelled(true);
			OfflinePlayer t = Bukkit.getOfflinePlayer(plugin.targeted.get(p));
			
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lGriefing Rules (Vulgar)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Vulgar Build (1st)");
					p.performCommand("fee " + t.getName() + " 500");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Vulgar Build (2nd)");
					p.performCommand("fee " + t.getName() + " 500");
					return;
					
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Vulgar Build (3rd)");
					p.performCommand("tempban " + t.getName() + " 1d Vulgar Build (3rd)");
					p.performCommand("fee " + t.getName() + " 500");
					return;
					
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Vulgar Build (4th)");
					p.performCommand("tempban " + t.getName() + " 1w Vulgar Build (4th)");
					p.performCommand("fee " + t.getName() + " 500");
					return;
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lGriefing Rules (Locking)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					this.locking(p, "LockingFirst");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					this.locking(p, "LockingSecond");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					this.locking(p, "LockingThird");
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lGriefing Rules (Modifications)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Stage A (1-50 Blocks)")) {
					p.closeInventory();
					this.modifications(p, "ModificationsFirst");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Stage B (51-100 Blocks)")) {
					p.closeInventory();
					this.modifications(p, "ModificationsSecond");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Stage C (101+ Blocks)")) {
					p.closeInventory();
					this.modifications(p, "ModificationsThird");
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lGriefing Rules (Stealing)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					this.stealing(p, "StealingFirst");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					this.stealing(p, "StealingSecond");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					this.stealing(p, "StealingThird");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					this.stealing(p, "StealingFourth");
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lGriefing Rules (Destruction)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					this.destruction(p, "DestructionFirst");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					this.destruction(p, "DestructionSecond");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					this.destruction(p, "DestructionThird");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					this.destruction(p, "DestructionFourth");
				}
			}
			
		}
	}
	
	
	@EventHandler
	public void onRegioningActions(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (plugin.invs.contains(e.getInventory())) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			e.setCancelled(true);
			
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lRegioning Rules (Structure)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					this.regioning(p);
					return;
				}
			}
			
		}
	}

	
	public void bugs(final Player p, String type) {
		plugin.prompt.put(p, type);
		p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the &cTOTAL &7amount of Krunas gained from bugs. If unsure, type &f0"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
		p.sendMessage("");
		return;
	}
	
	public void afk(final Player p, String type) {
		plugin.prompt.put(p, type);
		p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the &cTOTAL &7amount of Krunas gained from being AFK. If unsure, type &f0"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
		p.sendMessage("");
		return;
	}
	
	public void farms(final Player p, String type) {
		plugin.prompt.put(p, type);
		p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the &cTOTAL &7amount of Krunas gained from farms. If unsure, type &f0"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
		p.sendMessage("");
		return;
	}
	
	public void homes1(final Player p, String type) {
		plugin.prompt.put(p, type);
		p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the name of the &cHOMESET"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
		p.sendMessage("");
		return;
	}
	
	public void homes2(final Player p, String type) {
		plugin.prompt.put(p, type);
		if (type.contains(".1")) {
			p.sendMessage("");
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the name of the &cHOMESET"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
			p.sendMessage("");
			return;
		}
		if (type.contains(".2")) {
			p.sendMessage("");
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Please respond with the &cVICTIM&7's full username"));
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7To exit this prompt, respond with \"&fStop&7\" or \"&fNone&7\""));
			p.sendMessage("");
			return;
		}
	}
	
	@EventHandler
	public void onOtherActions(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (plugin.invs.contains(e.getInventory())) {
			if (e.getCurrentItem() == null) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
			e.setCancelled(true);
			OfflinePlayer t = Bukkit.getOfflinePlayer(plugin.targeted.get(p));
			
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (ThreatServer)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 4 Threatening the Server (1st)");
					p.performCommand("tempban " + t.getName() + " 2d Threatening the Server (1st)");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.performCommand("ban " + t.getName() + " Threatening the Server (2nd)");
					p.closeInventory();
					return;
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (ThreatPlayers)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 4 Threatening Players (1st)");
					p.performCommand("tempban " + t.getName() + " 2w Threatening Players (1st)");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.performCommand("ban " + t.getName() + " Threatening Players (2nd)");
					p.closeInventory();
					return;
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (Doxing)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("ban " + t.getName() + " Doxing a Player(s)");
					return;
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (Tickets)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Ticket Abuse (1st)");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Ticket Abuse (2nd)");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Ticket Abuse (3rd)");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Ticket Abuse (4th)");
					p.performCommand("tempban " + t.getName() + " 3d Ticket Abuse (4th)");
					return;
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (Killing)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Killing Staff on a Ticket (1st)");
					p.performCommand("fee " + t.getName() + " 100");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " Killing Staff on a Ticket (2nd)");
					p.performCommand("tempban " + t.getName() + " 1d Killing Staff on a Ticket (2nd)");
					p.performCommand("fee " + t.getName() + " 150");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 2 Killing Staff on a Ticket (3rd)");
					p.performCommand("tempban " + t.getName() + " 1w Killing Staff on a Ticket (3rd)");
					p.performCommand("fee " + t.getName() + " 200");
					return;
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (Scamming)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					p.performCommand("warn " + t.getName() + " -p 4 Scamming (1st)");
					p.performCommand("tempban " + t.getName() + " 1w Scamming (1st)");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					p.performCommand("ban " + t.getName() + " Scamming (2nd)");
					return;
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (Bugs)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					this.bugs(p, "BugsFirst");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					this.bugs(p, "BugsSecond");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					this.bugs(p, "BugsThird");
					return;
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (AFK)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					this.afk(p, "AFKFirst");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					this.afk(p, "AFKSecond");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					this.afk(p, "AFKThird");
					return;
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (AutoFarm)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					this.farms(p, "FarmsFirst");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					this.farms(p, "FarmsSecond");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					this.farms(p, "FarmsThird");
					return;
				}
			}
			if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&c&lOther Rules (Homes)"))) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "First Offence")) {
					p.closeInventory();
					this.homes1(p, "HomesFirst");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Second Offence")) {
					p.closeInventory();
					this.homes2(p, "HomesSecond.1");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Third Offence")) {
					p.closeInventory();
					this.homes2(p, "HomesThird.1");
					return;
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fourth Offence")) {
					p.closeInventory();
					this.homes2(p, "HomesFourth.1");
					return;
				}
			}
			
		}
	}
	
	
	public boolean isNum(String num) {
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
			return false;
		}
		return true;
		
	}
	
}
