package fr.pederobien.minecraft.platform.interfaces;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;

public interface IPlatformPersistence<T extends INominable> {

	/**
	 * @return The path of the folder in which this persistence serialize and deserialize objects.
	 */
	Path getPath();

	/**
	 * Load the file associated to the given name and creates a <code>T</code> object based on the parameters value.
	 * 
	 * @param name The file name to deserialize. It should only be the file name (without extension), not the path to the file.
	 * 
	 * @return True if the element has been successfully updated, false otherwise.
	 */
	boolean deserialize(String name);

	/**
	 * Load the file associated to the given name and creates a <code>T</code> object based on the parameters value.
	 * 
	 * @param element The element that should be updated according to the content of the associated file.
	 * 
	 * @return True if the element has been successfully updated, false otherwise.
	 */
	boolean deserialize(T element);

	/**
	 * Save the current object in the folder associated to this persistence.
	 * 
	 * @return True if the save went well.
	 */
	boolean serialize();

	/**
	 * @return The supplier that create new object managed by this persistence.
	 */
	Function<String, T> getCreator();

	/**
	 * @return The object managed by this persistence.
	 */
	T get();

	/**
	 * Set the element to deserialize/serialize.
	 * 
	 * @param elt The element to deserialize/serialize.
	 */
	void set(T elt);

	/**
	 * Check if there is a file associated to the given name in the persistence exists.
	 * 
	 * @param name The file name.
	 * 
	 * @return True if the file exist, false otherwise.
	 */
	boolean exist(String name);

	/**
	 * Delete the file associated to the given name from the persistence folder.
	 * 
	 * @param name The name of the file to delete.
	 * 
	 * @return true if the file has been deleted, false otherwise.
	 */
	boolean delete(String name);

	/**
	 * @return The list of file's name in the persistence folder.
	 */
	List<String> list();
}
