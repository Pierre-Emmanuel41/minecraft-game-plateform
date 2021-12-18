package fr.pederobien.minecraft.gameplateform.commands.game;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraft.gameplateform.commands.AbstractSimpleCommand;

public class PauseCommand extends AbstractSimpleCommand {

	public PauseCommand(JavaPlugin plugin) {
		super(plugin, new PauseGameEdition(plugin));
	}
}
