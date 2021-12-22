package fr.pederobien.minecraft.game.platform.commands.persistence;

import java.util.function.BiConsumer;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNodeWrapper;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.game.platform.commands.common.DetailsNode;
import fr.pederobien.minecraft.game.platform.commands.common.NodeBuilderFactory;
import fr.pederobien.minecraft.game.platform.commands.common.DetailsNode.DetailsNodeBuilder;
import fr.pederobien.minecraft.game.platform.interfaces.INominable;
import fr.pederobien.minecraft.game.platform.interfaces.IPlatformPersistence;

public class PersistenceDetailsNode extends MinecraftCodeNodeWrapper {

	private PersistenceDetailsNode(DetailsNode node) {
		super(node);
	}

	/**
	 * Creates a PersistenceDetailsNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that
	 * run the command, the <code>String</code> parameter refers to the details to display.
	 * 
	 * @param persistence The persistence associated to this node.
	 * @param onDetails   Set the action to perform when displaying the details of the object managed by the persistence.
	 * 
	 * @return A new instance of a PersistenceDetailsNodeBuilder.
	 */
	protected static PersistenceDetailsNodeBuilder builder(IPlatformPersistence<? extends INominable> persistence, BiConsumer<CommandSender, String> onDetails) {
		return new PersistenceDetailsNodeBuilder(persistence, onDetails);
	}

	public static class PersistenceDetailsNodeBuilder {
		private DetailsNodeBuilder detailsNodeBuilder;

		/**
		 * Creates a PersistenceDetailsNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that
		 * command, the <code>String</code> parameter refers to the details to display.
		 * 
		 * @param persistence The persistence associated to this node.
		 * @param onDetails   Action to perform when displaying the details of the object managed by the persistence.
		 */
		private PersistenceDetailsNodeBuilder(IPlatformPersistence<? extends INominable> persistence, BiConsumer<CommandSender, String> onDetails) {
			detailsNodeBuilder = NodeBuilderFactory.detailsNode(persistence.get(), onDetails);
		}

		/**
		 * @return The action to perform in order to display the details of the object managed by the persistence.
		 */
		public BiConsumer<CommandSender, String> getOnDetails() {
			return detailsNodeBuilder.getOnDetails();
		}

		/**
		 * Creates a new {@link PersistenceDetailsNode} based on the previous parameter.
		 * 
		 * @param explanation The node explanation.
		 * 
		 * @return A new node that display the details of the object managed by the persistence.
		 * 
		 * @throws IllegalArgumentException if one parameter is null.
		 */
		public PersistenceDetailsNode build(IMinecraftCode explanation) {
			return new PersistenceDetailsNode(detailsNodeBuilder.build(explanation));
		}

		/**
		 * @return The node explanation.
		 */
		public IMinecraftCode getExplanation() {
			return detailsNodeBuilder.getExplanation();
		}
	}
}