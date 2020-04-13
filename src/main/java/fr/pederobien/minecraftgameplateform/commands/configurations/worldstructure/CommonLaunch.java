package fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.EWorldStructureMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldStructure;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;

public abstract class CommonLaunch<T extends IWorldStructure> extends AbstractWorldStructureEdition<T> {

	public CommonLaunch(IMessageCode explanation) {
		super(EWorldStructureLabel.LAUNCH, explanation);
	}

	/**
	 * Method called when no argument has been furnished and no structure is defined.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 */
	protected abstract void onNoStructure(CommandSender sender);

	/**
	 * Method called when the structure has been correctly launched.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The name of structure.
	 * @param x      The x-Coordinates of the structure's center.
	 * @param y      The y-Coordinates of the structure's center.
	 * @param z      The z-Coordinates of the structure's center.
	 */
	protected abstract void onLaunched(CommandSender sender, String name, int x, int y, int z);

	/**
	 * Method called when the given name does not refer to any existing structure in the folder of ther persistence.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The given name that correspond to nothing.
	 * 
	 * @see IPersistence#load(String)
	 */
	protected abstract void onNotExist(CommandSender sender, String name);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String name = "";

		// Launching the current structure
		if (args.length == 0) {
			if (get() == null) {
				onNoStructure(sender);
				return false;
			}
			get().launch();
			onLaunched(sender, get().getName(), get().getCenter().getX(), get().getCenter().getY(), get().getCenter().getZ());
			return true;
		}

		// Launching another structure
		if (args.length < 2) {
			getPersistence().save();
			try {
				name = args[0];
				getPersistence().load(name).get().launch();
				onLaunched(sender, name, get().getCenter().getX(), get().getCenter().getY(), get().getCenter().getZ());
				return true;
			} catch (FileNotFoundException e) {
				onNotExist(sender, name);
				return false;
			}
		}

		// Launching the current structure but changing center's coordinates
		if (args.length < 4) {
			try {
				get().setCenter(args[0], args[1], args[2]);
				get().launch();
				onLaunched(sender, name, get().getCenter().getX(), get().getCenter().getY(), get().getCenter().getZ());
				return true;
			} catch (IndexOutOfBoundsException e) {
				sendMessageToSender(sender, EWorldStructureMessageCode.COMMON_MISSING_COORDINATES);
				return false;
			} catch (NumberFormatException e) {
				sendMessageToSender(sender, ECommonMessageCode.COMMON_BAD_INTEGER_FORMAT);
				return false;
			}
		}

		// Launching another structure and changing its center's coordinates
		name = args[0];
		getPersistence().save();
		try {
			getPersistence().load(name).get().setCenter(args[1], args[2], args[3]);
			get().launch();
			onLaunched(sender, name, get().getCenter().getX(), get().getCenter().getY(), get().getCenter().getZ());
			return true;
		} catch (FileNotFoundException e) {
			onNotExist(sender, name);
			return false;
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, EWorldStructureMessageCode.COMMON_MISSING_COORDINATES);
			return false;
		} catch (NumberFormatException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_BAD_INTEGER_FORMAT);
			return false;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> list = getPersistence().list();

		switch (args.length) {
		case 1:
			// When there is a current structure defined
			if (get() != null) {
				// Adding possibility to define center's coordinates
				list.add("[<X> <Y> <Z>]");

				// When the current structure has not been saved yet
				if (!list.contains(get().getName()))
					list.add(get().getName());
			}
			return filter(list.stream(), args[0]);
		default:
			// First time
			// If the first arguments is a spawn name then args start from 1
			return checkCoordinates(extract(args, list.contains(args[0]) ? 1 : 0));
		}
	}

	private List<String> checkCoordinates(String[] args) {
		switch (args.length) {
		case 1:
			return check(args[0], e -> isNotStrictInt(e), Arrays.asList("[<X> <Y> <Z>]"));
		case 2:
			return check(args[1], e -> isNotStrictInt(e), check(args[0], e -> isStrictInt(e), Arrays.asList("<Y> <Z>")));
		case 3:
			return check(args[2], e -> isNotStrictInt(e), check(args[1], e -> isStrictInt(e), Arrays.asList("<Z>")));
		}
		return emptyList();
	}
}
