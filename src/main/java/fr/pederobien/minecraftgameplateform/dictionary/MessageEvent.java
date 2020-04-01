package fr.pederobien.minecraftgameplateform.dictionary;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class MessageEvent extends MessageCodeEvent implements IMessageEvent {
	private Player player;

	public MessageEvent(Player player, Plugin plugin, IMessageCode code, String[] args) {
		super(plugin, code, args);
		this.player = player;
	}

	@Override
	public Player getPlayer() {
		return player;
	}
}
