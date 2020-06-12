package fr.pederobien.minecraftgameplateform.commands.configurations.borders;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.EBordersMessageCode;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.BorderConfigurationNotRegisteredException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;

public class RemoveBorders<T extends IGameBorderConfiguration> extends AbstractGameBorderConfigurationEdition<T> {

	protected RemoveBorders() {
		super(EBordersLabel.REMOVE, EBordersMessageCode.REMOVE_BORDERS__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		List<IBorderConfiguration> configurations;
		try {
			configurations = getConfigurationsFromGameConfiguration(args);
			get().remove(configurations);
		} catch (BorderConfigurationNotRegisteredException e) {
			sendMessageToSender(sender, EBordersMessageCode.REMOVE_BORDERS__BORDER_NOT_REGISTERED, e.getConfigurationName(), get().getName());
			return false;
		}

		switch (configurations.size()) {
		case 0:
			sendMessageToSender(sender, EBordersMessageCode.REMOVE_BORDERS__NO_BORDER_REMOVED, get().getName());
			break;
		case 1:
			sendMessageToSender(sender, EBordersMessageCode.REMOVE_BORDERS__ONE_BORDER_REMOVED, concatNames(configurations), get().getName());
			break;
		default:
			sendMessageToSender(sender, EBordersMessageCode.REMOVE_BORDERS__SEVERAL_BORDERS_REMOVED, concatNames(configurations), get().getName());
			break;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return filter(get().getBorders().stream().map(conf -> conf.getName()), args);
	}

}
