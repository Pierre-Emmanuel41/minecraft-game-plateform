package fr.pederobien.minecraftgameplateform.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftdevelopmenttoolkit.managers.PlayerManager;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.EGameMessageCode;

public class StopCommand extends AbstractGameCommand {

	public StopCommand(JavaPlugin plugin) {
		super(plugin, "stopgame");
	}

	@Override
	protected boolean onGameCommand(CommandSender sender, Command command, String label, String[] args) {
		sendMessageToPlayers(PlayerManager.getPlayers(), EGameMessageCode.STOPPING_GAME);

		getGameConfigurationContext().stop();
		getCommandHelper().setAllAvailable(true);
		return true;
	}
}
