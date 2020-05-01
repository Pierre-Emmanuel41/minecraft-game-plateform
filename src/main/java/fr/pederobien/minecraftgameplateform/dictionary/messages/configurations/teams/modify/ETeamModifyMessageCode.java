package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum ETeamModifyMessageCode implements IMessageCode {
	// Code for command modify name
	MODIFY_NAME__EXPLANATION, MODIFY_NAME__OLD_NAME_IS_MISSING, MODIFY_NAME__NEW_NAME_IS_MISSING;

	private Permission permission;

	private ETeamModifyMessageCode() {
		this(Permission.OPERATORS);
	}

	private ETeamModifyMessageCode(Permission permission) {
		this.permission = permission;
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
