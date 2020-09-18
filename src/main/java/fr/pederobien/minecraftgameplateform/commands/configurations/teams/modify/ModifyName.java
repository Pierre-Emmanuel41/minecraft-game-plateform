package fr.pederobien.minecraftgameplateform.commands.configurations.teams.modify;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.configurations.teams.AbstractTeamConfigurationEdition;
import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.ETeamModifyMessageCode;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNameForbiddenException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamWithSameNameAlreadyExistsException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;

public class ModifyName<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected ModifyName() {
		super(ETeamModifyLabel.NAME, ETeamModifyMessageCode.MODIFY_NAME__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String oldName = "";
		try {
			try {
				oldName = args[0];
			} catch (IndexOutOfBoundsException e) {
				sendSynchro(sender, ETeamModifyMessageCode.MODIFY_NAME__OLD_NAME_IS_MISSING);
				return false;
			}
			String newName = "";
			try {
				newName = args[1];
			} catch (IndexOutOfBoundsException e) {
				sendSynchro(sender, ETeamModifyMessageCode.MODIFY_NAME__NEW_NAME_IS_MISSING, oldName);
				return false;
			}
			ITeam renamedTeam = getGameConfigurationHelper().renameTeam(oldName, newName);
			sendSynchro(sender, ETeamModifyMessageCode.MODIFY_NAME__TEAM_RENAMED, renamedTeam.getColor().getInColor(oldName), renamedTeam.getColoredName());
		} catch (TeamNotFoundException e) {
			sendSynchro(sender, ETeamModifyMessageCode.MODIFY_NAME__TEAM_DOES_NOT_EXIST, e.getTeamNotFoundName(), get().getName());
			return false;
		} catch (TeamNameForbiddenException e) {
			sendSynchro(sender, ETeamModifyMessageCode.MODIFY_NAME__TEAM_NAME_FORBIDDEN, oldName, e.getForbiddenName());
			return false;
		} catch (TeamWithSameNameAlreadyExistsException e) {
			sendSynchro(sender, ETeamModifyMessageCode.MODIFY_NAME__TEAM_NAME_ALREADY_USED, oldName, e.getAlreadyExistingTeam().getName());
			return false;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(getGameConfigurationHelper().getTeamNames(false), args[0]);
		case 2:
			return Arrays.asList(getMessage(sender, ECommonMessageCode.COMMON_RENAME_TAB_COMPLETE));
		}
		return super.onTabComplete(sender, command, alias, args);
	}

}
