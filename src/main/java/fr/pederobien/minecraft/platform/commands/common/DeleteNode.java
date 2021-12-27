package fr.pederobien.minecraft.platform.commands.common;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNode;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;

public class DeleteNode extends MinecraftCodeNode {
	private DeleteNodeBuilder builder;

	private DeleteNode(DeleteNodeBuilder builder) {
		super("delete", builder.explanation);
		this.builder = builder;
	}

	/**
	 * Creates a DeleteNodeBuilder. The {@link CommandSender} refers to the entity that run the command.
	 * 
	 * @param onNameIsMissing Action to perform when the name of the file to delete is missing.
	 * 
	 * @return a new instance of a DeleteNodeBuilder.
	 */
	protected static DeleteNodeBuilder builder(Consumer<CommandSender> onNameIsMissing) {
		return new DeleteNodeBuilder(onNameIsMissing);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			builder.onNameIsMissing.accept(sender);
			return false;
		}
		for (String name : args) {
			if (startWithIgnoreCase(name, "default")) {
				send(eventBuilder(sender, ECommonCode.NAME_MUST_NOT_START_WITH_DEFAULT, name));
				return false;
			}

			if (!builder.onDeleteAction.apply(name)) {
				builder.onFailToDelete.accept(sender, name);
				return false;
			}
			builder.onDeleted.accept(sender, name);
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return builder.onTabComplete.onTabComplete(sender, command, alias, args);
	}

	public static class DeleteNodeBuilder {
		private Consumer<CommandSender> onNameIsMissing;
		private TabCompleter onTabComplete;
		private Function<String, Boolean> onDeleteAction;
		private BiConsumer<CommandSender, String> onFailToDelete, onDeleted;
		private IMinecraftCode explanation;

		/**
		 * Creates a DeleteNodeBuilder. The {@link CommandSender} refers to the entity that run the command.
		 * 
		 * @param onNameIsMissing Action to perform when the name of the file to delete is missing.
		 */
		private DeleteNodeBuilder(Consumer<CommandSender> onNameIsMissing) {
			this.onNameIsMissing = onNameIsMissing;
		}

		/**
		 * @return The action to perform when the name is missing while deleting a file.
		 */
		public Consumer<CommandSender> getOnNameIsMissing() {
			return onNameIsMissing;
		}

		/**
		 * Set the action to perform for the completion.
		 * 
		 * @param onTabComplete The action for argument completion.
		 * 
		 * @return This builder.
		 */
		public DeleteNodeBuilder onTabComplete(TabCompleter onTabComplete) {
			this.onTabComplete = onTabComplete;
			return this;
		}

		/**
		 * @return The action for argument completion.
		 */
		public TabCompleter getOnTabComplete() {
			return onTabComplete;
		}

		/**
		 * Set the action to perform in order to delete a file on the server. The first <code>String</code> parameter refers to the file
		 * name to delete, the second <code>Boolean</code> parameters refers to the success of the deletion.
		 * 
		 * @param onDeleteAction The action to perform in order to delete a file.
		 * 
		 * @return This builder.
		 */
		public DeleteNodeBuilder onDeleteAction(Function<String, Boolean> onDeleteAction) {
			this.onDeleteAction = onDeleteAction;
			return this;
		}

		/**
		 * @return The action to perform in order to delete a file.
		 */
		public Function<String, Boolean> getOnDeleteAction() {
			return onDeleteAction;
		}

		/**
		 * Set the action to perform when the deletion fails. The {@link CommandSender} refers to the entity that run the command, the
		 * <code>String</code> parameter refers to the file name to delete.
		 * 
		 * @param onFailTodelete The action to perform when the deletion fails.
		 * 
		 * @return This builder.
		 */
		public DeleteNodeBuilder onFailToDelete(BiConsumer<CommandSender, String> onFailToDelete) {
			this.onFailToDelete = onFailToDelete;
			return this;
		}

		/**
		 * @return The action to perform when the deletion fails.
		 */
		public BiConsumer<CommandSender, String> getOnFailToDelete() {
			return onFailToDelete;
		}

		/**
		 * Set the action to perform when a file is deleted. The {@link CommandSender} refers to the entity that run the command, the
		 * <code>String</code> parameter refers to the deleted file name.
		 * 
		 * @param onDeleted The action to perform.
		 * 
		 * @return This builder.
		 */
		public DeleteNodeBuilder onDeleted(BiConsumer<CommandSender, String> onDeleted) {
			this.onDeleted = onDeleted;
			return this;
		}

		/**
		 * @return The action to perform when a file has been deleted.
		 */
		public BiConsumer<CommandSender, String> getOnDeleted() {
			return onDeleted;
		}

		/**
		 * Creates a new {@link LoadNode} based on the previous parameter.
		 * 
		 * @param explanation The node explanation.
		 * 
		 * @return A new node that deletes files on the server.
		 * 
		 * @throws IllegalArgumentException if one parameter is null.
		 */
		public DeleteNode build(IMinecraftCode explanation) {
			if (onNameIsMissing == null || onTabComplete == null || onDeleteAction == null || onFailToDelete == null || onDeleted == null || explanation == null)
				throw new IllegalArgumentException();

			this.explanation = explanation;
			return new DeleteNode(this);
		}

		/**
		 * @return The node explanation.
		 */
		public IMinecraftCode getExplanation() {
			return explanation;
		}
	}
}
