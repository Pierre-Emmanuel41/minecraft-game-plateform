package fr.pederobien.minecraftgameplateform.commands.configurations.borders;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.EBordersMessageCode;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.BorderConfigurationAlreadyRegisteredException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.ConfigurationNotFoundException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;

public class AddBorders<T extends IGameBorderConfiguration> extends AbstractBorderGameConfigurationEdition<T> {

	protected AddBorders() {
		super(EBordersLabel.ADD, EBordersMessageCode.ADD_BORDERS__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		List<IBorderConfiguration> configurations;
		try {
			configurations = getConfigurations(args);
			for (IBorderConfiguration configuration : configurations)
				get().add(configuration);
		} catch (ConfigurationNotFoundException e) {
			sendMessageToSender(sender, EBordersMessageCode.ADD_BORDERS__BORDER_DOES_NOT_EXIST, e.getConfigurationName());
			return false;
		} catch (BorderConfigurationAlreadyRegisteredException e) {
			sendMessageToSender(sender, EBordersMessageCode.ADD_BORDERS__BORDER_ALREADY_REGISTERED, e.getBorderConfiguration().getName());
			return false;
		}

		switch (configurations.size()) {
		case 0:
			sendMessageToSender(sender, EBordersMessageCode.ADD_BORDERS__NO_BORDER_ADDED, get().getName());
			break;
		case 1:
			sendMessageToSender(sender, EBordersMessageCode.ADD_BORDERS__ONE_BORDER_ADDED, concatNames(configurations), get().getName());
			break;
		default:
			sendMessageToSender(sender, EBordersMessageCode.ADD_BORDERS__SEVERAL_BORDERS_ADDED, concatNames(configurations), get().getName());
			break;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return filter(getFreeBorderConfigurations(Arrays.asList(args)), args);
	}
}
