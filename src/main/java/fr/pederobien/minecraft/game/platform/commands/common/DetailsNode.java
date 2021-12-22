package fr.pederobien.minecraft.game.platform.commands.common;

import java.util.function.BiConsumer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNode;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.game.platform.commands.persistence.PersistenceSaveNode;

public class DetailsNode extends MinecraftCodeNode {
	private DetailsNodeBuilder builder;

	private DetailsNode(DetailsNodeBuilder builder) {
		super(ECommonLabel.DETAILS.getLabel(), builder.explanation);
		this.builder = builder;
	}

	/**
	 * Creates a DetailsNodeBuilder based on the given element. The {@link CommandSender} refers to the entity that run the command,
	 * the <code>String</code> parameter refers to the details to display.
	 * 
	 * @param element   The element used to display the string returned by the <code>toString</code> method.
	 * @param onDetails Set the action to perform when displaying the details.
	 * 
	 * @return A new instance of a DetailsNodeBuilder.
	 */
	protected static DetailsNodeBuilder builder(Object element, BiConsumer<CommandSender, String> onDetails) {
		return new DetailsNodeBuilder(element, onDetails);
	}

	@Override
	public final boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		builder.onDetails.accept(sender, builder.element.toString());
		return true;
	}

	public static class DetailsNodeBuilder {
		private Object element;
		private BiConsumer<CommandSender, String> onDetails;
		private IMinecraftCode explanation;

		/**
		 * Creates a DetailsNodeBuilder based on the given element. The {@link CommandSender} refers to the entity that run the command,
		 * the <code>String</code> parameter refers to the element's details to display.
		 * 
		 * @param element   The element used to display the string returned by the <code>toString</code> method.
		 * @param onDetails Action to perform when displaying the details of the underlying object.
		 */
		private DetailsNodeBuilder(Object element, BiConsumer<CommandSender, String> onDetails) {
			this.element = element;
			this.onDetails = onDetails;
		}

		/**
		 * @return The action to perform in order to display element details.
		 */
		public BiConsumer<CommandSender, String> getOnDetails() {
			return onDetails;
		}

		/**
		 * Creates a new {@link PersistenceSaveNode} based on the previous parameter.
		 * 
		 * @param explanation The node explanation.
		 * 
		 * @return A new node that display the details of the underlying element.
		 * 
		 * @throws IllegalArgumentException if one parameter is null.
		 */
		public DetailsNode build(IMinecraftCode explanation) {
			if (element == null || onDetails == null || explanation == null)
				throw new IllegalArgumentException();

			this.explanation = explanation;
			return new DetailsNode(this);
		}

		/**
		 * @return The node explanation.
		 */
		public IMinecraftCode getExplanation() {
			return explanation;
		}
	}
}
