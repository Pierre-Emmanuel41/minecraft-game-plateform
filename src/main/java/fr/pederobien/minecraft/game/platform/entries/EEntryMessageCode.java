package fr.pederobien.minecraft.game.platform.entries;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EEntryMessageCode implements IMinecraftMessageCode {
	TOTAL_TIME, PAUSE_TIME, GAME_TIME, CENTER, X_Y_Z;

	private Permission permission;

	private EEntryMessageCode() {
		this(Permission.SENDER);
	}

	private EEntryMessageCode(Permission permission) {
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
