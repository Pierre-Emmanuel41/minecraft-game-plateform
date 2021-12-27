package fr.pederobien.minecraft.platform.commands.persistence;

import java.util.function.BiConsumer;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNodeWrapper;
import fr.pederobien.minecraft.commandtree.interfaces.ICodeSender;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.platform.commands.common.ECommonCode;
import fr.pederobien.minecraft.platform.commands.common.NodeBuilderFactory;
import fr.pederobien.minecraft.platform.commands.common.RenameNode;
import fr.pederobien.minecraft.platform.commands.common.RenameNode.RenameNodeBuilder;
import fr.pederobien.minecraft.platform.interfaces.INominable;
import fr.pederobien.minecraft.platform.interfaces.IPlatformPersistence;
import fr.pederobien.utils.consumers.Consumer3;

public class PersistenceRenameNode extends MinecraftCodeNodeWrapper {

	private PersistenceRenameNode(RenameNode node) {
		super(node);
	}

	/**
	 * Creates a PersistenceRenameNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that
	 * run the command, the <code>String</code> parameter refers to the current object name.
	 * 
	 * @param persistence     The persistence associated to this node.
	 * @param onNameIsMissing Action to perform when the new name is missing.
	 * 
	 * @return A new instance of a PersistenceRenameNodeBuilder.
	 */
	protected static PersistenceRenameNodeBuilder builder(IPlatformPersistence<? extends INominable> persistence, BiConsumer<CommandSender, String> onNameIsMissing) {
		return new PersistenceRenameNodeBuilder(persistence, onNameIsMissing);
	}

	public static class PersistenceRenameNodeBuilder implements ICodeSender {
		private IPlatformPersistence<? extends INominable> persistence;
		private RenameNodeBuilder renameNodeBuilder;
		private Consumer3<CommandSender, String, String> onNameAlreadyTaken;

		/**
		 * Creates a PersistenceRenameNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that
		 * run the command, the <code>String</code> parameter refers to the current object name.
		 * 
		 * @param persistence     The tree that reference the persistence that delete files on the server.
		 * @param onNameIsMissing Action to perform when the new name is missing.
		 */
		private PersistenceRenameNodeBuilder(IPlatformPersistence<? extends INominable> persistence, BiConsumer<CommandSender, String> onNameIsMissing) {
			this.persistence = persistence;
			renameNodeBuilder = NodeBuilderFactory.renameNode(persistence.get(), onNameIsMissing);
		}

		/**
		 * @return The action to perform when the name is missing.
		 */
		public BiConsumer<CommandSender, String> getOnNameIsMissing() {
			return renameNodeBuilder.getOnNameIsMissing();
		}

		/**
		 * Set the action to perform when the new object name is already taken. The {@link CommandSender} refers to the entity that run
		 * the command, the second <code>String</code> parameter refers to the current object name and the last <code>String</code>
		 * parameter refers to the new object name.
		 * 
		 * @param onNameAlreadyTaken The action to perform.
		 * 
		 * @return This builder.
		 */
		public PersistenceRenameNodeBuilder onNameAlreadyTaken(Consumer3<CommandSender, String, String> onNameAlreadyTaken) {
			this.onNameAlreadyTaken = onNameAlreadyTaken;
			renameNodeBuilder.onValidateName((sender, name) -> {
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
		 * Set the action to perform when the deletion succeed. The {@link CommandSender} refers to the entity that run the command, the
		 * second <code>String</code> parameter refers to the current object name and the last <code>String</code> parameter refers to the
		 * new object name.
		 * 
		 * @param onRenamed The action to perform.
		 * 
		 * @return This builder.
		 */
		public PersistenceRenameNodeBuilder onRenamed(Consumer3<CommandSender, String, String> onRenamed) {
			renameNodeBuilder.onRenamed((sender, oldName, newName) -> {
				persistence.delete(oldName);
				persistence.serialize();
				onRenamed.accept(sender, oldName, newName);
			});
			return this;
		}

		/**
		 * Creates a new {@link RenameNode} based on the previous parameter.
		 * 
		 * @param explanation The node explanation.
		 * 
		 * @return A new node that deletes files on the server.
		 * 
		 * @throws IllegalArgumentException if one parameter is null.
		 */
		public PersistenceRenameNode build(IMinecraftCode explanation) {
			return new PersistenceRenameNode(renameNodeBuilder.build(explanation));
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
