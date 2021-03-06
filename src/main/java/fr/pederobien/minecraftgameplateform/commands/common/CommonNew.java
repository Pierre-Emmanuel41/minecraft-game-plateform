package fr.pederobien.minecraftgameplateform.commands.common;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public abstract class CommonNew<T extends IUnmodifiableNominable> extends AbstractLabelEdition<T> {

	protected CommonNew(IMinecraftMessageCode explanation) {
		super(ECommonLabel.NEW, explanation);
	}

	/**
	 * Method called when trying to create an object with a name already taken.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The given name already taken.
	 */
	protected abstract void onNameAlreadyTaken(CommandSender sender, String name);

	/**
	 * Method called when no name has been given to create the object.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 */
	protected abstract void onNameIsMissing(CommandSender sender);

	/**
	 * Method called to create a new object <code>T</code>
	 * 
	 * @param name The name of the created object.
	 * 
	 * @return The created object.
	 */
	protected abstract T create(String name);

	/**
	 * Method called when the creation of a new object has been correctly done.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The name of the created object.
	 */
	protected abstract void onCreated(CommandSender sender, String name);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			String name = args[0];

			// Check if the name is already taken.
			if (getPersistence().exist(name)) {
				onNameAlreadyTaken(sender, name);
				return false;
			}

			// The name of all new created object must not start with default.
			if (startWithIgnoreCase(name, "default")) {
				sendSynchro(sender, ECommonMessageCode.COMMON_NAME_MUST_NOT_START_WITH_DEFAULT, name);
				return false;
			}

			// Save the current object managed by the persistence.
			getPersistence().save();

			// Create a new object
			getPersistence().set(create(name));
			onCreated(sender, name);
		} catch (IndexOutOfBoundsException e) {
			onNameIsMissing(sender);
			return false;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return asList(getMessage(sender, ECommonMessageCode.COMMON_NEW_TAB_COMPLETE));
		default:
			return emptyList();
		}
	}
}
