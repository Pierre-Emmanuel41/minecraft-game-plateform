package fr.pederobien.minecraft.platform.commands.common;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNode;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.game.impl.EGameCode;
import fr.pederobien.minecraft.platform.interfaces.INominable;
import fr.pederobien.utils.consumers.Consumer3;

public class RenameNode extends MinecraftCodeNode {
	private RenameNodeBuilder builder;

	private RenameNode(RenameNodeBuilder builder) {
		super("renamed", builder.explanation);
		this.builder = builder;
	}

	/**
	 * Creates a RenameNodeBuilder based on the given element. The {@link CommandSender} refers to the entity that run the command,
	 * the <code>String</code> parameter refers to the current object name.
	 * 
	 * @param element         The element to rename.
	 * @param onNameIsMissing Action to perform when the new name is missing while renaming the object.
	 * 
	 * @return A new instance of a RenameNodeBuilder.
	 */
	protected static RenameNodeBuilder builder(INominable element, BiConsumer<CommandSender, String> onNameIsMissing) {
		return new RenameNodeBuilder(element, onNameIsMissing);
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

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String newName;
		try {
			newName = args[0];
		} catch (IndexOutOfBoundsException e) {
			builder.onNameIsMissing.accept(sender, builder.element.getName());
			return false;
		}

		// Validate or invalidate the new name.
		if (!builder.onValidateName.apply(sender, newName))
			return false;

		// Keep the old name in memory
		String oldName = builder.element.getName();
		builder.element.setName(newName);
		builder.onRenamed.accept(sender, oldName, newName);
		return true;
	}

	public static class RenameNodeBuilder {
		private INominable element;
		private BiConsumer<CommandSender, String> onNameIsMissing;
		private BiFunction<CommandSender, String, Boolean> onValidateName;
		private Consumer3<CommandSender, String, String> onRenamed;
		private IMinecraftCode explanation;

		/**
		 * Creates a RenameNodeBuilder based on the given element. The {@link CommandSender} refers to the entity that run the command,
		 * the <code>String</code> parameter refers to the current object name.
		 * 
		 * @param element         The element to rename.
		 * @param onNameIsMissing Action to perform when the new name is missing while renaming the object.
		 */
		private RenameNodeBuilder(INominable element, BiConsumer<CommandSender, String> onNameIsMissing) {
			this.element = element;
			this.onNameIsMissing = onNameIsMissing;
		}

		/**
		 * @return The action to perform when the name is missing while renaming the underlying object.
		 */
		public BiConsumer<CommandSender, String> getOnNameIsMissing() {
			return onNameIsMissing;
		}

		/**
		 * Set the action validate or invalidate the new object name. The {@link CommandSender} refers to the entity that run the command,
		 * the <code>String</code> parameter refers to the new object name and the last <code>Boolean</code> returns true to validate the
		 * new name, false otherwise.
		 * 
		 * @param onValidateName The action to perform.
		 * 
		 * @return This builder.
		 */
		public RenameNodeBuilder onValidateName(BiFunction<CommandSender, String, Boolean> onValidateName) {
			this.onValidateName = onValidateName;
			return this;
		}

		/**
		 * @return The action to perform in order to validate or invalidate the new object name.
		 */
		public BiFunction<CommandSender, String, Boolean> getOnValidateName() {
			return onValidateName;
		}

		/**
		 * Set the action to perform when the object has been renamed. The {@link CommandSender} refers to the entity that run the
		 * command, the second <code>String</code> parameter refers to the current object name and the last <code>String</code> parameter
		 * refers to the new object name.
		 * 
		 * @param onDeleted The action to perform.
		 * 
		 * @return This builder.
		 */
		public RenameNodeBuilder onRenamed(Consumer3<CommandSender, String, String> onRenamed) {
			this.onRenamed = onRenamed;
			return this;
		}

		/**
		 * @return The action to perform when the object has been renamed.
		 */
		public Consumer3<CommandSender, String, String> getOnRenamed() {
			return onRenamed;
		}

		/**
		 * Creates a new {@link RenameNode} based on the previous parameter.
		 * 
		 * @param explanation The node explanation.
		 * 
		 * @return A new node that rename the underlying object.
		 * 
		 * @throws IllegalArgumentException if one parameter is null.
		 */
		public RenameNode build(IMinecraftCode explanation) {
			if (onNameIsMissing == null || onValidateName == null || onRenamed == null || explanation == null)
				throw new IllegalArgumentException();

			this.explanation = explanation;
			return new RenameNode(this);
		}

		/**
		 * @return The node explanation.
		 */
		public IMinecraftCode getExplanation() {
			return explanation;
		}
	}
}
