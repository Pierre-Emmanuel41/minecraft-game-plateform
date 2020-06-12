package fr.pederobien.minecraftgameplateform.commands.configurations.borders;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.EBordersMessageCode;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.BorderConfigurationNotRegisteredException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.ConfigurationNotFoundException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;

public class ReloadBorders<T extends IGameBorderConfiguration> extends AbstractBorderGameConfigurationEdition<T> {

	protected ReloadBorders() {
		super(EBordersLabel.RELOAD, EBordersMessageCode.RELOAD_BORDERS__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		List<IBorderConfiguration> removed, reload;
		try {
			removed = getConfigurationsFromGameConfiguration(args);
			get().remove(removed);
			reload = getConfigurations(args);
			for (IBorderConfiguration border : reload)
				get().add(border);
		} catch (BorderConfigurationNotRegisteredException e) {
			sendMessageToSender(sender, EBordersMessageCode.RELOAD_BORDERS__BORDER_NOT_REGISTERED, e.getConfigurationName(), get().getName());
			return false;
		} catch (ConfigurationNotFoundException e) {
			sendMessageToSender(sender, EBordersMessageCode.RELOAD_BORDERS__BORDER_DOES_NOT_EXIST, e.getConfigurationName());
			return false;
		}

		switch (reload.size()) {
		case 0:
			sendMessageToSender(sender, EBordersMessageCode.RELOAD_BORDERS__ANY_BORDER_RELOADED);
			break;
		case 1:
			sendMessageToSender(sender, EBordersMessageCode.RELOAD_BORDERS__ONE_BORDER_RELOADED, args[0]);
			break;
		default:
			sendMessageToSender(sender, EBordersMessageCode.RELOAD_BORDERS__SEVERAL_BORDERS_RELOADED, concat(args));
			break;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return filter(get().getBorders().stream().map(conf -> conf.getName()), args);
	}
}
