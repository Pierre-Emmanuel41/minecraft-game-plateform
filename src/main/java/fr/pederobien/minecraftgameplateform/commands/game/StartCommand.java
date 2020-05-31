package fr.pederobien.minecraftgameplateform.commands.game;

import java.time.LocalTime;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;
import fr.pederobien.minecraftgameplateform.impl.runtime.timeline.TimeLine;
import fr.pederobien.minecraftgameplateform.interfaces.commands.IParentCommand;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline.ITimeLineObserver;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftmanagers.PlayerManager;
import fr.pederobien.minecraftmanagers.WorldManager;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public class StartCommand extends AbstractGameCommand {

	public StartCommand(JavaPlugin plugin) {
		super(plugin, "startgame");
	}

	@Override
	protected boolean onGameCommand(CommandSender sender, Command command, String label, String[] args) {
		sendMessageToPlayers(PlayerManager.getPlayers(), EGameMessageCode.STARTING_GAME, getGameConfigurationContext().getName());

		// Getting all registered commands
		List<IParentCommand<IUnmodifiableNominable>> commands = getCommands();

		// Notify each command a game is starting
		if (!notifyCommands(commands, cmd -> cmd.onGameIsStarting(getGameConfigurationContext().getGame()), true))
			return false;

		if (!getGameConfigurationContext().initiate())
			return false;

		getGameConfigurationContext().start();
		getGameConfigurationContext().getListener().register(getPlugin());
		getGameConfigurationContext().getListener().setActivated(true);

		// Notify each command a game is started
		notifyCommands(commands, cmd -> cmd.onGameIsStarted(getGameConfigurationContext().getGame()));

		// Registering PvpActivator as timeLine observer
		Plateform.getTimeLine().addObserver(getGameConfigurationContext().getPvpTime(), new PvpActivator());

		// Registering the time line as time task observer
		Plateform.getTimeTask().addObserver((TimeLine) Plateform.getTimeLine());
		Plateform.getTimeTask().start(Plateform.getPlugin());

		setPvp(false);
		return true;
	}

	private void setPvp(boolean pvp) {
		WorldManager.setPVPInOverworld(pvp);
		WorldManager.setPVPInNether(pvp);
		WorldManager.setPVPInEnder(pvp);
	}

	private class PvpActivator implements ITimeLineObserver {

		@Override
		public void timeChanged(LocalTime time) {
			setPvp(true);
			getGameConfigurationContext().getGame().onPvpEnabled();
		}
	}
}
