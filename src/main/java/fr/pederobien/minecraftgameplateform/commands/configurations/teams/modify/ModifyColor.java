package fr.pederobien.minecraftgameplateform.commands.configurations.teams.modify;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.configurations.teams.AbstractTeamConfigurationEdition;
import fr.pederobien.minecraftgameplateform.dictionary.ETeamModifyMessageCode;
import fr.pederobien.minecraftgameplateform.exceptions.ColorNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamWithSameColorAlreadyExistsException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;

public class ModifyColor<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected ModifyColor() {
		super(ETeamModifyLabel.COLOR, ETeamModifyMessageCode.MODIFY_COLOR__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String teamName = "";
		String colorName = "";
		try {
			try {
				teamName = args[0];
			} catch (IndexOutOfBoundsException e) {
				sendMessageToSender(sender, ETeamModifyMessageCode.MODIFY_COLOR__TEAM_NAME_IS_MISSING);
				return false;
			}

			try {
				colorName = args[1];
			} catch (IndexOutOfBoundsException e) {
				sendMessageToSender(sender, ETeamModifyMessageCode.MODIFY_COLOR__COLOR_NAME_IS_MISSING, teamName);
				return false;
			}

			getGameConfigurationHelper().modifyTeamColor(teamName, colorName);
			sendMessageToSender(sender, ETeamModifyMessageCode.MODIFY_COLOR__COLOR_UPDATED, teamName, get().getName());
			return true;
		} catch (TeamNotFoundException e) {
			sendMessageToSender(sender, ETeamModifyMessageCode.MODIFY_COLOR__TEAM_DOES_NOT_EXIST, e.getTeamNotFoundName());
			return false;
		} catch (ColorNotFoundException e) {
			sendMessageToSender(sender, ETeamModifyMessageCode.MODIFY_COLOR__COLOR_DOES_NOT_EXIST, teamName, e.getColorName());
			return false;
		} catch (TeamWithSameColorAlreadyExistsException e) {
			ITeam team = e.getAlreadyExistingTeam();
			sendMessageToSender(sender, ETeamModifyMessageCode.MODIFY_COLOR__COLOR_ALREADY_USED, teamName, team.getColor(), team.getColoredName());
			return false;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(getGameConfigurationHelper().getTeamNames(false), args[0]);
		case 2:
			return filter(check(args[0], e -> getGameConfigurationHelper().getTeam(e).isPresent(), getFreeColorNames(false)).stream(), args[1]);
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
