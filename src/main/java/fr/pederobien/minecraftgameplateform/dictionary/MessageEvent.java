package fr.pederobien.minecraftgameplateform.dictionary;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class MessageEvent implements IMessageEvent {
	private Player player;
	private Plugin plugin;
	private IMessageCode code;
	private String[] args;

	public MessageEvent(Player player, Plugin plugin, IMessageCode code, String[] args) {
		this.player = player;
		this.plugin = plugin;
		this.code = code;
		this.args = args;
	}

	@Override
	public Player getPlayer() {
		return player;
	}

	@Override
	public Plugin getPlugin() {
		return plugin;
	}

	@Override
	public IMessageCode getCode() {
		return code;
	}

	@Override
	public String[] getArgs() {
		return args;
	}
}
