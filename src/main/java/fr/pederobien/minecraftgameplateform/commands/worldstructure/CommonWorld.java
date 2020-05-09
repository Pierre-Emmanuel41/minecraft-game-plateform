package fr.pederobien.minecraftgameplateform.commands.worldstructure;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.exceptions.worldstructure.WorldNotFoundException;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldStructure;
import fr.pederobien.minecraftmanagers.WorldManager;

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
			sendMessageToSender(sender, ECommonMessageCode.COMMON_WORLD_DOES_NOT_EXIST, name);
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
