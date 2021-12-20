package fr.pederobien.minecraft.game.platform.commands.configurations.teams.modify;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.game.platform.commands.configurations.teams.AbstractTeamConfigurationEdition;
import fr.pederobien.minecraft.game.platform.dictionary.ECommonCode;
import fr.pederobien.minecraft.game.platform.dictionary.ETeamModifyCode;
import fr.pederobien.minecraft.game.platform.exceptions.configurations.TeamNameForbiddenException;
import fr.pederobien.minecraft.game.platform.exceptions.configurations.TeamNotFoundException;
import fr.pederobien.minecraft.game.platform.exceptions.configurations.TeamWithSameNameAlreadyExistsException;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.game.platform.interfaces.element.ITeam;

public class ModifyName<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected ModifyName() {
		super(ETeamModifyLabel.NAME, ETeamModifyCode.MODIFY_NAME__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String oldName = "";
		try {
			try {
				oldName = args[0];
			} catch (IndexOutOfBoundsException e) {
				sendSynchro(sender, ETeamModifyCode.MODIFY_NAME__OLD_NAME_IS_MISSING);
				return false;
			}
			String newName = "";
			try {
				newName = args[1];
			} catch (IndexOutOfBoundsException e) {
				sendSynchro(sender, ETeamModifyCode.MODIFY_NAME__NEW_NAME_IS_MISSING, oldName);
				return false;
			}
			ITeam renamedTeam = getGameConfigurationHelper().renameTeam(oldName, newName);
			sendSynchro(sender, ETeamModifyCode.MODIFY_NAME__TEAM_RENAMED, renamedTeam.getColor().getInColor(oldName), renamedTeam.getColoredName());
		} catch (TeamNotFoundException e) {
			sendSynchro(sender, ETeamModifyCode.MODIFY_NAME__TEAM_DOES_NOT_EXIST, e.getTeamNotFoundName(), get().getName());
			return false;
		} catch (TeamNameForbiddenException e) {
			sendSynchro(sender, ETeamModifyCode.MODIFY_NAME__TEAM_NAME_FORBIDDEN, oldName, e.getForbiddenName());
			return false;
		} catch (TeamWithSameNameAlreadyExistsException e) {
			sendSynchro(sender, ETeamModifyCode.MODIFY_NAME__TEAM_NAME_ALREADY_USED, oldName, e.getAlreadyExistingTeam().getName());
			return false;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(getGameConfigurationHelper().getTeamNames(false), args);
		case 2:
			return asList(getMessage(sender, ECommonCode.COMMON_RENAME_TAB_COMPLETE));
		default:
			return emptyList();
		}
	}

}
