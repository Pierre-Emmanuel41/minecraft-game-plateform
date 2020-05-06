package fr.pederobien.minecraftgameplateform.border.persistence;

public enum BorderXmlTag {
	NAME("name"), WORLD("world"), CENTER("center"), X_COORDINATE("x"), Z_COORDINATE("z"), INITIAL_DIAMETER("initialdiameter"), FINAL_DIAMETER("finaldiameter"),
	BORDER_SPEED("borderspeed");

	private String name;

	private BorderXmlTag(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
