package fr.pederobien.minecraft.platform;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraft.game.event.GamePausePostEvent;
import fr.pederobien.minecraft.game.event.GameResumePostEvent;
import fr.pederobien.minecraft.game.impl.time.TimeLine;
import fr.pederobien.minecraft.game.interfaces.IGame;
import fr.pederobien.minecraft.game.interfaces.ITeam;
import fr.pederobien.minecraft.game.interfaces.ITeamConfigurable;
import fr.pederobien.minecraft.game.interfaces.time.ITimeLine;
import fr.pederobien.minecraft.scoreboards.ObjectiveUpdater;
import fr.pederobien.minecraft.scoreboards.interfaces.IObjectiveUpdater;
import fr.pederobien.utils.event.EventHandler;
import fr.pederobien.utils.event.EventManager;
import fr.pederobien.utils.event.IEventListener;

public final class Platform implements IEventListener {
	/**
	 * The path leading to the plugins folder.
	 */
	public static final Path PLUGINS = Paths.get("plugins");

	/**
	 * Path to folder plugins/minecraft-game-plateform
	 */
	public static final Path ROOT = PLUGINS.resolve("minecraft-game-plateform");

	private static final Map<IGame, Platform> PLATFORMS = new HashMap<IGame, Platform>();

	private IGame game;
	private IObjectiveUpdater objectiveUpdater;
	private ITimeLine timeLine;

	/**
	 * Get the platform instance associated to the given game. The returned platform is not null if and only if the associated game is
	 * started.
	 * 
	 * @param game The game used to get the associated platform.
	 * 
	 * @return The platform instance.
	 */
	public static Platform get(IGame game) {
		return PLATFORMS.get(game);
	}

	/**
	 * Get the platform instance associated to the given plugin. The returned platform is not null if and only if the associated game
	 * is started.
	 * 
	 * @param plugin The plugin used to get the associated platform.
	 * 
	 * @return The platform instance.
	 */
	public static Platform get(Plugin plugin) {
		for (Map.Entry<IGame, Platform> entry : PLATFORMS.entrySet())
			if (entry.getKey().getPlugin().equals(plugin))
				return entry.getValue();

		return null;
	}

	/**
	 * Get the platform associated to the given player. The platform is associated to a player if and only if the player is registered
	 * in one team of the game associated to a platform.
	 * 
	 * @param player The player used to get its game.
	 * 
	 * @return The game in which the player is playing, or null.
	 */
	public static Platform get(Player player) {
		for (Map.Entry<IGame, Platform> entry : PLATFORMS.entrySet()) {
			if (!(entry.getKey() instanceof ITeamConfigurable))
				continue;

			ITeamConfigurable teams = (ITeamConfigurable) entry.getKey();
			Optional<ITeam> optTeam = teams.getTeams().getTeam(player);
			if (optTeam.isPresent())
				return entry.getValue();
		}

		return null;
	}

	/**
	 * Creates a new platform instance associated to the given game.
	 * 
	 * @param game The started game.
	 */
	protected static void register(IGame game) {
		Platform platform = PLATFORMS.get(game);
		if (platform != null)
			return;

		platform = new Platform(game);
		PLATFORMS.put(game, platform);
	}

	/**
	 * Removes the platform associated to the given game.
	 * 
	 * @param game The stopped game.
	 */
	protected static void unregister(IGame game) {
		Platform platform = PLATFORMS.remove(game);

		if (platform == null)
			return;

		platform.getObjectiveUpdater().stop(true);
		platform.getTimeLine().getTimeTask().stop();
		EventManager.unregisterListener(platform);
	}

	/**
	 * Creates a new platform based on the given game.
	 * 
	 * @param game The game associated to this platform.
	 */
	private Platform(IGame game) {
		this.game = game;
		objectiveUpdater = ObjectiveUpdater.getInstance(game.getPlugin());
		timeLine = new TimeLine(game.getPlugin());

		EventManager.registerListener(this);
	}

	/**
	 * @return The game associated to this platform.
	 */
	public IGame getGame() {
		return game;
	}

	/**
	 * The time line associated to this platform. The time line is particularly used to registered time events. If you want to be
	 * notified punctually during a game, this time line should be used. However, if you want to be notified each second, then you
	 * should be registered as observer for the time task.
	 * 
	 * @return The time associated to this platform.
	 */
	public ITimeLine getTimeLine() {
		return timeLine;
	}

	/**
	 * The objective updater used to display informations on each player screen.
	 */
	public IObjectiveUpdater getObjectiveUpdater() {
		return objectiveUpdater;
	}

	@EventHandler
	private void onGamePause(GamePausePostEvent event) {
		if (!event.getGame().equals(game))
			return;

		timeLine.getTimeTask().pause();
	}

	@EventHandler
	private void onGameResume(GameResumePostEvent event) {
		if (!event.getGame().equals(game))
			return;

		timeLine.getTimeTask().resume();
	}
}
