package fr.pederobien.minecraftgameplateform.commands.game;

import java.time.LocalTime;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;
import fr.pederobien.minecraftgameplateform.gamerules.GameRule;
import fr.pederobien.minecraftgameplateform.impl.runtime.timeline.TimeLine;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline.IObsTimeLine;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class StartGameEdition extends GameEdition {
	private IObsTimeLine pvpActivator;
	private boolean isRegistered;

	public StartGameEdition(JavaPlugin plugin) {
		super("startgame", EGameMessageCode.START_GAME__EXPLANATION, plugin);
		pvpActivator = new PvpActivator();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!super.onCommand(sender, command, label, args))
			return false;

		sendMessageToSender(sender, EGameMessageCode.STARTING_GAME, Plateform.getGameConfigurationContext().getName());

		// Getting all registered commands
		List<ICommand> commands = getCommands();

		// Notify each command a game is starting
		if (!notifyCommands(commands, cmd -> cmd.onGameIsStarting(Plateform.getGameConfigurationContext().getGame()), true))
			return false;

		if (!Plateform.getGameConfigurationContext().initiate())
			return false;

		Plateform.getGameConfigurationContext().start();
		Plateform.getGameConfigurationContext().getListener().register(getPlugin());
		Plateform.getGameConfigurationContext().getListener().setActivated(true);

		// Notify each command a game is started
		notifyCommands(commands, cmd -> cmd.onGameIsStarted(Plateform.getGameConfigurationContext().getGame()));

		register();

		GameRule.RUNNABLE_RULES.forEach(rule -> rule.start());
		GameRule.PVP.setValue(false);
		return true;
	}

	private void register() {
		if (!isRegistered) {
			// Registering the time line as time task observer
			Plateform.getTimeTask().addObserver((TimeLine) Plateform.getTimeLine());
		}

		// Registering PvpActivator as timeLine observer
		Plateform.getTimeLine().addObserver(Plateform.getGameConfigurationContext().getPvpTime(), pvpActivator);
		Plateform.getTimeTask().start(Plateform.getPlugin());
		isRegistered = true;
	}

	private class PvpActivator implements IObsTimeLine {

		@Override
		public void timeChanged(LocalTime time) {
			GameRule.PVP.setValue(true);
			Plateform.getGameConfigurationContext().getGame().onPvpEnabled();
		}
	}
}
