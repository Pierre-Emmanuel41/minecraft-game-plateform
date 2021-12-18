package fr.pederobien.minecraft.gameplateform.dictionary;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum ETeamModifyMessageCode implements IMinecraftMessageCode {
	// Code for command modify name
	MODIFY_NAME__EXPLANATION, MODIFY_NAME__OLD_NAME_IS_MISSING, MODIFY_NAME__NEW_NAME_IS_MISSING, MODIFY_NAME__TEAM_DOES_NOT_EXIST, MODIFY_NAME__TEAM_NAME_FORBIDDEN,
	MODIFY_NAME__TEAM_NAME_ALREADY_USED, MODIFY_NAME__TEAM_RENAMED,

	// Code for command modify color
	MODIFY_COLOR__EXPLANATION, MODIFY_COLOR__TEAM_NAME_IS_MISSING, MODIFY_COLOR__COLOR_NAME_IS_MISSING, MODIFY_COLOR__TEAM_DOES_NOT_EXIST,
	MODIFY_COLOR__COLOR_DOES_NOT_EXIST, MODIFY_COLOR__COLOR_ALREADY_USED, MODIFY_COLOR__COLOR_UPDATED;

	private Permission permission;

	private ETeamModifyMessageCode() {
		this(Permission.OPERATORS);
	}

	private ETeamModifyMessageCode(Permission permission) {
		this.permission = permission;
	}

	@Override
	public String value() {
		return toString();
	}

	@Override
	public Permission getPermission() {
		return permission;
	}

	@Override
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
}
