package fr.pederobien.minecraft.gameplateform.commands.game;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraft.gameplateform.commands.AbstractSimpleCommand;

public class StopCommand extends AbstractSimpleCommand {

	public StopCommand(JavaPlugin plugin) {
		super(plugin, new StopGameEdition(plugin));
	}
}
