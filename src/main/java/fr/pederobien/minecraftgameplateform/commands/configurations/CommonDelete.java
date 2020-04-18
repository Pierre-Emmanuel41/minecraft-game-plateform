package fr.pederobien.minecraftgameplateform.commands.configurations;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public abstract class CommonDelete<T extends IUnmodifiableNominable> extends AbstractLabelEdition<T> {

	protected CommonDelete(IMessageCode explanation) {
		super(ECommonLabel.DELETE, explanation);
	}

	/**
	 * Method called when the method {@link IPersistence#delete(String)} returns false.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The name used to delete the object's file.
	 */
	protected abstract void onDidNotDelete(CommandSender sender, String name);

	/**
	 * Method called when the file associated to the given name has been correctly deleted.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The name of the deleted spawn.
	 */
	protected abstract void onDeleted(CommandSender sender, String name);

	/**
	 * Method called when no name has been given to delete the file.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 */
	protected abstract void onNameIsMissing(CommandSender sender);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			String name = args[0];
			if (startWithIgnoreCase(name, "default")) {
				sendMessageToSender(sender, ECommonMessageCode.COMMON_NAME_MUST_NOT_START_WITH_DEFAULT, name);
				return false;
			}
			if (!getPersistence().delete(name)) {
				onDidNotDelete(sender, name);
				return false;
			}
			onDeleted(sender, name);
		} catch (IndexOutOfBoundsException e) {
			onNameIsMissing(sender);
			return false;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return filter(getPersistence().list().stream().filter(name -> !startWithIgnoreCase(name, "default")), args[0]);
	}
}
