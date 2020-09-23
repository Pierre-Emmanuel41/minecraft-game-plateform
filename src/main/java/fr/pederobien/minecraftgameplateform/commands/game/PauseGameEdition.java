package fr.pederobien.minecraftgameplateform.commands.game;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftmanagers.EColor;

public class PauseGameEdition extends GameEdition {
	private boolean isGameStatePause;

	public PauseGameEdition(JavaPlugin plugin) {
		super("pausegame", EGameMessageCode.PAUSE_GAME__EXPLANATION, plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!super.onCommand(sender, command, label, args))
			return false;

		// Getting all registered commands
		List<ICommand> commands = getCommands();

		if (!isGameStatePause) {
			// Notify each command a game is pausing
			if (!notifyCommands(commands, cmd -> cmd.onGameIsPausing(Plateform.getGameConfigurationContext().getGame()), true))
				return false;
			sendNotSynchro(sender, EGameMessageCode.PAUSING_GAME, EColor.DARK_GRAY, Plateform.getGameConfigurationContext().getName());
			Plateform.getGameConfigurationContext().pause();

			// Notify each command a game is paused
			notifyCommands(commands, cmd -> cmd.onGameIsPaused(Plateform.getGameConfigurationContext().getGame()));
			Plateform.getTimeTask().pause();
		} else {
			// Notify each command a game is resuming
			if (!notifyCommands(commands, cmd -> cmd.onGameIsResuming(Plateform.getGameConfigurationContext().getGame()), true))
				return false;
			sendNotSynchro(sender, EGameMessageCode.RESUMING_GAME, EColor.DARK_GRAY, Plateform.getGameConfigurationContext().getName());
			Plateform.getGameConfigurationContext().relaunch();

			// Notify each command a game is resumed
			notifyCommands(commands, cmd -> cmd.onGameIsResumed(Plateform.getGameConfigurationContext().getGame()));
			Plateform.getTimeTask().relaunched();
		}
		isGameStatePause = !isGameStatePause;
		return true;
	}
}
