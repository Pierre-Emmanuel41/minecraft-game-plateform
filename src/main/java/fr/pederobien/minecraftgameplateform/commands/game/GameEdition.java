package fr.pederobien.minecraftgameplateform.commands.game;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractSimpleMapEdition;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class GameEdition extends AbstractSimpleMapEdition {
	private JavaPlugin plugin;

	public GameEdition(String label, IMinecraftMessageCode explanation, JavaPlugin plugin) {
		super(label, explanation);
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (Plateform.getGameConfigurationContext().getGameConfiguration() == null) {
			sendSynchro(sender, EGameMessageCode.NO_CONFIGURATION_SETTED, (Object[]) args);
			return false;
		}
		return true;
	}

	/**
	 * @return The plugin in which this edition is defined.
	 */
	protected JavaPlugin getPlugin() {
		return plugin;
	}

	/**
	 * @return The list of all registered commands.
	 */
	protected List<ICommand> getCommands() {
		return Plateform.getCommandHelper().getCommands();
	}

	/**
	 * Notify each command registered in the list <code>commands</code> using the given consumer.
	 * 
	 * @param commands A list of commands to notify.
	 * @param consumer The consumer used to notify commands.
	 */
	protected void notifyCommands(List<ICommand> commands, Consumer<ICommand> consumer) {
		for (ICommand command : commands)
			consumer.accept(command);
	}

	/**
	 * Notify each command registered in the list <code>commands</code> using the given predicate.
	 * 
	 * @param commands  A list of commands to notify.
	 * @param predicate The predicate used to notify commands.
	 * @param result    A boolean that represent the result of the notification.
	 * @return A boolean that correspond to the global result of each command notification.
	 */
	protected boolean notifyCommands(List<ICommand> commands, Predicate<ICommand> predicate, boolean result) {
		for (ICommand command : commands)
			result &= predicate.test(command);
		return result;
	}
}
