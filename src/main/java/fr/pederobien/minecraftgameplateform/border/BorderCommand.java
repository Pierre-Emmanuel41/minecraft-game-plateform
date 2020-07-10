package fr.pederobien.minecraftgameplateform.border;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.border.commands.BorderParent;
import fr.pederobien.minecraftgameplateform.commands.AbstractParentCommand;

public class BorderCommand extends AbstractParentCommand<IBorderConfiguration> {

	public BorderCommand(JavaPlugin plugin) {
		super(plugin, new BorderParent(plugin));
	}
}
