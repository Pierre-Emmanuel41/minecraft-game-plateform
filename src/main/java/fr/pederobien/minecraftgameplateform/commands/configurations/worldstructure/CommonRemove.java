package fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldStructure;

public abstract class CommonRemove<T extends IWorldStructure> extends AbstractWorldStructureEdition<T> {

	protected CommonRemove(IMessageCode explanation) {
		super("remove", explanation);
	}

	/**
	 * Method called just after the call to the method {@link IWorldStructure#remove()}.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The removed structure's name.
	 */
	protected abstract void onRemoved(CommandSender sender, String name);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		get().remove();
		onRemoved(sender, get().getName());
		return true;
	}
}
