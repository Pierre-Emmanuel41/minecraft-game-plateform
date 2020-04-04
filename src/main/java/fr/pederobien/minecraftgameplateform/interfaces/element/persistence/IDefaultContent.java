package fr.pederobien.minecraftgameplateform.interfaces.element.persistence;

public interface IDefaultContent {

	/**
	 * @return The name of the default object the plugin should save.
	 */
	String getName();

	/**
	 * @return The content of the file to save.
	 */
	String getDefaultContent();
}
