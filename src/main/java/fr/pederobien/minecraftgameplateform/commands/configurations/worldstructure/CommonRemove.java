package fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldStructure;

public abstract class CommonRemove<T extends IWorldStructure> extends AbstractWorldStructureEdition<T> {

	protected CommonRemove(IMessageCode explanation) {
		super(EWorldStructureLabel.REMOVE, explanation);
	}

	/**
	 * Method called just after the call to the method {@link IWorldStructure#remove()}.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The removed structure's name.
	 * @param world  The name of the world from which the structure has been removed.
	 */
	protected abstract void onRemoved(CommandSender sender, String name, String world);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		get().remove();
		onRemoved(sender, get().getName(), get().getWorld().getName());
		return true;
	}
}
