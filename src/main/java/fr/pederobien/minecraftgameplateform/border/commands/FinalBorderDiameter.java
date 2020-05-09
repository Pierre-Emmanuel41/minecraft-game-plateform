package fr.pederobien.minecraftgameplateform.border.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.border.messages.EBorderMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;

public class FinalBorderDiameter extends AbstractLabelEdition<IBorderConfiguration> {

	protected FinalBorderDiameter() {
		super(EBorderLabel.FINAL_DIAMETER, EBorderMessageCode.FINAL_BORDER_DIAMETER__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			int diameter = Integer.parseInt(args[0]);
			if (diameter <= 0) {
				sendMessageToSender(sender, EBorderMessageCode.FINAL_BORDER_DIAMETER__NEGATIVE_DIAMETER, get().getName());
				return false;
			}

			get().setFinalBorderDiameter(diameter);
			sendMessageToSender(sender, EBorderMessageCode.FINAL_BORDER_DIAMETER__DIAMETER_DEFINED, get().getName(), get().getFinalBorderDiameter());
			return true;
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, EBorderMessageCode.FINAL_BORDER_DIAMETER__DIAMETER_IS_MISSING, get().getName());
			return false;
		} catch (NumberFormatException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_BAD_INTEGER_FORMAT);
			return false;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return check(args[0], e -> isNotStrictInt(e), Arrays.asList(getMessageFromDictionary(sender, EBorderMessageCode.FINAL_BORDER_DIAMETER__ON_TAB_COMPLETE)));
		return super.onTabComplete(sender, command, alias, args);
	}

}
