package fr.pederobien.minecraftgameplateform.worldstructure.spawn.commands;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.commands.configurations.AbstractConfigurationCommand;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class SpawnCommand extends AbstractConfigurationCommand<ISpawn> {

	public SpawnCommand(JavaPlugin plugin) {
		super(plugin, new SpawnParent(plugin));
	}
}
