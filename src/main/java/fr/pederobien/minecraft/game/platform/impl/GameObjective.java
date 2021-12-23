package fr.pederobien.minecraft.game.platform.impl;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;

import fr.pederobien.minecraft.game.interfaces.IGame;
import fr.pederobien.minecraft.game.platform.interfaces.IGameObjective;
import fr.pederobien.minecraft.scoreboards.impl.Objective;

public class GameObjective<T extends IGame> extends Objective implements IGameObjective<T> {
	private T game;

	/**
	 * Create an empty objective based on the given parameters.
	 * 
	 * @param plugin      The plugin used to update this objective.
	 * @param player      The player associated to this objective. This player is used to display its informations.
	 * @param name        The name of this objective.
	 * @param displayName The name displayed on the given player score board.
	 * @param criteria    The criteria tracked by this objective.
	 * @param displaySlot The slot where this objective is displayed on player screen.
	 * @param game        The game associated to this objective.
	 */
	public GameObjective(Plugin plugin, Player player, String name, String displayName, String criteria, DisplaySlot displaySlot, T game) {
		super(plugin, player, name, displayName, criteria, displaySlot);
		this.game = game;
	}

	/**
	 * Create an empty objective based on the given parameters.
	 * 
	 * @param plugin      The plugin used to update this objective.
	 * @param player      The player associated to this objective. This player is used to display its informations.
	 * @param name        The name of this objective.
	 * @param displayName The name displayed on the given player score board.
	 * @param displaySlot The slot where this objective is displayed on player screen.
	 * @param game        The game associated to this objective.
	 */
	public GameObjective(Plugin plugin, Player player, String name, String displayName, DisplaySlot displaySlot, T game) {
		this(plugin, player, name, displayName, "dummy", displaySlot, game);
	}

	/**
	 * Create an empty objective based on the given parameters.
	 * 
	 * @param plugin      The plugin used to update this objective.
	 * @param player      The player associated to this objective. This player is used to display its informations.
	 * @param name        The name of this objective.
	 * @param displayName The name displayed on the given player score board.
	 * @param game        The game associated to this objective.
	 */
	public GameObjective(Plugin plugin, Player player, String name, String displayName, T game) {
		this(plugin, player, name, displayName, DisplaySlot.SIDEBAR, game);
	}

	@Override
	public void initiate() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void relaunch() {

	}

	@Override
	public T getGame() {
		return game;
	}
}
