package fr.pederobien.minecraftgameplateform.border.commands;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.commands.AbstractParentCommand;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;

public class BorderCommand extends AbstractParentCommand<IBorderConfiguration> {

	protected BorderCommand(JavaPlugin plugin) {
		super(plugin, new BorderParent(plugin));
	}
}
