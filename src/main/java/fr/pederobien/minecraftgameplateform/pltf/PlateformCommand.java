package fr.pederobien.minecraftgameplateform.pltf;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.commands.AbstractParentCommand;
import fr.pederobien.minecraftgameplateform.pltf.commands.PlateformParent;

public class PlateformCommand extends AbstractParentCommand<IPlateformConfiguration> {

	public PlateformCommand(JavaPlugin plugin) {
		super(plugin, new PlateformParent(plugin), false);
	}
}
