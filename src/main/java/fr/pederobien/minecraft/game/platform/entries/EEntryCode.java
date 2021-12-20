package fr.pederobien.minecraft.game.platform.entries;

import fr.pederobien.minecraft.dictionary.impl.PlayerGroup;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.dictionary.interfaces.IPlayerGroup;

public enum EEntryCode implements IMinecraftCode {
	TOTAL_TIME, PAUSE_TIME, GAME_TIME, CENTER, X_Y_Z;

	private IPlayerGroup group;

	private EEntryCode() {
		this.group = PlayerGroup.ALL;
	}

	@Override
	public String value() {
		return toString();
	}

	@Override
	public IPlayerGroup getGroup() {
		return group;
	}

	@Override
	public void setGroup(IPlayerGroup group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return String.format("value=%s,group=%s", value(), getGroup());
	}
}
