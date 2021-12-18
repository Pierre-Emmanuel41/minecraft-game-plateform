package fr.pederobien.minecraft.gameplateform.exceptions.configurations;

import org.bukkit.entity.Player;

import fr.pederobien.minecraft.gameplateform.interfaces.element.IGameConfiguration;

public class PlayerNotRegisteredException extends GameConfigurationException {
	private static final long serialVersionUID = 1L;
	private Player notRegisteredPlayer;

	public PlayerNotRegisteredException(IGameConfiguration gameConfiguration, Player notRegisteredPlayer) {
		super(gameConfiguration);
		this.notRegisteredPlayer = notRegisteredPlayer;
	}

	@Override
	protected String getInternalMessage() {
		return "The player " + getNotRegisteredPlayer().getName() + " is not registered in a team for configuration " + getGameConfiguration().getName();
	}

	/**
	 * @return The not registered player.
	 */
	public Player getNotRegisteredPlayer() {
		return notRegisteredPlayer;
	}
}
