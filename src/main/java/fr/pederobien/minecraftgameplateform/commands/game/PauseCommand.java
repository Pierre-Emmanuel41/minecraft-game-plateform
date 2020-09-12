package fr.pederobien.minecraftgameplateform.commands.game;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftmanagers.PlayerManager;

public class PauseCommand extends AbstractGameCommand {
	private boolean isGameStatePause;

	public PauseCommand(JavaPlugin plugin) {
		super(plugin, "pausegame");
		isGameStatePause = false;
	}

	@Override
	protected boolean onGameCommand(CommandSender sender, Command command, String label, String[] args) {
		// Getting all registered commands
		List<ICommand> commands = getCommands();

		if (!isGameStatePause) {
			// Notify each command a game is pausing
			if (!notifyCommands(commands, cmd -> cmd.onGameIsPausing(getGameConfigurationContext().getGame()), true))
				return false;
			sendMessageToPlayers(PlayerManager.getPlayers(), EGameMessageCode.PAUSING_GAME);
			getGameConfigurationContext().pause();

			// Notify each command a game is paused
			notifyCommands(commands, cmd -> cmd.onGameIsPaused(getGameConfigurationContext().getGame()));
			Plateform.getTimeTask().pause();
		} else {
			// Notify each command a game is resuming
			if (!notifyCommands(commands, cmd -> cmd.onGameIsResuming(getGameConfigurationContext().getGame()), true))
				return false;
			sendMessageToPlayers(PlayerManager.getPlayers(), EGameMessageCode.RESUMING_GAME);
			getGameConfigurationContext().relaunch();

			// Notify each command a game is resumed
			notifyCommands(commands, cmd -> cmd.onGameIsResumed(getGameConfigurationContext().getGame()));
			Plateform.getTimeTask().relaunched();
		}
		isGameStatePause = !isGameStatePause;
		return true;
	}
}
