package fr.pederobien.minecraft.game.platform.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraft.game.platform.interfaces.commands.ICommand;
import fr.pederobien.minecraft.game.platform.interfaces.commands.ICommandHelper;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGame;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfigurationContext;
import fr.pederobien.minecraft.game.platform.utils.Platform;

public abstract class AbstractCommand implements ICommand {
	private static final TabCompleter DEFAULT_COMPLETER;
	private JavaPlugin plugin;
	private String label;

	static {
		DEFAULT_COMPLETER = new TabCompleter() {
			@Override
			public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
				return new ArrayList<String>();
			}
		};
	}

	protected AbstractCommand(JavaPlugin plugin, String label) {
		this.plugin = plugin;
		this.label = label;
	}

	@Override
	public JavaPlugin getPlugin() {
		return plugin;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public boolean isAvailable() {
		return true;
	}

	@Override
	public void setAvailable(boolean isAvailable) {

	}

	@Override
	public TabCompleter getTabCompleter() {
		return DEFAULT_COMPLETER;
	}

	@Override
	public <U extends IGame> boolean onGameIsStarting(U IGame) {
		return true;
	}

	@Override
	public <U extends IGame> void onGameIsStarted(U IGame) {

	}

	@Override
	public <U extends IGame> boolean onGameIsPausing(U IGame) {
		return true;
	}

	@Override
	public <U extends IGame> void onGameIsPaused(U IGame) {

	}

	@Override
	public <U extends IGame> boolean onGameIsResuming(U IGame) {
		return true;
	}

	@Override
	public <U extends IGame> void onGameIsResumed(U IGame) {

	}

	@Override
	public <U extends IGame> boolean onGameIsStopping(U IGame) {
		return true;
	}

	@Override
	public <U extends IGame> void onGameIsStopped(U IGame) {

	}

	/**
	 * @return A context for game. This context is used to start, pause, relaunch and stop the game managed by the current
	 *         configuration of this context.
	 */
	protected IGameConfigurationContext getGameConfigurationContext() {
		return Platform.getGameConfigurationContext();
	}

	/**
	 * @return The helper used to register commands. Once a command has been registered, it is impossible to unregister it. However,
	 *         it is possible to not display it by setting {@link ICommand#setAvailable(boolean)} to false.
	 */
	protected ICommandHelper getCommandHelper() {
		return Platform.getCommandHelper();
	}
}
