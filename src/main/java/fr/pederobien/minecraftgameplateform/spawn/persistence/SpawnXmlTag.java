package fr.pederobien.minecraftgameplateform.spawn.persistence;

public enum SpawnXmlTag {
	NAME("name"), WORLD("world"), DIMENSIONS("dimensions"), WIDTH("width"), HEIGHT("height"), DEPTH("depth"), CENTER("center"), X_COORDINATES("x"), Y_COORDINATES("y"),
	Z_COORDINATES("z"), PLAYER_SPAWN("playerspawn"), BLOCKS("blocks"), BLOCK("block"), BLOCK_DATA("blockdata"), ALLOW_MOBS_UNDER_SPAWN("allowmobsunderspawn");

	private String name;

	private SpawnXmlTag(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
