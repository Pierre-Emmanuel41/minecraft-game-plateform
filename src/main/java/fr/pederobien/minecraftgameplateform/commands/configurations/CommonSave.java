package fr.pederobien.minecraftgameplateform.commands.configurations;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.impl.editions.AbstractMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public abstract class CommonSave<T extends IUnmodifiableNominable> extends AbstractMapPersistenceEdition<T> {

	protected CommonSave(IMessageCode explanation) {
		super("Save", explanation);
	}

	/**
	 * Method call when the object has been saved.
	 * 
	 * @param name The object's name.
	 */
	protected abstract void onSave(CommandSender sender, String name);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		getPersistence().save();
		onSave(sender, get().getName());
		return true;
	}
}
