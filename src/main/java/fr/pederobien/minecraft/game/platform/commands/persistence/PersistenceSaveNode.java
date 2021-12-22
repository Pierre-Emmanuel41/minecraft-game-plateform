package fr.pederobien.minecraft.game.platform.commands.persistence;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNodeWrapper;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.game.platform.commands.common.NodeBuilderFactory;
import fr.pederobien.minecraft.game.platform.commands.common.SaveNode;
import fr.pederobien.minecraft.game.platform.commands.common.SaveNode.SaveNodeBuilder;
import fr.pederobien.minecraft.game.platform.interfaces.INominable;
import fr.pederobien.minecraft.game.platform.interfaces.IPlatformPersistence;

public class PersistenceSaveNode extends MinecraftCodeNodeWrapper {

	private PersistenceSaveNode(SaveNode node) {
		super(node);
	}

	/**
	 * Creates a PersistenceSaveNodeBuilder base on the specified persistence. The {@link CommandSender} refers to the entity that run
	 * the command, the <code>String</code> parameter refers to the object name to serialize.
	 * 
	 * @param persistence       The persistence associated to this node.
	 * @param onFailToSerialize Set the action to perform when the deletion fails.
	 * 
	 * @return A new instance of a PersistenceSaveNodeBuilder.
	 */
	protected static PersistenceSaveNodeBuilder builder(IPlatformPersistence<? extends INominable> persistence, BiConsumer<CommandSender, String> onFailToSerialize) {
		return new PersistenceSaveNodeBuilder(persistence, onFailToSerialize);
	}

	public static class PersistenceSaveNodeBuilder {
		private SaveNodeBuilder saveNodeBuilder;

		/**
		 * Creates a PersistenceSaveNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that
		 * run the command, the <code>String</code> parameter refers to the object name to serialize.
		 * 
		 * @param persistence       The persistence associated to this node.
		 * @param onFailToSerialize Set the action to perform when the serialization fails.
		 */
		private PersistenceSaveNodeBuilder(IPlatformPersistence<? extends INominable> persistence, BiConsumer<CommandSender, String> onFailToSerialize) {
			saveNodeBuilder = NodeBuilderFactory.saveNode(() -> persistence.serialize());
			saveNodeBuilder.onFailToSerialize((sender) -> onFailToSerialize.accept(sender, persistence.get().getName()));
		}

		/**
		 * @return The action to perform when serializing an object.
		 */
		public Supplier<Boolean> getOnSerializeAction() {
			return saveNodeBuilder.getOnSerializeAction();
		}

		/**
		 * @return The action to perform when the serialization fails.
		 */
		public Consumer<CommandSender> getOnFailToSerialize() {
			return saveNodeBuilder.getOnFailToSerialize();
		}

		/**
		 * Set the action to perform when the serialization succeeds. The {@link CommandSender} refers to the entity that run the command,
		 * the <code>String</code> parameter refers to the file name to delete.
		 * 
		 * @param onSerialized The action to perform.
		 * 
		 * @return This builder.
		 */
		public PersistenceSaveNodeBuilder onSerialized(Consumer<CommandSender> onSerialized) {
			saveNodeBuilder.onSerialized(onSerialized);
			return this;
		}

		/**
		 * @return The action to perform when an object has been serialized.
		 */
		public Consumer<CommandSender> getOnSerialized() {
			return saveNodeBuilder.getOnSerialized();
		}

		/**
		 * Creates a new {@link SaveNode} based on the previous parameter.
		 * 
		 * @param explanation The node explanation.
		 * 
		 * @return A new node that serialize information on the server.
		 * 
		 * @throws IllegalArgumentException if one parameter is null.
		 */
		public PersistenceSaveNode build(IMinecraftCode explanation) {
			return new PersistenceSaveNode(saveNodeBuilder.build(explanation));
		}

		/**
		 * @return The node explanation.
		 */
		public IMinecraftCode getExplanation() {
			return saveNodeBuilder.getExplanation();
		}
	}
}
