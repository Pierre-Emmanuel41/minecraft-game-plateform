package fr.pederobien.minecraftgameplateform.impl.editions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftdevelopmenttoolkit.exceptions.ArgumentNotFoundException;
import fr.pederobien.minecraftdevelopmenttoolkit.impl.AbstractGenericParentEdition;
import fr.pederobien.minecraftdevelopmenttoolkit.interfaces.IGenericMapEdition;
import fr.pederobien.minecraftdevelopmenttoolkit.interfaces.IGenericParentEdition;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.INotificationCenter;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;
import fr.pederobien.minecraftgameplateform.utils.EventFactory;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class AbstractParentPersistenceEdition<T extends IUnmodifiableNominable> extends AbstractGenericParentEdition<IMessageCode, T, IParentPersistenceEdition<T>>
		implements IParentPersistenceEdition<T> {
	private IPersistence<T> persistence;
	private Plugin plugin;

	public AbstractParentPersistenceEdition(String label, IMessageCode explanation, Plugin plugin, IPersistence<T> persistence) {
		super(label, explanation, new ParentPersistenceHelper<T>(plugin));
		this.persistence = persistence;
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			return super.onCommand(sender, command, label, args);
		} catch (ArgumentNotFoundException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_ARGUMENT_NOT_FOUND, e.getNotFoundArgument(), e.getLabel());
		}
		return false;
	}

	@Override
	public IGenericParentEdition<IMessageCode, T, IParentPersistenceEdition<T>> addEdition(IGenericMapEdition<IMessageCode, T, IParentPersistenceEdition<T>> elt) {
		elt.setParent(this);
		elt.setAvailable(false);
		return super.addEdition(elt);
	}

	@Override
	public IGenericParentEdition<IMessageCode, T, IParentPersistenceEdition<T>> removeEdition(IGenericMapEdition<IMessageCode, T, IParentPersistenceEdition<T>> elt) {
		elt.setParent(null);
		elt.setAvailable(true);
		return super.removeEdition(elt);
	}

	@Override
	public T get() {
		return getPersistence().get();
	}

	@Override
	public void set(T element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IPersistence<T> getPersistence() {
		return persistence;
	}

	@Override
	public Plugin getPlugin() {
		return plugin;
	}

	/**
	 * Send a message to the given player. First create an {@link IMessageEvent} that is used to get messages into registered
	 * dictionaries for the given Plugin.
	 * 
	 * @param player The player to send a message.
	 * @param plugin The plugin into the message is associated.
	 * @param code   The code used to get the translation of the message in the player's language.
	 * @param args   Arguments that could be useful to send dynamic messages.
	 * 
	 * @return The created message event.
	 */
	protected void sendMessageToSender(CommandSender sender, IMessageCode code, Object... args) {
		if (sender instanceof Player)
			getNotificationCenter().sendMessage(messageEvent((Player) sender, code, args));
	}

	private INotificationCenter getNotificationCenter() {
		return Plateform.getNotificationCenter();
	}

	private IMessageEvent messageEvent(Player player, IMessageCode code, Object... args) {
		String[] internalArgs = new String[args.length];
		for (int i = 0; i < args.length; i++)
			internalArgs[i] = args[i].toString();
		return EventFactory.messageEvent(player, getPlugin(), code, internalArgs);
	}
}
