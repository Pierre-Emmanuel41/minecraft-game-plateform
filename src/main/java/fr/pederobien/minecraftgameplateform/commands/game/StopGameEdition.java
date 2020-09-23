package fr.pederobien.minecraftgameplateform.commands.game;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftmanagers.EColor;

public class StopGameEdition extends GameEdition {

	public StopGameEdition(JavaPlugin plugin) {
		super("stopgame", EGameMessageCode.STOP_GAME__EXPLANATION, plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!super.onCommand(sender, command, label, args))
			return false;

		sendSynchro(sender, EGameMessageCode.STOPPING_GAME, EColor.DARK_GRAY, Plateform.getGameConfigurationContext().getName());

		// Getting all registered commands
		List<ICommand> commands = getCommands();

		// Notify each command a game is stopping
		if (!notifyCommands(commands, cmd -> cmd.onGameIsStopping(Plateform.getGameConfigurationContext().getGame()), true))
			return false;

		Plateform.getGameConfigurationContext().stop();
		Plateform.getGameConfigurationContext().getListener().setActivated(false);

		// Notify each command a game is stopped.
		notifyCommands(commands, cmd -> cmd.onGameIsStopped(Plateform.getGameConfigurationContext().getGame()));

		// Registering the time line as time task observer
		Plateform.getTimeTask().stop();
		return true;
	}
}
