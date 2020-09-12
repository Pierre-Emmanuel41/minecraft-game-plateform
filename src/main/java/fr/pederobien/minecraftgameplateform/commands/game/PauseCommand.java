package fr.pederobien.minecraftgameplateform.commands.game;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.commands.AbstractSimpleCommand;

public class PauseCommand extends AbstractSimpleCommand {

	public PauseCommand(JavaPlugin plugin) {
		super(plugin, new PauseGameEdition(plugin));
	}
}
