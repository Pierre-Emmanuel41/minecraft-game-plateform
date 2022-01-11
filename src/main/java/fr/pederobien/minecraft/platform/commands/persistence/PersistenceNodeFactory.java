package fr.pederobien.minecraft.platform.commands.persistence;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.platform.commands.persistence.PersistenceDeleteNode.PersistenceDeleteNodeBuilder;
import fr.pederobien.minecraft.platform.commands.persistence.PersistenceDetailsNode.PersistenceDetailsNodeBuilder;
import fr.pederobien.minecraft.platform.commands.persistence.PersistenceListNode.PersistenceListNodeBuilder;
import fr.pederobien.minecraft.platform.commands.persistence.PersistenceLoadNode.PersistenceLoadNodeBuilder;
import fr.pederobien.minecraft.platform.commands.persistence.PersistenceNewNode.PersistenceNewNodeBuilder;
import fr.pederobien.minecraft.platform.commands.persistence.PersistenceRenameNode.PersistenceRenameNodeBuilder;
import fr.pederobien.minecraft.platform.commands.persistence.PersistenceSaveNode.PersistenceSaveNodeBuilder;
import fr.pederobien.minecraft.platform.interfaces.INominable;
import fr.pederobien.minecraft.platform.interfaces.IPlatformPersistence;

public class PersistenceNodeFactory<T extends INominable> {
	private IPlatformPersistence<T> persistence;

	/**
	 * Creates a command tree for common commands.
	 * 
	 * @param persistence The persistence used by the node for common commands.
	 */
	public PersistenceNodeFactory(IPlatformPersistence<T> persistence) {
		this.persistence = persistence;
	}

	/**
	 * Get a builder in order to create a node that delete files on the server.
	 * 
	 * @param onNameIsMissing Action to perform when the name of the file to delete is missing.
	 * 
	 * @return A new instance of a DeleteNodeBuilder.
	 */
	public PersistenceDeleteNodeBuilder deleteNode(Consumer<CommandSender> onNameIsMissing) {
		return PersistenceDeleteNode.builder(persistence, onNameIsMissing);
	}

	/**
	 * Creates a PersistenceSaveNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that
	 * run the command, the <code>T</code> parameter refers to serialized object.
	 * 
	 * @param onFailToSerialize Set the action to perform when the deletion fails.
	 * 
	 * @return A new instance of a SaveNodeBuilder.
	 */
	public PersistenceSaveNodeBuilder<T> saveNode(BiConsumer<CommandSender, T> onFailToSerialize) {
		return PersistenceSaveNode.builder(persistence, onFailToSerialize);
	}

	/**
	 * Get a builder in order to display the details of the persistence object. The {@link CommandSender} refers to the entity that
	 * run the command, the <code>String</code> parameter refers to the details to display.
	 * 
	 * @param onDetails Set the action to perform when displaying the details.
	 * 
	 * @return A new instance of a PersistenceDetailsNodeBuilder.
	 */
	public PersistenceDetailsNodeBuilder<T> detailsNode(BiConsumer<CommandSender, T> onDetails) {
		return PersistenceDetailsNode.builder(persistence, onDetails);
	}

	/**
	 * Get a builder in order to display the name of files present in the persistence folder. The {@link CommandSender} refers to the
	 * entity that run the command.
	 * 
	 * @param onNoElement Action to perform when there is no element to display.
	 * 
	 * @return A new instance of a ListNodeBuilder.
	 */
	public PersistenceListNodeBuilder listNode(Consumer<CommandSender> onNoElement) {
		return PersistenceListNode.builder(persistence, onNoElement);
	}

	/**
	 * Get a builder in order to load a file present in the persistence folder. The {@link CommandSender} refers to the entity that
	 * run the command.
	 * 
	 * @param onNameIsMissing Action to perform when the name of the file to load is missing.
	 * 
	 * @return A new instance of a LoadNodeBuilder.
	 */
	public PersistenceLoadNodeBuilder<T> loadNode(Consumer<CommandSender> onNameIsMissing) {
		return PersistenceLoadNode.builder(persistence, onNameIsMissing);
	}

	/**
	 * Get a builder in order to rename the object managed by the persistence. The {@link CommandSender} refers to the entity that run
	 * the command, the <code>String</code> parameter refers to the current object name.
	 * 
	 * @param onNameIsMissing Action to perform when the name is missing while renaming the object.
	 * 
	 * @return A new instance of a PersistenceRenameNodeBuilder.
	 */
	public PersistenceRenameNodeBuilder renameNodebuilder(BiConsumer<CommandSender, String> onNameIsMissing) {
		return PersistenceRenameNode.builder(persistence, onNameIsMissing);
	}

	/**
	 * Get a builder to create new objects managed by the persistence. The {@link CommandSender} refers to the entity that run the
	 * command.
	 * 
	 * @param onNameIsMissing Action to perform when the new name is missing while creating a new object.
	 * 
	 * @return A new instance of a PersistenceNewNodeBuilder.
	 */
	public PersistenceNewNodeBuilder<T> newNodeBuilder(Consumer<CommandSender> onNameIsMissing) {
		return PersistenceNewNode.builder(persistence, onNameIsMissing);
	}

	/**
	 * @return The persistence that modifies server configuration.
	 */
	public IPlatformPersistence<T> getPersistence() {
		return persistence;
	}
}
