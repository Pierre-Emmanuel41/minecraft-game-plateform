package fr.pederobien.minecraft.platform.commands.persistence;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNodeWrapper;
import fr.pederobien.minecraft.commandtree.interfaces.ICodeSender;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.platform.commands.common.ECommonCode;
import fr.pederobien.minecraft.platform.commands.common.NewNode;
import fr.pederobien.minecraft.platform.commands.common.NodeBuilderFactory;
import fr.pederobien.minecraft.platform.commands.common.NewNode.NewNodeBuilder;
import fr.pederobien.minecraft.platform.interfaces.INominable;
import fr.pederobien.minecraft.platform.interfaces.IPlatformPersistence;
import fr.pederobien.utils.consumers.Consumer3;

public class PersistenceNewNode<T extends INominable> extends MinecraftCodeNodeWrapper {

	private PersistenceNewNode(NewNode<T> node) {
		super(node);
	}

	/**
	 * Creates a PersistenceNewNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that run
	 * the command.
	 * 
	 * @param persistence     The persistence associated to this node.
	 * @param onNameIsMissing Action to perform when the new name is missing.
	 * 
	 * @return A new instance of PersistenceNewNodeBuilder.
	 */
	protected static <U extends INominable> PersistenceNewNodeBuilder<U> builder(IPlatformPersistence<U> persistence, Consumer<CommandSender> onNameIsMissing) {
		return new PersistenceNewNodeBuilder<U>(persistence, onNameIsMissing);
	}

	public static class PersistenceNewNodeBuilder<T extends INominable> implements ICodeSender {
		private IPlatformPersistence<T> persistence;
		private NewNodeBuilder<T> newNodeBuilder;
		private Consumer3<CommandSender, String, String> onNameAlreadyTaken;

		/**
		 * Creates a PersistenceNewNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that run
		 * the command.
		 * 
		 * @param persistence     The persistence associated to this node.
		 * @param onNameIsMissing The action to perform when the name is missing while renaming the underlying object.
		 */
		private PersistenceNewNodeBuilder(IPlatformPersistence<T> persistence, Consumer<CommandSender> onNameIsMissing) {
			this.persistence = persistence;
			newNodeBuilder = NodeBuilderFactory.newNode(persistence.getCreator()).onNameIsMissing(onNameIsMissing);
		}

		/**
		 * @return The action to perform when the name is missing while renaming the underlying object.
		 */
		public Consumer<CommandSender> getOnNameIsMissing() {
			return newNodeBuilder.getOnNameIsMissing();
		}

		/**
		 * Set the action to perform when the new object name is already taken. The {@link CommandSender} refers to the entity that run
		 * the command, the second <code>String</code> parameter refers to the current object name and the last <code>String</code>
		 * parameter refers to the object name.
		 * 
		 * @param onNameAlreadyTaken The action to perform.
		 * 
		 * @return This builder.
		 */
		public PersistenceNewNodeBuilder<T> onNameAlreadyTaken(Consumer3<CommandSender, String, String> onNameAlreadyTaken) {
			this.onNameAlreadyTaken = onNameAlreadyTaken;
			newNodeBuilder.onValidateName((sender, name) -> {
				// The name of all new created object must not start with default.
				if (startWithIgnoreCase(name, "default")) {
					send(eventBuilder(sender, ECommonCode.NAME_MUST_NOT_START_WITH_DEFAULT, name));
					return false;
				}

				boolean valid = !persistence.exist(name);
				if (!valid)
					onNameAlreadyTaken.accept(sender, persistence.get().getName(), name);
				return valid;
			});
			return this;
		}

		/**
		 * @return The action to perform when the name is already taken.
		 */
		public Consumer3<CommandSender, String, String> getOnNameAlreadyTaken() {
			return onNameAlreadyTaken;
		}

		/**
		 * Set the action to perform when the new object is created. The {@link CommandSender} refers to the entity that run the command,
		 * the <code>T</code> parameter refers to the created object.
		 * 
		 * @param onCreated The action to perform.
		 * 
		 * @return This builder.
		 */
		public PersistenceNewNodeBuilder<T> onCreated(BiConsumer<CommandSender, T> onCreated) {
			newNodeBuilder.onCreated((sender, element) -> {
				persistence.set(element);
				onCreated.accept(sender, element);
			});
			return this;
		}

		/**
		 * @return The action to perform when the object is created.
		 */
		public BiConsumer<CommandSender, T> onCreated() {
			return newNodeBuilder.onCreated();
		}

		/**
		 * Creates a new {@link PersistenceNewNode} based on the previous parameter.
		 * 
		 * @param explanation The node explanation.
		 * 
		 * @return A new node that creates new objects of type <code>T</code>.
		 * 
		 * @throws IllegalArgumentException if one parameter is null.
		 */
		public PersistenceNewNode<T> build(IMinecraftCode explanation) {
			return new PersistenceNewNode<T>(newNodeBuilder.build(explanation));
		}

		/**
		 * @return The node explanation.
		 */
		public IMinecraftCode getExplanation() {
			return newNodeBuilder.getExplanation();
		}

		/**
		 * Verify the given string start with the specified beginning ignoring case. For example : <br>
		 * <code>str = "IBeGinLIkeThis";<br>
		 * beginning = "ibEginli";<br></code> The method return true.
		 * 
		 * @param str       The string to check.
		 * @param beginning The beginning used as reference.
		 * @return True if the string begin with the given beginning, false otherwise.
		 */
		private boolean startWithIgnoreCase(String str, String beginning) {
			return str.length() < beginning.length() ? false : str.substring(0, beginning.length()).equalsIgnoreCase(beginning);
		}
	}
}
