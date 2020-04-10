package fr.pederobien.minecraftgameplateform.impl.editions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftdevelopmenttoolkit.exceptions.ArgumentNotFoundException;
import fr.pederobien.minecraftdevelopmenttoolkit.exceptions.NotAvailableArgumentException;
import fr.pederobien.minecraftdevelopmenttoolkit.exceptions.NotAvailableCommandException;
import fr.pederobien.minecraftdevelopmenttoolkit.impl.AbstractGenericParentEdition;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.INotificationCenter;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;
import fr.pederobien.minecraftgameplateform.utils.EventFactory;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public abstract class AbstractParentPersistenceEdition<T extends IUnmodifiableNominable>
		extends AbstractGenericParentEdition<IMessageCode, T, IParentPersistenceEdition<T>, IMapPersistenceEdition<T>> implements IParentPersistenceEdition<T> {
	private IPersistence<T> persistence;
	private Plugin plugin;
	private List<IMapPersistenceEdition<T>> descendants;

	public AbstractParentPersistenceEdition(String label, IMessageCode explanation, Plugin plugin, IPersistence<T> persistence) {
		super(label, explanation, new ParentPersistenceHelper<T>(plugin));
		this.persistence = persistence;
		this.plugin = plugin;

		descendants = new ArrayList<IMapPersistenceEdition<T>>();
	}

	@Override
	public final IParentPersistenceEdition<T> setAvailable(boolean available) {
		internalSetAvailable(available);
		return this;
	}

	@Override
	public final IParentPersistenceEdition<T> setModifiable(boolean modifiable) {
		internalSetModifiable(modifiable);
		return this;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			return super.onCommand(sender, command, label, args);
		} catch (ArgumentNotFoundException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_ARGUMENT_NOT_FOUND, e.getNotFoundArgument(), e.getLabel());
		} catch (NotAvailableArgumentException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_NOT_AVAILABLE_ARGUMENT, e.getArgument(), e.getLabel());
		} catch (NotAvailableCommandException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_NOT_AVAILABLE_COMMAND, e.getLabel());
		}
		return false;
	}

	@Override
	public final IParentPersistenceEdition<T> addEdition(IMapPersistenceEdition<T> elt) {
		elt.setParent(this);
		elt.setAvailable(false);
		internalAdd(elt);
		addToDescendant(elt);
		return this;
	}

	@Override
	public final IParentPersistenceEdition<T> removeEdition(IMapPersistenceEdition<T> elt) {
		elt.setParent(null);
		elt.setAvailable(true);
		internalRemove(elt);
		removeFromDescendant(elt);
		return this;
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

	@Override
	public List<IMapPersistenceEdition<T>> getChildrenByLabelName(String labelName) {
		return descendants.stream().filter(e -> e.getLabel().equals(labelName)).collect(Collectors.toList());
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

	private void addToDescendant(IMapPersistenceEdition<T> elt) {
		for (IMapPersistenceEdition<T> e : elt.getChildren().values())
			addToDescendant(e);
		descendants.add(elt);
	}

	private void removeFromDescendant(IMapPersistenceEdition<T> elt) {
		for (IMapPersistenceEdition<T> e : elt.getChildren().values())
			removeFromDescendant(e);
		descendants.remove(elt);
	}
}
