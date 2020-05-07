package fr.pederobien.minecraftgameplateform.border.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.border.messages.EBorderMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.EWorldStructureMessageCode;
import fr.pederobien.minecraftgameplateform.exceptions.worldstructure.WorldNotFoundException;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;
import fr.pederobien.minecraftmanagers.WorldManager;

public class WorldBorder extends AbstractLabelEdition<IBorderConfiguration> {

	protected WorldBorder() {
		super(EBorderLabel.WORLD, EBorderMessageCode.WORLD_BORDER__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String name = "";
		try {
			name = args[0];
			get().setWorld(name);
			sendMessageToSender(sender, EBorderMessageCode.WORLD_BORDER__WORLD_DEFINED, get().getName(), get().getWorld().getName());
			return true;
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, EBorderMessageCode.WORLD_BORDER__WORLD_NAME_IS_MISSING);
			return false;
		} catch (WorldNotFoundException e) {
			sendMessageToSender(sender, EWorldStructureMessageCode.COMMON_WORLD__WORLD_DOES_NOT_EXIST, name);
			return false;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(Arrays.asList(WorldManager.SURFACE_WORLD.getName(), WorldManager.NETHER_WORLD.getName(), WorldManager.END_WORLD.getName()).stream(), args[0]);
		return super.onTabComplete(sender, command, alias, args);
	}
}
