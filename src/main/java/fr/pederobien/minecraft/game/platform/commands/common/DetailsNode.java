package fr.pederobien.minecraft.game.platform.commands.common;

import java.util.function.BiConsumer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNode;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.game.platform.commands.persistence.PersistenceSaveNode;

public class DetailsNode<T> extends MinecraftCodeNode {
	private DetailsNodeBuilder<T> builder;

	private DetailsNode(DetailsNodeBuilder<T> builder) {
		super("details", builder.explanation);
		this.builder = builder;
	}

	/**
	 * Creates a DetailsNodeBuilder based on the given element. The {@link CommandSender} refers to the entity that run the command,
	 * the <code>T</code> parameter refers to type of element whose details should be displayed.
	 * 
	 * @param element   The element used to display its details.
	 * @param onDetails Action to perform when displaying the details of the underlying object.
	 * 
	 * @return A new instance of a DetailsNodeBuilder.
	 */
	protected static <U> DetailsNodeBuilder<U> builder(U element, BiConsumer<CommandSender, U> onDetails) {
		return new DetailsNodeBuilder<U>(element, onDetails);
	}

	@Override
	public final boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		builder.onDetails.accept(sender, builder.element);
		return true;
	}

	public static class DetailsNodeBuilder<T> {
		private T element;
		private BiConsumer<CommandSender, T> onDetails;
		private IMinecraftCode explanation;

		/**
		 * Creates a DetailsNodeBuilder based on the given element. The {@link CommandSender} refers to the entity that run the command,
		 * the <code>T</code> parameter refers to type of element whose details should be displayed.
		 * 
		 * @param element   The element used to display its details.
		 * @param onDetails Action to perform when displaying the details of the underlying object.
		 */
		private DetailsNodeBuilder(T element, BiConsumer<CommandSender, T> onDetails) {
			this.element = element;
			this.onDetails = onDetails;
		}

		/**
		 * @return The action to perform in order to display element details.
		 */
		public BiConsumer<CommandSender, T> getOnDetails() {
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
		public DetailsNode<T> build(IMinecraftCode explanation) {
			if (onDetails == null || explanation == null)
				throw new IllegalArgumentException();

			this.explanation = explanation;
			return new DetailsNode<T>(this);
		}

		/**
		 * @return The node explanation.
		 */
		public IMinecraftCode getExplanation() {
			return explanation;
		}
	}
}
