package fr.pederobien.minecraftgameplateform.commands.configurations;

import java.util.List;
import java.util.StringJoiner;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public abstract class CommonList<T extends IUnmodifiableNominable> extends AbstractLabelEdition<T> {

	protected CommonList(IMessageCode explanation) {
		super(ECommonLabel.LIST, explanation);
	}

	/**
	 * Method called when the list returned by the method {@link IPersistence#list()} contains no element. This method should be never
	 * called because there is minimum the default object file.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 */
	protected abstract void onNoElement(CommandSender sender);

	/**
	 * Method called when the list returned by the method {@link IPersistence#list()} contains one element.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The name of the element.
	 */
	protected abstract void onOneElement(CommandSender sender, String name);

	/**
	 * Method called when the list returned by the method {@link IPersistence#list()} contains more than one element. The name of each
	 * element are gathered into one string with delimiter equal "\n". For example, with name1, name2, name3 :<br>
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
			onOneElement(sender, concat(list));
			break;
		default:
			onSeveralElement(sender, concat(list));
			break;
		}
		return true;
	}

	private String concat(List<String> list) {
		StringJoiner joiner = new StringJoiner("\n");
		for (String name : list)
			joiner.add(name);
		return joiner.toString();
	}
}
