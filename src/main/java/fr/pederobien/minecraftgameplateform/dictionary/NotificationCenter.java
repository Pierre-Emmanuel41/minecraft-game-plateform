package fr.pederobien.minecraftgameplateform.dictionary;

import java.util.stream.Stream;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IDictionaryManager;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.INotificationCenter;
import fr.pederobien.minecraftgameplateform.utils.EventFactory;
import fr.pederobien.minecraftmanagers.BukkitManager;
import fr.pederobien.minecraftmanagers.MessageManager;
import fr.pederobien.minecraftmanagers.PlayerManager;

public class NotificationCenter implements INotificationCenter {
	private IDictionaryManager dictionaryManager;

	private NotificationCenter() {
		dictionaryManager = new DictionaryManager();
	}

	public static INotificationCenter getInstance() {
		return SingletonHolder.CENTER;
	}

	private static class SingletonHolder {
		public static final INotificationCenter CENTER = new NotificationCenter();
	}

	@Override
	public void sendMessage(IMessageEvent event) {
		switch (event.getCode().getPermission()) {
		case ALL:
			sendMessage(PlayerManager.getPlayers(), event);
			break;
		case OPERATORS:
			sendMessage(BukkitManager.getOnlineOperators(), event);
			break;
		case SENDER:
			sendInternalMessage(event);
			break;
		}
	}

	@Override
	public IDictionaryContext getDictionaryContext() {
		return dictionaryManager;
	}

	private void sendInternalMessage(IMessageEvent event) {
		MessageManager.sendMessage(event.getPlayer(), dictionaryManager.getMessage(event));
	}

	private void sendMessage(Player player, IMessageEvent event) {
		sendInternalMessage(EventFactory.messageEvent(player, event.getPlugin(), event.getCode(), event.getArgs()));
	}

	private void sendMessage(Stream<Player> players, IMessageEvent event) {
		players.parallel().forEach(player -> sendMessage(player, event));
	}
}
