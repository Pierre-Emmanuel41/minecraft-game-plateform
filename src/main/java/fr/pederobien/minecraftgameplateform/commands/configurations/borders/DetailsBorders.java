package fr.pederobien.minecraftgameplateform.commands.configurations.borders;

import java.util.List;
import java.util.StringJoiner;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.EBordersMessageCode;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.BorderConfigurationNotRegisteredException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;

public class DetailsBorders<T extends IGameBorderConfiguration> extends AbstractBorderGameConfigurationEdition<T> {

	protected DetailsBorders() {
		super(EBordersLabel.DETAILS, EBordersMessageCode.DETAILS__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			StringJoiner joiner = new StringJoiner("\n", "\n--------", "--------");
			for (IBorderConfiguration configuration : get().getConfigurations())
				joiner.add(configuration.toString());
			sendMessageToSender(sender, EBordersMessageCode.DETAILS_BORDERS__DETAILS_ON_ALL_REGISTERED_BORDERS, get().getName(), joiner);
			return true;
		}
		StringJoiner joiner = args.length == 1 ? new StringJoiner("") : new StringJoiner("\n", "\n--------", "--------");
		List<IBorderConfiguration> configurations = null;
		try {
			configurations = getConfigurationsFromGameConfiguration(args);
			for (IBorderConfiguration configuration : configurations)
				joiner.add(configuration.toString());
		} catch (BorderConfigurationNotRegisteredException e) {
			sendMessageToSender(sender, EBordersMessageCode.DETAILS_BORDERS__BORDER_NOT_REGISTERED, e.getConfigurationName(), get().getName());
		}

		sendMessageToSender(sender, EBordersMessageCode.DETAILS_BORDERS__DETAILS_ON_SOME_BORDERS, concatNames(configurations), joiner);
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return filter(get().getConfigurations().stream().map(conf -> conf.getName()), args);
	}
}
