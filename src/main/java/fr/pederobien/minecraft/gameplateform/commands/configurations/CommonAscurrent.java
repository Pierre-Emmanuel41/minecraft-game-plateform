package fr.pederobien.minecraft.gameplateform.commands.configurations;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.gameplateform.dictionary.EGameConfigurationMessageCode;
import fr.pederobien.minecraft.gameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.gameplateform.utils.Plateform;

public class CommonAscurrent<T extends IGameConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected CommonAscurrent() {
		super(EGameConfigurationLabel.AS_CURRENT, EGameConfigurationMessageCode.AS_CURRENT__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Plateform.getGameConfigurationContext().setGameConfiguration(get());
		sendSynchro(sender, EGameConfigurationMessageCode.AS_CURRENT__GAME_STYLE_DEFINED, get().getName());
		return true;
	}
}
