package fr.pederobien.minecraft.gameplateform.commands.game;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraft.gameplateform.dictionary.EGameMessageCode;
import fr.pederobien.minecraft.gameplateform.impl.runtime.timeline.TimeLine;
import fr.pederobien.minecraft.gameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraft.gameplateform.utils.Plateform;
import fr.pederobien.minecraftmanagers.EColor;

public class StartGameEdition extends GameEdition {
	private boolean isRegistered;

	public StartGameEdition(JavaPlugin plugin) {
		super("startgame", EGameMessageCode.START_GAME__EXPLANATION, plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!super.onCommand(sender, command, label, args))
			return false;

		sendNotSynchro(sender, EGameMessageCode.STARTING_GAME, EColor.DARK_GRAY, Plateform.getGameConfigurationContext().getName());

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
