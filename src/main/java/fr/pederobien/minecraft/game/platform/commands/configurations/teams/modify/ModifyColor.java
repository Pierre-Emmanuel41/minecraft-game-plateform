package fr.pederobien.minecraft.game.platform.commands.configurations.teams.modify;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.game.platform.commands.configurations.teams.AbstractTeamConfigurationEdition;
import fr.pederobien.minecraft.game.platform.dictionary.ETeamModifyCode;
import fr.pederobien.minecraft.game.platform.exceptions.ColorNotFoundException;
import fr.pederobien.minecraft.game.platform.exceptions.configurations.TeamNotFoundException;
import fr.pederobien.minecraft.game.platform.exceptions.configurations.TeamWithSameColorAlreadyExistsException;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.game.platform.interfaces.element.ITeam;

public class ModifyColor<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected ModifyColor() {
		super(ETeamModifyLabel.COLOR, ETeamModifyCode.MODIFY_COLOR__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String teamName = "";
		String colorName = "";
		try {
			try {
				teamName = args[0];
			} catch (IndexOutOfBoundsException e) {
				sendSynchro(sender, ETeamModifyCode.MODIFY_COLOR__TEAM_NAME_IS_MISSING);
				return false;
			}

			try {
				colorName = args[1];
			} catch (IndexOutOfBoundsException e) {
				sendSynchro(sender, ETeamModifyCode.MODIFY_COLOR__COLOR_NAME_IS_MISSING, teamName);
				return false;
			}

			getGameConfigurationHelper().modifyTeamColor(teamName, colorName);
			sendSynchro(sender, ETeamModifyCode.MODIFY_COLOR__COLOR_UPDATED, teamName, get().getName());
			return true;
		} catch (TeamNotFoundException e) {
			sendSynchro(sender, ETeamModifyCode.MODIFY_COLOR__TEAM_DOES_NOT_EXIST, e.getTeamNotFoundName());
			return false;
		} catch (ColorNotFoundException e) {
			sendSynchro(sender, ETeamModifyCode.MODIFY_COLOR__COLOR_DOES_NOT_EXIST, teamName, e.getColorName());
			return false;
		} catch (TeamWithSameColorAlreadyExistsException e) {
			ITeam team = e.getAlreadyExistingTeam();
			sendSynchro(sender, ETeamModifyCode.MODIFY_COLOR__COLOR_ALREADY_USED, teamName, team.getColor(), team.getColoredName());
			return false;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(getGameConfigurationHelper().getTeamNames(false), args);
		case 2:
			return filter(check(args[0], e -> getGameConfigurationHelper().getTeam(e).isPresent(), getFreeColorNames(false)).stream(), args);
		default:
			return emptyList();
		}
	}
}
