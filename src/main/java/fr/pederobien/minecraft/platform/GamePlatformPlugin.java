package fr.pederobien.minecraft.platform;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.commandtree.events.NodeEvent;
import fr.pederobien.dictionary.event.DictionaryEvent;
import fr.pederobien.dictionary.impl.JarXmlDictionaryParser;
import fr.pederobien.minecraft.dictionary.impl.MinecraftDictionaryContext;
import fr.pederobien.minecraft.game.commands.game.GameCommandTree;
import fr.pederobien.minecraft.game.event.GameStartPostEvent;
import fr.pederobien.minecraft.game.event.GameStopPostEvent;
import fr.pederobien.minecraft.game.event.TimeTaskTimeChangePostEvent;
import fr.pederobien.minecraft.platform.event.PlatformDisablePostEvent;
import fr.pederobien.utils.AsyncConsole;
import fr.pederobien.utils.event.EventHandler;
import fr.pederobien.utils.event.EventLogger;
import fr.pederobien.utils.event.EventManager;
import fr.pederobien.utils.event.EventPriority;
import fr.pederobien.utils.event.IEventListener;

public class GamePlatformPlugin extends JavaPlugin implements IEventListener {
	private static final String[] DICTIONARY_FOLDERS = new String[] { "resources/dictionaries/game/", "resources/dictionaries/platform/" };

	private static Plugin instance;
	private static GameCommandTree gameTree;

	/**
	 * @return The plugin associated to this plateform plugin.
	 */
	public static Plugin instance() {
		return instance;
	}

	/**
	 * Get the tree used to start, pause/resume and stop a game.
	 * 
	 * @return The game tree associated to this plugin.
	 */
	public static GameCommandTree getGameTree() {
		return gameTree;
	}

	@Override
	public void onEnable() {
		registerDictionaries();
		registerTabExecutors();

		EventLogger.instance().newLine(true).timeStamp(false).register();
		EventLogger.instance().ignore(DictionaryEvent.class).register();
		EventLogger.instance().ignore(NodeEvent.class).register();
		EventLogger.instance().ignore(TimeTaskTimeChangePostEvent.class);
		EventManager.registerListener(this);

		instance = this;
		gameTree = new GameCommandTree();
	}

	@Override
	public void onDisable() {
		EventManager.callEvent(new PlatformDisablePostEvent());
	}

	@EventHandler(priority = EventPriority.LOWEST)
	private void onGameStart(GameStartPostEvent event) {
		Platform.register(event.getGame());
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	private void startTimeLine(GameStartPostEvent event) {
		Platform platform = Platform.get(event.getGame().getPlugin());
		platform.getTimeLine().getTimeTask().start();
		platform.getObjectiveUpdater().start();
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	private void onGameStop(GameStopPostEvent event) {
		Platform.unregister(event.getGame());
	}

	private void registerDictionaries() {
		JarXmlDictionaryParser dictionaryParser = new JarXmlDictionaryParser(getFile().toPath());

		MinecraftDictionaryContext context = MinecraftDictionaryContext.instance();
		String[] dictionaries = new String[] { "English.xml", "French.xml" };
		for (String dictionaryFolder : DICTIONARY_FOLDERS)
			for (String dictionary : dictionaries)
				try {
					context.register(dictionaryParser.parse(dictionaryFolder.concat(dictionary)));
				} catch (Exception e) {
					AsyncConsole.print(e);
					for (StackTraceElement element : e.getStackTrace())
						AsyncConsole.print(element);
				}
	}

	private void registerTabExecutors() {
		PluginCommand startgame = getCommand(gameTree.getStartGameNode().getLabel());
		startgame.setTabCompleter(gameTree.getStartGameNode());
		startgame.setExecutor(gameTree.getStartGameNode());

		PluginCommand pausegame = getCommand(gameTree.getPauseGameNode().getLabel());
		pausegame.setTabCompleter(gameTree.getPauseGameNode());
		pausegame.setExecutor(gameTree.getPauseGameNode());

		PluginCommand stopgame = getCommand(gameTree.getStopGameNode().getLabel());
		stopgame.setTabCompleter(gameTree.getStopGameNode());
		stopgame.setExecutor(gameTree.getStopGameNode());
	}
}
