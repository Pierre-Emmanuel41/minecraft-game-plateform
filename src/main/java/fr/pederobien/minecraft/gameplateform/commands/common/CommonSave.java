package fr.pederobien.minecraft.gameplateform.commands.common;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.gameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public abstract class CommonSave<T extends IUnmodifiableNominable> extends AbstractLabelEdition<T> {

	protected CommonSave(IMinecraftMessageCode explanation) {
		super(ECommonLabel.SAVE, explanation);
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
