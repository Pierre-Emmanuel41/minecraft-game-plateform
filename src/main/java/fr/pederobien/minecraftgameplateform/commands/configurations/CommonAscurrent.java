package fr.pederobien.minecraftgameplateform.commands.configurations;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.EGameConfigurationMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfigurationContext;

public class CommonAscurrent<T extends IGameConfiguration> extends AbstractGameConfigurationEdition<T> {
	private IGameConfigurationContext gameContext;

	protected CommonAscurrent(IGameConfigurationContext gameContext) {
		super(EGameConfigurationLabel.AS_CURRENT, EGameConfigurationMessageCode.AS_CURRENT__EXPLANATION);
		this.gameContext = gameContext;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		gameContext.setGameConfiguration(get());
		sendMessageToSender(sender, EGameConfigurationMessageCode.AS_CURRENT__GAME_STYLE_DEFINED, get().getName());
		return true;
	}
}
