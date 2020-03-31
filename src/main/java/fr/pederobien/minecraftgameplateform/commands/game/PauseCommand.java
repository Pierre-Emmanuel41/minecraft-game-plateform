package fr.pederobien.minecraftgameplateform.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class PauseCommand extends AbstractGameCommand {
	private boolean isGameStatePause;

	public PauseCommand(JavaPlugin plugin) {
		super(plugin, "pausegame");
		isGameStatePause = false;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!isGameStatePause)
			getGameConfigurationContext().pause();
		else
			getGameConfigurationContext().relaunch();
		isGameStatePause = !isGameStatePause;
		return true;
	}
}
