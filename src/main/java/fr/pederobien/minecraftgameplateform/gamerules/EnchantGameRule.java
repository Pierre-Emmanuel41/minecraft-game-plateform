package fr.pederobien.minecraftgameplateform.gamerules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.EGameRuleMessageCode;

public class EnchantGameRule extends EventRunnableGameRule<Integer> {
	private Enchantment enchantment;
	private List<Material> items;

	public EnchantGameRule(String name, Enchantment enchantment, IMinecraftMessageCode explanation) {
		super(name, enchantment.getMaxLevel(), Integer.class, explanation);
		this.enchantment = enchantment;
		items = new ArrayList<Material>();
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onEnchantItemEvent(EnchantItemEvent event) {
		if (!isRunning() || !items.contains(event.getItem().getType()))
			return;

		for (Map.Entry<Enchantment, Integer> entry : event.getEnchantsToAdd().entrySet())
			if (entry.getKey().equals(enchantment) && entry.getValue() > getValue()) {
				event.setCancelled(true);
				sendMessageToSenderNotSynchonized(event.getEnchanter(), EGameRuleMessageCode.ENCHANT__CANNOT_ENCHANT, enchantment.getKey().getKey(), getValue(),
						entry.getValue());
			}
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onInventoryClickEvent(InventoryClickEvent event) {
		if (!isRunning() || !(event.getInventory() instanceof AnvilInventory))
			return;

		AnvilInventory anvilInventory = (AnvilInventory) event.getInventory();
		ItemStack result = anvilInventory.getItem(2);

		if (result == null)
			return;

		for (Map.Entry<Enchantment, Integer> entry : result.getEnchantments().entrySet()) {
			if (entry.getKey().equals(enchantment) && entry.getValue() > getValue()) {
				event.setCancelled(true);
				sendMessageToSenderNotSynchonized(event.getWhoClicked(), EGameRuleMessageCode.ENCHANT__CANNOT_ENCHANT, enchantment.getKey().getKey(), getValue(),
						entry.getValue());
			}
		}
	}

	@Override
	public CommandExecutor getExecutor() {
		return new CommandExecutor() {
			@Override
			public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
				try {
					setValue(Integer.parseInt(args[0]));
					sendMessageToSender(sender, EGameRuleMessageCode.COMMON_VALUE_DEFINED_IN_GAME, getName(), getValue());
				} catch (IndexOutOfBoundsException e) {
					sendMessageToSender(sender, EGameRuleMessageCode.COMMON_VALUE_IS_MISSING, getName());
					return false;
				} catch (NumberFormatException e) {
					sendMessageToSender(sender, ECommonMessageCode.COMMON_BAD_INTEGER_FORMAT);
					return false;
				}
				return true;
			}
		};
	}

	@Override
	public TabCompleter getCompleter() {
		return new TabCompleter() {

			@Override
			public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
				return Arrays.asList(getMessageFromDictionary(sender, EGameRuleMessageCode.MAX_LEVEL__ON_TAB_COMPLETE));
			}
		};
	}

	public EnchantGameRule setTargetItems(Material... items) {
		this.items = Arrays.asList(items);
		return this;
	}
}
