package fr.pederobien.minecraft.game.platform.commands.common;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.game.platform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraft.game.platform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public abstract class CommonList<T extends IUnmodifiableNominable> extends AbstractLabelEdition<T> {

	protected CommonList(IMinecraftMessageCode explanation) {
		super(ECommonLabel.LIST, explanation);
	}

	/**
	 * Method called when the list returned by the method {@link IMinecraftPersistence#list()} contains no element. This method should
	 * be never called because there is minimum the default object file.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 */
	protected abstract void onNoElement(CommandSender sender);

	/**
	 * Method called when the list returned by the method {@link IMinecraftPersistence#list()} contains one element.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The name of the element.
	 */
	protected abstract void onOneElement(CommandSender sender, String name);

	/**
	 * Method called when the list returned by the method {@link IMinecraftPersistence#list()} contains more than one element. The
	 * name of each element are gathered into one string with delimiter equal "\n". For example, with name1, name2, name3 :<br>
	 * <br>
	 * <code>name1\n<br>
	 * name2\n<br>
	 * name3</code>
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param names  The concatenation of each element's name.
	 */
	protected abstract void onSeveralElement(CommandSender sender, String names);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		List<String> list = getPersistence().list();

		if (get() != null && !list.contains(get().getName()))
			list.add(get().getName());

		switch (list.size()) {
		case 0:
			onNoElement(sender);
			break;
		case 1:
			onOneElement(sender, concat(list, "\n"));
			break;
		default:
			onSeveralElement(sender, concat(list, "\n"));
			break;
		}
		return true;
	}
}
