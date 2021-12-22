package fr.pederobien.minecraft.game.platform.commands.common;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNode;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.game.platform.commands.persistence.PersistenceNodeFactory;
import fr.pederobien.minecraft.game.platform.interfaces.INominable;

public class SaveNode extends MinecraftCodeNode {
	private SaveNodeBuilder builder;

	private SaveNode(SaveNodeBuilder builder) {
		super("save", builder.explanation, () -> builder.tree.getPersistence().get() != null);
		this.builder = builder;
	}

	/**
	 * Creates a SaveNodeBuilder in order to serialize on object. The <code>Boolean</code> parameter refers to the succeed of the
	 * serialize action.
	 * 
	 * @param onSerializeAction Set the action to serialize an object.
	 *
	 * @return A new instance of a SaveNodeBuilder.
	 */
	protected static SaveNodeBuilder builder(Supplier<Boolean> onSerializeAction) {
		return new SaveNodeBuilder(onSerializeAction);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Consumer<CommandSender> action = builder.onSerializeAction.get() ? builder.onSerialized : builder.onFailToSerialize;
		action.accept(sender);
		return true;
	}

	public static class SaveNodeBuilder {
		private PersistenceNodeFactory<? extends INominable> tree;
		private Supplier<Boolean> onSerializeAction;
		private Consumer<CommandSender> onFailToSerialize, onSerialized;
		private IMinecraftCode explanation;

		/**
		 * Creates a SaveNodeBuilder in order to serialize on object. The <code>Boolean</code> refers to the succeed of the serialize
		 * action.
		 * 
		 * @param onSerializeAction Set the action to serialize an object.
		 */
		private SaveNodeBuilder(Supplier<Boolean> onSerializeAction) {
			this.onSerializeAction = onSerializeAction;
		}

		/**
		 * @return The action to perform when serializing an object.
		 */
		public Supplier<Boolean> getOnSerializeAction() {
			return onSerializeAction;
		}

		/**
		 * Set the action to perform when the serialization fails. The {@link CommandSender} refers to the entity that run the command.
		 * 
		 * @param onSerialized The action to perform.
		 * 
		 * @return This builder.
		 */
		public SaveNodeBuilder onFailToSerialize(Consumer<CommandSender> onFailToSerialize) {
			this.onFailToSerialize = onFailToSerialize;
			return this;
		}

		/**
		 * @return The action to perform when the serialization fails.
		 */
		public Consumer<CommandSender> getOnFailToSerialize() {
			return onFailToSerialize;
		}

		/**
		 * Set the action to perform when the serialization succeeds. The {@link CommandSender} refers to the entity that run the command,
		 * the <code>String</code> parameter refers to the file name to delete.
		 * 
		 * @param onSerialized The action to perform.
		 * 
		 * @return This builder.
		 */
		public SaveNodeBuilder onSerialized(Consumer<CommandSender> onSerialized) {
			this.onSerialized = onSerialized;
			return this;
		}

		/**
		 * @return The action to perform when an object has been serialized.
		 */
		public Consumer<CommandSender> getOnSerialized() {
			return onSerialized;
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
		public SaveNode build(IMinecraftCode explanation) {
			if (onSerializeAction == null || onFailToSerialize == null || onSerialized == null || explanation == null)
				throw new IllegalArgumentException();

			this.explanation = explanation;
			return new SaveNode(this);
		}

		/**
		 * @return The node explanation.
		 */
		public IMinecraftCode getExplanation() {
			return explanation;
		}
	}
}
