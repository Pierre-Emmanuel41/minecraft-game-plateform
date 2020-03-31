package fr.pederobien.minecraftgameplateform.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.utils.CommandHelper;

public class StopCommand extends AbstractGameCommand {

	public StopCommand(JavaPlugin plugin) {
		super(plugin, "stopgame");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		getGameConfigurationContext().stop();
		CommandHelper.setAllAvailable(true);
		return true;
	}
}
