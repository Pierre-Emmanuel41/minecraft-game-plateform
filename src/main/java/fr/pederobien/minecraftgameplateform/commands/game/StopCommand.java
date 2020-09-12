package fr.pederobien.minecraftgameplateform.commands.game;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.commands.AbstractSimpleCommand;

public class StopCommand extends AbstractSimpleCommand {

	public StopCommand(JavaPlugin plugin) {
		super(plugin, new StopGameEdition(plugin));
	}
}
