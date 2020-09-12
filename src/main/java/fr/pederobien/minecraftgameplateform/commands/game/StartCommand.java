package fr.pederobien.minecraftgameplateform.commands.game;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.commands.AbstractSimpleCommand;

public class StartCommand extends AbstractSimpleCommand {

	public StartCommand(JavaPlugin plugin) {
		super(plugin, new StartGameEdition(plugin));
	}
}
