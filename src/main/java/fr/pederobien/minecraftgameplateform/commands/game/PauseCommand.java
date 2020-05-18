package fr.pederobien.minecraftgameplateform.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;
import fr.pederobien.minecraftmanagers.PlayerManager;

public class PauseCommand extends AbstractGameCommand {
	private boolean isGameStatePause;

	public PauseCommand(JavaPlugin plugin) {
		super(plugin, "pausegame");
		isGameStatePause = false;
	}

	@Override
	protected boolean onGameCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!isGameStatePause) {
			sendMessageToPlayers(PlayerManager.getPlayers(), EGameMessageCode.PAUSING_GAME);
			getGameConfigurationContext().pause();
		} else {
			sendMessageToPlayers(PlayerManager.getPlayers(), EGameMessageCode.RESUMING_GAME);
			getGameConfigurationContext().relaunch();
		}
		isGameStatePause = !isGameStatePause;
		return true;
	}
}
