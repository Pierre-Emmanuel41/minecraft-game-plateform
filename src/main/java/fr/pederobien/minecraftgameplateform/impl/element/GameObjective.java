package fr.pederobien.minecraftgameplateform.impl.element;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;

import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameObjective;
import fr.pederobien.minecraftscoreboards.impl.Objective;

public class GameObjective<T extends IGameConfiguration> extends Objective implements IGameObjective<T> {
	private T configuration;

	/**
	 * Create an empty objective based on the given parameters.
	 * 
	 * @param plugin        The plugin used to update this objective.
	 * @param player        The player associated to this objective. This player is used to display its informations.
	 * @param name          The name of this objective.
	 * @param displayName   The name displayed on the given player score board.
	 * @param criteria      The criteria tracked by this objective.
	 * @param displaySlot   The slot where this objective is displayed on player screen.
	 * @param configuration The configuration associated to this objective.
	 */
	public GameObjective(Plugin plugin, Player player, String name, String displayName, String criteria, DisplaySlot displaySlot, T configuration) {
		super(plugin, player, name, displayName, criteria, displaySlot);
		this.configuration = configuration;
	}

	/**
	 * Create an empty objective based on the given parameters.
	 * 
	 * @param plugin        The plugin used to update this objective.
	 * @param player        The player associated to this objective. This player is used to display its informations.
	 * @param name          The name of this objective.
	 * @param displayName   The name displayed on the given player score board.
	 * @param displaySlot   The slot where this objective is displayed on player screen.
	 * @param configuration The configuration associated to this objective.
	 */
	public GameObjective(Plugin plugin, Player player, String name, String displayName, DisplaySlot displaySlot, T configuration) {
		this(plugin, player, name, displayName, "dummy", displaySlot, configuration);
	}

	/**
	 * Create an empty objective based on the given parameters.
	 * 
	 * @param plugin        The plugin used to update this objective.
	 * @param player        The player associated to this objective. This player is used to display its informations.
	 * @param name          The name of this objective.
	 * @param displayName   The name displayed on the given player score board.
	 * @param configuration The configuration associated to this objective.
	 */
	public GameObjective(Plugin plugin, Player player, String name, String displayName, T configuration) {
		this(plugin, player, name, displayName, DisplaySlot.SIDEBAR, configuration);
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
	public T getConfiguration() {
		return configuration;
	}
}
