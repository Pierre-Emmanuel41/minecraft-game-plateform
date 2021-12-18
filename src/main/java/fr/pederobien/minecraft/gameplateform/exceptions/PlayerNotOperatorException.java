package fr.pederobien.minecraft.gameplateform.exceptions;

import org.bukkit.entity.Player;

public class PlayerNotOperatorException extends SimpleMessageException {
	private static final long serialVersionUID = 1L;
	private Player player;

	public PlayerNotOperatorException(Player player) {
		super("The player " + player.getName() + " is not an operator");
		this.player = player;
	}

	/**
	 * @return The player that is not an operator.
	 */
	public Player getPlayer() {
		return player;
	}
}
