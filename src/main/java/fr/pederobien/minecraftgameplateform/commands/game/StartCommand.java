package fr.pederobien.minecraftgameplateform.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.dictionary.messages.game.EGameMessageCode;
import fr.pederobien.minecraftmanagers.PlayerManager;

public class StartCommand extends AbstractGameCommand {

	public StartCommand(JavaPlugin plugin) {
		super(plugin, "startgame");
	}

	@Override
	protected boolean onGameCommand(CommandSender sender, Command command, String label, String[] args) {
		sendMessageToPlayers(PlayerManager.getPlayers(), EGameMessageCode.STARTING_GAME, getGameConfigurationContext().getName());

		if (!getGameConfigurationContext().initiate())
			return false;

		getGameConfigurationContext().start();
		getCommandHelper().setAllAvailable(false);
		return true;
	}
}
