package me.HybridPlague.PunishmentsGUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.Essentials;

import me.HybridPlague.PunishmentsGUI.GUIs.guiAccount;
import me.HybridPlague.PunishmentsGUI.GUIs.guiChat;
import me.HybridPlague.PunishmentsGUI.GUIs.guiClientMods;
import me.HybridPlague.PunishmentsGUI.GUIs.guiGriefing;
import me.HybridPlague.PunishmentsGUI.GUIs.guiMain;
import me.HybridPlague.PunishmentsGUI.GUIs.guiOther;
import me.HybridPlague.PunishmentsGUI.GUIs.guiRegioning;
import me.clip.placeholderapi.PlaceholderAPI;
import me.wiefferink.areashop.AreaShop;
import me.wiefferink.areashop.managers.FileManager;

public class Main extends JavaPlugin {
	
	String prefix;
	public List<Inventory> invs = new ArrayList<Inventory>();
	public HashMap<Player, UUID> targeted = new HashMap<Player, UUID>();
	public HashMap<Player, String> prompt = new HashMap<Player, String>();
	public HashMap<Player, String> homeArg = new HashMap<Player, String>();
		
	public AreaShop areaShop;
	public FileManager fileMan;
	public Essentials ess;
	
	/*
	 * GET CLASSES 
	 */
	public guiMain main;
	public guiAccount account;
	public guiClientMods mods;
	public guiChat chat;
	public guiGriefing griefing;
	public guiRegioning regioning;
	public guiOther other;
	
	@Override
	public void onEnable() {
		this.prefix = "&5&lPunish &8⼁ &f";
		/*
		 * GET CLASSES
		 */
		this.main = new guiMain(this);
		this.account = new guiAccount(this);
		this.mods = new guiClientMods(this);
		this.chat = new guiChat(this);
		this.griefing = new guiGriefing(this);
		this.regioning = new guiRegioning(this);
		this.other = new guiOther(this);
		
		this.getServer().getPluginManager().registerEvents(new PunishmentsEvents(this), this);
		this.saveDefaultConfig();
		
		this.areaShop = (AreaShop) this.getServer().getPluginManager().getPlugin("AreaShop");
		this.fileMan = areaShop.getFileManager();
		this.ess = (Essentials) this.getServer().getPluginManager().getPlugin("Essentials");
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("punish")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command is only executable by a player.");
				return true;
			}
			Player p = (Player) sender;
			if (!p.hasPermission("punishments.open")) {
				p.sendMessage(ChatColor.RED + "Insufficient permission.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "/punish <player>"));
				return true;
			} else if (args.length > 0) {
				UUID targetID = Bukkit.getOfflinePlayer(args[0]).getUniqueId();
				if (Bukkit.getOfflinePlayer(targetID).hasPlayedBefore()
						|| Bukkit.getOfflinePlayer(targetID).isOnline()) { // Player exists
					
					String groups = "%vault_ranks%";
					groups = PlaceholderAPI.setPlaceholders(Bukkit.getOfflinePlayer(args[0]), groups).toLowerCase();
					
					if (groups.contains("moderator")
							|| groups.contains("helper")
							|| groups.contains("trialmoderator")
							|| groups.contains("administrator")
							|| groups.contains("senioradministrator")
							|| groups.contains("owner")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "You cannot punish that player!"));
						return true;
					}
					
					main.openMainMenu(p, targetID);
					this.targeted.put(p, targetID);
					return true;
				} else { // Player cannot be found 
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "Player unknown"));
					return true;
				}
			}
		}
		return false;
	}
}
