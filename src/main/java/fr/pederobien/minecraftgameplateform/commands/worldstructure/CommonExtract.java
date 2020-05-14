package fr.pederobien.minecraftgameplateform.commands.worldstructure;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldStructure;

public abstract class CommonExtract<T extends IWorldStructure> extends AbstractWorldStructureEdition<T> {

	protected CommonExtract(IMinecraftMessageCode explanation) {
		super(EWorldStructureLabel.EXTRACT, explanation);
	}

	/**
	 * Method called just after the call to the method {@link IWorldStructure#extract()}
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The name of the structure.
	 */
	protected abstract void onExtracted(CommandSender sender, String name);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		get().extract();
		onExtracted(sender, get().getName());
		return true;
	}
}
