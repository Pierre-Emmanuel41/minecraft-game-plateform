package fr.pederobien.minecraftgameplateform.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftdevelopmenttoolkit.managers.PlayerManager;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.EGameMessageCode;

public class PauseCommand extends AbstractGameCommand {
	private boolean isGameStatePause;

	public PauseCommand(JavaPlugin plugin) {
		super(plugin, "pausegame");
		isGameStatePause = false;
	}

	@Override
	protected boolean onGameCommand(CommandSender sender, Command command, String label, String[] args) {
		sendMessageToPlayers(PlayerManager.getPlayers(), EGameMessageCode.PAUSING_GAME);

		if (!isGameStatePause)
			getGameConfigurationContext().pause();
		else
			getGameConfigurationContext().relaunch();
		isGameStatePause = !isGameStatePause;
		return true;
	}
}
