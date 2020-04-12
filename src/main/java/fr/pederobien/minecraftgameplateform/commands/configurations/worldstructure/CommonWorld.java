package fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftdevelopmenttoolkit.managers.WorldManager;
import fr.pederobien.minecraftgameplateform.exceptions.WorldNotFoundException;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldStructure;

public abstract class CommonWorld<T extends IWorldStructure> extends AbstractLabelEdition<T> {

	protected CommonWorld(IMessageCode explanation) {
		super(EWorldStructureLabel.WORLD, explanation);
	}

	/**
	 * Method called when no name has been furnished to set the world of the structure.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 */
	protected abstract void onWorldNameIsMissing(CommandSender sender);

	/**
	 * Method called when the given name does not refer to any world.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The name that refer to any world.
	 */
	protected abstract void onWorldDoesNotExist(CommandSender sender, String name);

	/**
	 * Method called when the world of this structure has been correctly defined.
	 * 
	 * @param sender    The entity (generally a player) to send messages.
	 * @param name      The name of the structure.
	 * @param worldName The name of the world.
	 */
	protected abstract void onWorldDefined(CommandSender sender, String name, String worldName);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String name = "";
		try {
			name = args[0];
			get().setWorld(name);
			onWorldDefined(sender, get().getName(), name);
		} catch (IndexOutOfBoundsException e) {
			onWorldNameIsMissing(sender);
			return false;
		} catch (WorldNotFoundException e) {
			onWorldDoesNotExist(sender, e.getName());
			return false;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(Arrays.asList(WorldManager.SURFACE_WORLD.getName(), WorldManager.NETHER_WORLD.getName(), WorldManager.END_WORLD.getName()).stream(), args[0]);
		return super.onTabComplete(sender, command, alias, args);
	}
}