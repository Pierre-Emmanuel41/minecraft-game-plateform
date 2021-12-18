package fr.pederobien.minecraft.gameplateform.dictionary;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EGameMessageCode implements IMinecraftMessageCode {
	// Code for command startgame
	START_GAME__EXPLANATION(Permission.SENDER),

	// Code for command pausegame
	PAUSE_GAME__EXPLANATION(Permission.SENDER),

	// Code for command stopgame
	STOP_GAME__EXPLANATION(Permission.SENDER),

	// Code for game messages
	STARTING_GAME(Permission.ALL), NO_CONFIGURATION_SETTED(Permission.SENDER), PAUSING_GAME(Permission.ALL), RESUMING_GAME(Permission.ALL), STOPPING_GAME(Permission.ALL);

	private Permission permission;

	private EGameMessageCode(Permission permission) {
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
