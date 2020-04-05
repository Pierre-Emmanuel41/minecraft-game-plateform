package fr.pederobien.minecraftgameplateform.worldstructure.spawn.persistence;

public enum SpawnXmlTag {
	NAME("name"), DIMENSIONS("dimensions"), WIDTH("width"), HEIGHT("height"), DEPTH("depth"), CENTER("center"), X_COORDINATES("x"), Y_COORDINATES("y"),
	Z_COORDINATES("z"), PLAYER_SPAWN("playerspawn"), BLOCKS("blocks"), BLOCK("block"), BLOCK_DATA("blockdata");

	private String name;

	private SpawnXmlTag(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
