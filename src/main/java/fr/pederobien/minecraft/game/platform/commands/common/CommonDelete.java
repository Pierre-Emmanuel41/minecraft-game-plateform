package fr.pederobien.minecraft.game.platform.commands.common;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.game.platform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraft.game.platform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraft.game.platform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public abstract class CommonDelete<T extends IUnmodifiableNominable> extends AbstractLabelEdition<T> {

	protected CommonDelete(IMinecraftMessageCode explanation) {
		super(ECommonLabel.DELETE, explanation);
	}

	/**
	 * Method called when the method {@link IMinecraftPersistence#delete(String)} returns false.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The name used to delete the object's file.
	 */
	protected abstract void onDidNotDelete(CommandSender sender, String name);

	/**
	 * Method called when the file associated to the given name has been correctly deleted.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The name of the deleted object.
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
		if (args.length == 0) {
			onNameIsMissing(sender);
			return false;
		}
		for (String name : args) {
			if (startWithIgnoreCase(name, "default")) {
				sendSynchro(sender, ECommonMessageCode.COMMON_NAME_MUST_NOT_START_WITH_DEFAULT, name);
				return false;
			}
			if (!getPersistence().delete(name)) {
				onDidNotDelete(sender, name);
				return false;
			}
			onDeleted(sender, name);
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> alreadyMentionnedFiles = asList(args);
		return filter(getPersistence().list().stream().filter(name -> !startWithIgnoreCase(name, "default") && !alreadyMentionnedFiles.contains(name)), args);
	}
}
