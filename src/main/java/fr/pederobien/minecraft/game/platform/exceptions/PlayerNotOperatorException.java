package fr.pederobien.minecraft.game.platform.exceptions;

import org.bukkit.entity.Player;

public class PlayerNotOperatorException extends PlatformException {
	private static final long serialVersionUID = 1L;
	private Player player;

	public PlayerNotOperatorException(Player player) {
		super(String.format("%s is not an operator", player.getName()));
		this.player = player;
	}

	/**
	 * @return The player that is not an operator.
	 */
	public Player getPlayer() {
		return player;
	}
}
