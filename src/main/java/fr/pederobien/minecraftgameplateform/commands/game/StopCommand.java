package fr.pederobien.minecraftgameplateform.commands.game;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;
import fr.pederobien.minecraftgameplateform.gamerules.GameRule;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftmanagers.PlayerManager;

public class StopCommand extends AbstractGameCommand {

	public StopCommand(JavaPlugin plugin) {
		super(plugin, "stopgame");
	}

	@Override
	protected boolean onGameCommand(CommandSender sender, Command command, String label, String[] args) {
		sendMessageToPlayers(PlayerManager.getPlayers(), EGameMessageCode.STOPPING_GAME);

		// Getting all registered commands
		List<ICommand> commands = getCommands();

		// Notify each command a game is stopping
		if (!notifyCommands(commands, cmd -> cmd.onGameIsStopping(getGameConfigurationContext().getGame()), true))
			return false;

		getGameConfigurationContext().stop();
		getGameConfigurationContext().getListener().setActivated(false);

		// Notify each command a game is stopped.
		notifyCommands(commands, cmd -> cmd.onGameIsStopped(getGameConfigurationContext().getGame()));

		// Registering the time line as time task observer
		Plateform.getTimeTask().stop();

		stopGameRules();
		return true;
	}

	private void stopGameRules() {
		GameRule.RUNNABLE_RULES.forEach(rule -> rule.stop());
	}
}
