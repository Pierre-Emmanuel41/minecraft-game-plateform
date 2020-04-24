package fr.pederobien.minecraftgameplateform.exceptions.configurations;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;

public class PlayerAlreadyRegisteredException extends GameConfigurationException {
	private static final long serialVersionUID = 1L;
	private Player alreadyRegisteredPlayer;
	private ITeam team;

	public PlayerAlreadyRegisteredException(IGameConfiguration gameConfiguration, ITeam team, Player alreadyRegisteredPlayer) {
		super(gameConfiguration);
		this.alreadyRegisteredPlayer = alreadyRegisteredPlayer;
		this.team = team;
	}

	@Override
	protected String getInternalMessage() {
		return "The player \"" + getAlreadyRegisteredPlayer() + "\" is already registered for configuration " + getGameConfiguration().getName();
	}

	/**
	 * @return The already registered player.
	 */
	public Player getAlreadyRegisteredPlayer() {
		return alreadyRegisteredPlayer;
	}

	/**
	 * @return The team in which the player is already registered.
	 */
	public ITeam getTeam() {
		return team;
	}
}
