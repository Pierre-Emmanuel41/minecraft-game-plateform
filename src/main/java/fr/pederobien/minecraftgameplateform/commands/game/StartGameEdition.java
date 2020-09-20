package fr.pederobien.minecraftgameplateform.commands.game;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;
import fr.pederobien.minecraftgameplateform.impl.runtime.timeline.TimeLine;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class StartGameEdition extends GameEdition {
	private boolean isRegistered;

	public StartGameEdition(JavaPlugin plugin) {
		super("startgame", EGameMessageCode.START_GAME__EXPLANATION, plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!super.onCommand(sender, command, label, args))
			return false;

		sendSynchro(sender, EGameMessageCode.STARTING_GAME, Plateform.getGameConfigurationContext().getName());

		// Getting all registered commands
		List<ICommand> commands = getCommands();

		// Notify each command a game is starting
		if (!notifyCommands(commands, cmd -> cmd.onGameIsStarting(Plateform.getGameConfigurationContext().getGame()), true))
			return false;

		if (!Plateform.getGameConfigurationContext().initiate(sender, command, label, args))
			return false;

		Plateform.getGameConfigurationContext().start();
		Plateform.getGameConfigurationContext().getListener().register(getPlugin());
		Plateform.getGameConfigurationContext().getListener().setActivated(true);

		// Notify each command a game is started
		notifyCommands(commands, cmd -> cmd.onGameIsStarted(Plateform.getGameConfigurationContext().getGame()));

		if (!isRegistered) {
			// Registering the time line as time task observer
			Plateform.getTimeTask().addObserver((TimeLine) Plateform.getTimeLine());
		}

		Plateform.getTimeTask().start(Plateform.getPlugin());
		isRegistered = true;
		return true;
	}
}
