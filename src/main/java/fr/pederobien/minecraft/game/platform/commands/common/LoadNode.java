package fr.pederobien.minecraft.game.platform.commands.common;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNode;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;

public class LoadNode extends MinecraftCodeNode {
	private LoadNodeBuilder builder;

	private LoadNode(LoadNodeBuilder builder) {
		super(ECommonLabel.LOAD.getLabel(), builder.explanation, () -> true);
		this.builder = builder;
	}

	/**
	 * Creates a LoadNodeBuilder in order to deserialize file contents. The {@link CommandSender} refers to the entity that run the
	 * command.
	 * 
	 * @param onNameIsMissing Action to perform when the name of the file to load is missing.
	 * 
	 * @return A new instance of a LoadNodeBuilder.
	 */
	protected static LoadNodeBuilder builder(Consumer<CommandSender> onNameIsMissing) {
		return new LoadNodeBuilder(onNameIsMissing);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String name = "";
		try {
			name = args[0];
		} catch (IndexOutOfBoundsException e) {
			builder.onNameIsMissing.accept(sender);
			return false;
		}

		if (builder.onLoadAction.apply(name)) {
			builder.onLoaded.accept(sender, name);
			return true;
		}

		send(eventBuilder(sender, ECommonCode.FILE_DOES_NOT_EXIST, name));
		builder.onFailToLoad.accept(sender, name);
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return builder.onTabComplete.onTabComplete(sender, command, alias, args);

	}

	public static class LoadNodeBuilder {
		private Consumer<CommandSender> onNameIsMissing;
		private TabCompleter onTabComplete;
		private Function<String, Boolean> onLoadAction;
		private BiConsumer<CommandSender, String> onFailToLoad, onLoaded;
		private IMinecraftCode explanation;

		/**
		 * Creates a LoadNodeBuilder based on the given tree. The {@link CommandSender} refers to the entity that run the command.
		 * 
		 * @param onNameIsMissing Action to perform when the name of the file to load is missing.
		 */
		private LoadNodeBuilder(Consumer<CommandSender> onNameIsMissing) {
			this.onNameIsMissing = onNameIsMissing;
		}

		/**
		 * @return The action to perform when the name is missing while loading a file.
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
		public LoadNodeBuilder onTabComplete(TabCompleter onTabComplete) {
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
		 * Set the action to perform in order to deserialize the content of a file. The first <code>String</code> parameter refers to the
		 * file name to deserialize, the second <code>Boolean</code> parameters refers to the success of the deserialization.
		 * 
		 * @param onLoadAction The action to perform in order to deserialize a file.
		 * 
		 * @return This builder.
		 */
		public LoadNodeBuilder onLoadAction(Function<String, Boolean> onLoadAction) {
			this.onLoadAction = onLoadAction;
			return this;
		}

		/**
		 * @return The action to perform in order to deserialize a file.
		 */
		public Function<String, Boolean> getOnLoadAction() {
			return onLoadAction;
		}

		/**
		 * Set the action to perform when the deserialization fails. The {@link CommandSender} refers to the entity that run the command,
		 * the <code>String</code> parameter refers to the file name to deserialize.
		 * 
		 * @param onFailToLoad The action to perform when the deserialization fails.
		 * 
		 * @return This builder.
		 */
		public LoadNodeBuilder onFailToLoad(BiConsumer<CommandSender, String> onFailToLoad) {
			this.onFailToLoad = onFailToLoad;
			return this;
		}

		/**
		 * @return The action to perform when the deserialization fails.
		 */
		public BiConsumer<CommandSender, String> getOnFailToLoad() {
			return onFailToLoad;
		}

		/**
		 * Set the action to perform when a file is loaded. The {@link CommandSender} refers to the entity that run the command, the
		 * <code>String</code> parameter refers to the loaded file name.
		 * 
		 * @param onLoaded The action to perform.
		 * 
		 * @return This builder.
		 */
		public LoadNodeBuilder onLoaded(BiConsumer<CommandSender, String> onLoaded) {
			this.onLoaded = onLoaded;
			return this;
		}

		/**
		 * @return The action to perform when a file has been deserialized.
		 */
		public BiConsumer<CommandSender, String> getOnLoaded() {
			return onLoaded;
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
		public LoadNode build(IMinecraftCode explanation) {
			if (onNameIsMissing == null || onTabComplete == null || onLoadAction == null || onFailToLoad == null || onLoaded == null || explanation == null)
				throw new IllegalArgumentException();

			this.explanation = explanation;
			return new LoadNode(this);
		}

		/**
		 * @return The node explanation.
		 */
		public IMinecraftCode getExplanation() {
			return explanation;
		}
	}
}
