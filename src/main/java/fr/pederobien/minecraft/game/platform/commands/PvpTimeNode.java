package fr.pederobien.minecraft.game.platform.commands;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.game.impl.DisplayHelper;
import fr.pederobien.minecraft.game.impl.EGameCode;
import fr.pederobien.minecraft.game.platform.impl.EPlatformCode;
import fr.pederobien.minecraft.game.platform.interfaces.IPvpTimeConfigurable;

public class PvpTimeNode extends ConfigurableNode<LocalTime> {

	protected PvpTimeNode(IPvpTimeConfigurable configurable) {
		super("pvpTime", EPlatformCode.GAME_CONFIG__PVP_TIME__EXPLANATION, configurable.getPvpTime());
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return asList(getMessage(sender, EPlatformCode.TIME_FORMAT__COMPLETION));
		default:
			return emptyList();
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		LocalTime pvpTime;
		try {
			pvpTime = LocalTime.parse(args[0]);
		} catch (IndexOutOfBoundsException e) {
			send(eventBuilder(sender, EPlatformCode.GAME_CONFIG__PVP_TIME__TIME_IS_MISSING).build());
			return false;
		} catch (DateTimeParseException e) {
			send(eventBuilder(sender, EGameCode.BAD_FORMAT, EPlatformCode.TIME_FORMAT__COMPLETION));
			return false;
		}

		getConfigurable().set(pvpTime);
		if (getConfigurable().get().equals(LocalTime.MIN))
			send(eventBuilder(sender, EPlatformCode.GAME_CONFIG__PVP_TIME__PVP_ENABLED_FROM_BEGINNING).build());
		else
			send(eventBuilder(sender, EPlatformCode.GAME_CONFIG__PVP_TIME__PVP_TIME_DEFINED).build(DisplayHelper.toString(pvpTime, false)));
		return true;
	}
}
