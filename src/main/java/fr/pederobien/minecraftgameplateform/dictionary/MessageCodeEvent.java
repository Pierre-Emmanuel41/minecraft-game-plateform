package fr.pederobien.minecraftgameplateform.dictionary;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCodeEvent;

public class MessageCodeEvent implements IMessageCodeEvent {
	private Plugin plugin;
	private IMessageCode code;
	private String[] args;

	public MessageCodeEvent(Plugin plugin, IMessageCode code, String... args) {
		this.plugin = plugin;
		this.code = code;
		this.args = args;
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
