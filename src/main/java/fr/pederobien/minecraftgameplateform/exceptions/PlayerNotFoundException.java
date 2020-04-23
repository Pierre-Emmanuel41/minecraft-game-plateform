package fr.pederobien.minecraftgameplateform.exceptions;

public class PlayerNotFoundException extends SimpleMessageException {
	private static final long serialVersionUID = 1L;
	private String playerName;

	public PlayerNotFoundException(String playerName) {
		super("The name \"" + playerName + "\" does not correspond to a player");
		this.playerName = playerName;
	}

	/**
	 * @return The player's name that correspond to any player.
	 */
	public String getPlayerName() {
		return playerName;
	}
}
