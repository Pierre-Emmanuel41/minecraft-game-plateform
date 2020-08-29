package fr.pederobien.minecraftgameplateform.gamerules;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.EGameRuleMessageCode;
import fr.pederobien.minecraftgameplateform.utils.TabCompleterFactory;
import fr.pederobien.minecraftmanagers.WorldManager;

public class Pvp extends GameRule<Boolean> {

	protected Pvp() {
		super("pvp", true, Boolean.class, EGameRuleMessageCode.PVP__EXPLANATION);
		setCompleter(TabCompleterFactory.trueFalseCompleter());
	}

	@Override
	public void setValue(Boolean value) {
		super.setValue(value);
		WorldManager.OVERWORLD.setPVP(value);
		WorldManager.NETHER_WORLD.setPVP(value);
		WorldManager.END_WORLD.setPVP(value);
	}

	@Override
	public CommandExecutor getExecutor() {
		return new CommandExecutor() {
			@Override
			public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
				try {
					String value = args[0];
					if (value.equals("true"))
						setValue(true);
					else if (value.equals("false"))
						setValue(false);
					else {
						sendMessageToSender(sender, ECommonMessageCode.COMMON_BAD_BOOLEAN_FORMAT);
						return false;
					}
					sendMessageToSender(sender, EGameRuleMessageCode.COMMON_VALUE_DEFINED, getName(), value);
				} catch (IndexOutOfBoundsException e) {
					sendMessageToSender(sender, EGameRuleMessageCode.COMMON_VALUE_IS_MISSING, getName());
					return false;
				}
				return true;
			}
		};
	}
}
