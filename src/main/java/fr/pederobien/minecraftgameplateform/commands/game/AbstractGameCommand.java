package fr.pederobien.minecraftgameplateform.commands.game;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.commands.AbstractCommand;

public abstract class AbstractGameCommand extends AbstractCommand {

	protected AbstractGameCommand(JavaPlugin plugin, String label) {
		super(plugin, label);
		getPlugin().getCommand(getLabel()).setExecutor(this);
	}
}
