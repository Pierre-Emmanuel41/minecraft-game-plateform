package fr.pederobien.minecraft.game.platform.commands.common;

import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.dictionary.interfaces.IPlayerGroup;

public enum ECommonCode implements IMinecraftCode {
	// Code when the name starts with default
	NAME_MUST_NOT_START_WITH_DEFAULT,

	// Code when the file does not exists
	FILE_DOES_NOT_EXIST,

	;

	private IPlayerGroup group;

	@Override
	public String value() {
		return name();
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
