package fr.pederobien.minecraftgameplateform.commands.configurations.borders;

import java.util.List;
import java.util.StringJoiner;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.EBordersMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;
import fr.pederobien.minecraftmanagers.WorldManager;

public class ListBorders<T extends IGameBorderConfiguration> extends AbstractBorderGameConfigurationEdition<T> {

	protected ListBorders() {
		super(EBordersLabel.LIST, EBordersMessageCode.LIST_BORDERS__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			StringJoiner joiner = new StringJoiner("\n");
			joiner.add(concat(WorldManager.OVERWORLD));
			joiner.add(concat(WorldManager.NETHER_WORLD));
			joiner.add(concat(WorldManager.END_WORLD));
			sendMessageToSender(sender, EBordersMessageCode.LIST_BORDERS__ALL_REGISTERED_BORDERS, joiner);
			return true;
		}

		String name = args[0];
		World world = WorldManager.getWorld(name);
		if (world == null) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_WORLD_DOES_NOT_EXIST, name);
			return false;
		}
		sendMessageToSender(sender, EBordersMessageCode.LIST_BORDERS__REGISTERED_BORDERS_FOR_WORLD, WorldManager.getWorldNameNormalised(world), concat(world));
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(WorldManager.getWorldNormalisedNames().stream(), args);
		return super.onTabComplete(sender, command, alias, args);
	}
}
