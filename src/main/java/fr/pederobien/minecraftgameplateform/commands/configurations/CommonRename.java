package fr.pederobien.minecraftgameplateform.commands.configurations;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.INominable;

public abstract class CommonRename<T extends INominable> extends AbstractMapPersistenceEdition<T> {

	protected CommonRename(IMessageCode explanation) {
		super("rename", explanation);
	}

	/**
	 * Method called when trying to rename an object with a name already taken.
	 * 
	 * @param sender      The entity (generally a player) to send messages.
	 * @param currentName The name of the current object.
	 * @param newName     The name already taken.
	 */
	protected abstract void onNameAlreadyTaken(CommandSender sender, String currentName, String newName);

	/**
	 * Method called when no name has been given to rename the object.
	 * 
	 * @param sender  The entity (generally a player) to send messages.
	 * @param oldName The old name of the object.
	 */
	protected abstract void onNameIsMissing(CommandSender sender, String oldName);

	/**
	 * Method called when the renaming of a new object has been correctly done.
	 * 
	 * @param sender  The entity (generally a player) to send messages.
	 * @param oldName The old name of the object.
	 * @param newName The new name of the object.
	 */
	protected abstract void onRenamed(CommandSender sender, String oldName, String newName);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			String newName = args[0];

			// Check if the name is already taken.
			if (getPersistence().exist(newName)) {
				onNameAlreadyTaken(sender, get().getName(), newName);
				return false;
			}

			// Keep the old name in memory
			String oldName = get().getName();
			get().setName(newName);
			onRenamed(sender, oldName, newName);
		} catch (IndexOutOfBoundsException e) {
			onNameIsMissing(sender, get().getName());
			return false;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(getMessageFromDictionary(sender, ECommonMessageCode.COMMON_RENAME__TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
