package fr.pederobien.minecraft.gameplateform.commands.game;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraft.gameplateform.commands.AbstractSimpleCommand;

public class StartCommand extends AbstractSimpleCommand {

	public StartCommand(JavaPlugin plugin) {
		super(plugin, new StartGameEdition(plugin));
	}
}
