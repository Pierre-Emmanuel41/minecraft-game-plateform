package fr.pederobien.minecraft.game.platform.commands.persistence;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNodeWrapper;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.game.commands.ListNode;
import fr.pederobien.minecraft.game.commands.ListNode.ListNodeBuilder;
import fr.pederobien.minecraft.game.platform.commands.common.NodeBuilderFactory;
import fr.pederobien.minecraft.game.platform.interfaces.INominable;
import fr.pederobien.minecraft.game.platform.interfaces.IPlatformPersistence;

public class PersistenceListNode extends MinecraftCodeNodeWrapper {

	private PersistenceListNode(ListNode<String> node) {
		super(node);
	}

	/**
	 * Creates a PersistenceListNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that
	 * run the command.
	 * 
	 * @param persistence The persistence associated to this node.
	 * @param onNoElement Action to perform when there is no element to display.
	 * 
	 * @return A new instance of a PersistenceListNodeBuilder.
	 */
	protected static PersistenceListNodeBuilder builder(IPlatformPersistence<? extends INominable> persistence, Consumer<CommandSender> onNoElement) {
		return new PersistenceListNodeBuilder(persistence, onNoElement);
	}

	public static class PersistenceListNodeBuilder {
		private ListNodeBuilder<String> listNodeBuilder;

		/**
		 * Creates a PersistenceListNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that
		 * run the command.
		 * 
		 * @param persistence The persistence associated to this node.
		 * @param onNoElement Action to perform when there is no element to display.
		 */
		private PersistenceListNodeBuilder(IPlatformPersistence<? extends INominable> persistence, Consumer<CommandSender> onNoElement) {
			listNodeBuilder = NodeBuilderFactory.listNode(() -> persistence.list()).onNoElement(onNoElement);
		}

		/**
		 * @return The action to perform when there is no element in the list.
		 */
		public Consumer<CommandSender> getOnNoElement() {
			return listNodeBuilder.getOnNoElement();
		}

		/**
		 * Set the action to perform when there is one element in the list. The {@link CommandSender} refers to the entity that run the
		 * command, the <code>String</code> parameter refers to the element in the list.
		 * 
		 * @param onOneElement The action to perform.
		 */
		public PersistenceListNodeBuilder onOneElement(BiConsumer<CommandSender, String> onOneElement) {
			listNodeBuilder.onOneElement(onOneElement);
			return this;
		}

		/**
		 * @return The action to perform when there is one element in the list.
		 */
		public BiConsumer<CommandSender, String> getOnOneElement() {
			return listNodeBuilder.getOnOneElement();
		}

		/**
		 * Set the action to perform when there are several elements in the list. The {@link CommandSender} refers to the entity that run
		 * the command, the <code>List&lt;String&gt;</code> parameter refers to list of elements.
		 * 
		 * @param onSeveralElements The action to perform.
		 */
		public PersistenceListNodeBuilder onSeveralElements(BiConsumer<CommandSender, List<String>> onSeveralElements) {
			listNodeBuilder.onSeveralElements(onSeveralElements);
			return this;
		}

		/**
		 * @return The action to perform when there are several elements in the list.
		 */
		public BiConsumer<CommandSender, List<String>> getOnSeveralElements() {
			return listNodeBuilder.getOnSeveralElements();
		}

		/**
		 * Creates a new {@link PersistenceDeleteNode} based on the previous parameter.
		 * 
		 * @param explanation The node explanation.
		 * 
		 * @return A new node that deletes files on the server.
		 * 
		 * @throws IllegalArgumentException if one parameter is null.
		 */
		public PersistenceListNode build(IMinecraftCode explanation) {
			return new PersistenceListNode(listNodeBuilder.build(explanation));
		}

		/**
		 * @return The node explanation.
		 */
		public IMinecraftCode getExplanation() {
			return listNodeBuilder.getExplanation();
		}
	}
}
