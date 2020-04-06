package fr.pederobien.minecraftgameplateform.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class StopCommand extends AbstractGameCommand {

	public StopCommand(JavaPlugin plugin) {
		super(plugin, "stopgame");
	}

	@Override
	protected boolean onGameCommand(CommandSender sender, Command command, String label, String[] args) {
		getGameConfigurationContext().stop();
		getCommandHelper().setAllAvailable(true);
		return true;
	}
}
