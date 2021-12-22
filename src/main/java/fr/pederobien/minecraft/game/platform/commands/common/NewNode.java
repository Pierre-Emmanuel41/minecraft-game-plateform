package fr.pederobien.minecraft.game.platform.commands.common;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNode;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.game.impl.EGameCode;

public class NewNode<T> extends MinecraftCodeNode {
	private NewNodeBuilder<T> builder;

	private NewNode(NewNodeBuilder<T> builder) {
		super("new", builder.explanation);
	}

	/**
	 * Creates a NewNodeBuilder in order to create new objects. The <code>String</code> refers to the name of the created object, the
	 * <code>U</code> refers to the type of the object to create.
	 * 
	 * @param creator The function used to create new objects.
	 * 
	 * @return A new instance of NewNodeBuilder.
	 */
	protected static <U> NewNodeBuilder<U> builder(Function<String, U> creator) {
		return new NewNodeBuilder<U>(creator);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String name;
		try {
			name = args[0];
		} catch (IndexOutOfBoundsException e) {
			builder.onNameIsMissing.accept(sender);
			return false;
		}

		// Validate or invalidate the new name.
		if (!builder.onValidateName.apply(sender, name))
			return false;

		builder.onCreated.accept(sender, builder.creator.apply(name));
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return asList(getMessage(sender, EGameCode.NAME__COMPLETION));
		default:
			return emptyList();
		}
	}

	public static class NewNodeBuilder<T> {
		private Function<String, T> creator;
		private Consumer<CommandSender> onNameIsMissing;
		private BiFunction<CommandSender, String, Boolean> onValidateName;
		private BiConsumer<CommandSender, T> onCreated;
		private IMinecraftCode explanation;

		/**
		 * Creates a NewNodeBuilder in order to create new objects. The <code>String</code> refers to the name of the created object, the
		 * <code>U</code> refers to the type of the object to create.
		 * 
		 * @param creator The function used to create new objects.
		 */
		private NewNodeBuilder(Function<String, T> creator) {
			this.creator = creator;
		}

		/**
		 * The {@link CommandSender} refers to the entity that run the command.
		 * 
		 * @param onNameIsMissing Action to perform when the new name is missing.
		 * 
		 * @return This builder.
		 */
		public NewNodeBuilder<T> onNameIsMissing(Consumer<CommandSender> onNameIsMissing) {
			this.onNameIsMissing = onNameIsMissing;
			return this;
		}

		/**
		 * @return The action to perform when the name is missing while renaming the underlying object.
		 */
		public Consumer<CommandSender> getOnNameIsMissing() {
			return onNameIsMissing;
		}

		/**
		 * Set the action to validate or invalidate the name of the created object. The {@link CommandSender} refers to the entity that
		 * run the command, the <code>String</code> parameter refers to the object name and the last <code>Boolean</code> returns true to
		 * validate the name, false otherwise.
		 * 
		 * @param onValidateName The action to perform.
		 * 
		 * @return This builder.
		 */
		public NewNodeBuilder<T> onValidateName(BiFunction<CommandSender, String, Boolean> onValidateName) {
			this.onValidateName = onValidateName;
			return this;
		}

		/**
		 * @return The action to validate or invalidate the object name.
		 */
		public BiFunction<CommandSender, String, Boolean> getOnValidateName() {
			return onValidateName;
		}

		/**
		 * Set the action to perform when the new object is created. The {@link CommandSender} refers to the entity that run the command,
		 * the <code>T</code> parameter refers to the created object.
		 * 
		 * @param onDeleted The action to perform.
		 * 
		 * @return This builder.
		 */
		public NewNodeBuilder<T> onCreated(BiConsumer<CommandSender, T> onCreated) {
			this.onCreated = onCreated;
			return this;
		}

		/**
		 * @return The action to perform when the object is created.
		 */
		public BiConsumer<CommandSender, T> onCreated() {
			return onCreated;
		}

		/**
		 * Creates a new {@link NewNode} based on the previous parameter.
		 * 
		 * @param explanation The node explanation.
		 * 
		 * @return A new node that creates new objects of type T.
		 * 
		 * @throws IllegalArgumentException if one parameter is null.
		 */
		public NewNode<T> build(IMinecraftCode explanation) {
			if (onNameIsMissing == null || onValidateName == null || onCreated == null || explanation == null)
				throw new IllegalArgumentException();

			this.explanation = explanation;
			return new NewNode<T>(this);
		}

		/**
		 * @return The node explanation.
		 */
		public IMinecraftCode getExplanation() {
			return explanation;
		}
	}
}
