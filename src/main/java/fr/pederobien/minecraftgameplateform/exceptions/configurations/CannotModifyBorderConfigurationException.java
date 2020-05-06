package fr.pederobien.minecraftgameplateform.exceptions.configurations;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.exceptions.SimpleMessageException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;

public class CannotModifyBorderConfigurationException extends SimpleMessageException {
	private static final long serialVersionUID = 1L;
	private IBorderConfiguration configuration;
	private CommandSender sender;

	public CannotModifyBorderConfigurationException(IBorderConfiguration configuration, CommandSender sender) {
		super("The player " + sender.getName() + " is not allowed to modify configuration " + configuration.getName());
		this.configuration = configuration;
		this.sender = sender;
	}

	/**
	 * @return The configuration the player try to modify.
	 */
	public IBorderConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * @return The player not allowed to modify the configuration.
	 */
	public CommandSender getSender() {
		return sender;
	}
}
