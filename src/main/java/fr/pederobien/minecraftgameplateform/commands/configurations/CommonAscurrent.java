package fr.pederobien.minecraftgameplateform.commands.configurations;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.EGameConfigurationMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class CommonAscurrent<T extends IGameConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected CommonAscurrent() {
		super(EGameConfigurationLabel.AS_CURRENT, EGameConfigurationMessageCode.AS_CURRENT__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Plateform.getGameConfigurationContext().setGameConfiguration(get());
		sendMessageToSender(sender, EGameConfigurationMessageCode.AS_CURRENT__GAME_STYLE_DEFINED, get().getName());
		return true;
	}
}
