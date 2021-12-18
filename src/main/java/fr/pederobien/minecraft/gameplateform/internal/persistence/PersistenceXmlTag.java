package fr.pederobien.minecraft.gameplateform.internal.persistence;

public enum PersistenceXmlTag {
	PERSISTENCIES("persistencies"), PERSISTENCE("persistence"), CLASS("class"), VERSION("version");

	private String name;

	private PersistenceXmlTag(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
