package fr.pederobien.minecraft.game.platform.commands.configurations;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.game.platform.dictionary.EGameConfigurationMessageCode;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.game.platform.utils.Platform;

public class CommonAscurrent<T extends IGameConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected CommonAscurrent() {
		super(EGameConfigurationLabel.AS_CURRENT, EGameConfigurationMessageCode.AS_CURRENT__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Platform.getGameConfigurationContext().setGameConfiguration(get());
		sendSynchro(sender, EGameConfigurationMessageCode.AS_CURRENT__GAME_STYLE_DEFINED, get().getName());
		return true;
	}
}
