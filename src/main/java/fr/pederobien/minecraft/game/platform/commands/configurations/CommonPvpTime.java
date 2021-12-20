package fr.pederobien.minecraft.game.platform.commands.configurations;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.game.platform.dictionary.ECommonCode;
import fr.pederobien.minecraft.game.platform.dictionary.EGameConfigurationCode;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

public class CommonPvpTime<T extends IGameConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected CommonPvpTime() {
		super(EGameConfigurationLabel.PVP_TIME, EGameConfigurationCode.PVP_TIME__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			get().setPvpTime(LocalTime.parse(args[0]));
			if (get().getPvpTime().equals(LocalTime.of(0, 0, 0)))
				sendSynchro(sender, EGameConfigurationCode.PVP_TIME__PVP_ENABLED_AT_THE_BEGINNING);
			else
				sendSynchro(sender, EGameConfigurationCode.PVP_TIME__TIME_DEFINED, toString(get().getPvpTime(), false));
			return true;
		} catch (IndexOutOfBoundsException e) {
			sendSynchro(sender, EGameConfigurationCode.PVP_TIME__TIME_IS_MISSING);
			return false;
		} catch (DateTimeParseException e) {
			sendSynchro(sender, ECommonCode.COMMON_BAD_TIME_FORMAT);
			return false;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return asList(getMessage(sender, ECommonCode.COMMON_TIME_TAB_COMPLETE));
		default:
			return emptyList();
		}
	}
}
