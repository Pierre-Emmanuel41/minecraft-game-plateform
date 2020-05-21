package fr.pederobien.minecraftgameplateform.commands.game;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.commands.IParentCommand;
import fr.pederobien.minecraftmanagers.PlayerManager;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public class StopCommand extends AbstractGameCommand {

	public StopCommand(JavaPlugin plugin) {
		super(plugin, "stopgame");
	}

	@Override
	protected boolean onGameCommand(CommandSender sender, Command command, String label, String[] args) {
		sendMessageToPlayers(PlayerManager.getPlayers(), EGameMessageCode.STOPPING_GAME);

		// Getting all registered commands
		List<IParentCommand<IUnmodifiableNominable>> commands = getCommands();

		// Notify each command a game is stopping
		if (!notifyCommands(commands, cmd -> cmd.onGameIsStopping(getGameConfigurationContext().getGame()), true))
			return false;

		getGameConfigurationContext().stop();

		// Notify each command a game is stopped.
		notifyCommands(commands, cmd -> cmd.onGameIsStopped(getGameConfigurationContext().getGame()));
		return true;
	}
}
