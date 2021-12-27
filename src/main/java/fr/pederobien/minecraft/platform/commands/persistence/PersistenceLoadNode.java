package fr.pederobien.minecraft.platform.commands.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNodeWrapper;
import fr.pederobien.minecraft.commandtree.interfaces.ICodeSender;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.platform.commands.common.ECommonCode;
import fr.pederobien.minecraft.platform.commands.common.LoadNode;
import fr.pederobien.minecraft.platform.commands.common.NodeBuilderFactory;
import fr.pederobien.minecraft.platform.commands.common.LoadNode.LoadNodeBuilder;
import fr.pederobien.minecraft.platform.interfaces.INominable;
import fr.pederobien.minecraft.platform.interfaces.IPlatformPersistence;

public class PersistenceLoadNode extends MinecraftCodeNodeWrapper {

	private PersistenceLoadNode(LoadNode node) {
		super(node);
	}

	/**
	 * Creates a PersistenceLoadNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that
	 * run the command.
	 * 
	 * @param persistence     The persistence associated to this node.
	 * @param onNameIsMissing Action to perform when the name of the file to load is missing.
	 * 
	 * @return A new instance of a PersistenceLoadNodeBuilder.
	 */
	protected static <U extends INominable> PersistenceLoadNodeBuilder<U> builder(IPlatformPersistence<U> persistence, Consumer<CommandSender> onNameIsMissing) {
		return new PersistenceLoadNodeBuilder<U>(persistence, onNameIsMissing);
	}

	public static class PersistenceLoadNodeBuilder<T extends INominable> implements ICodeSender {
		private IPlatformPersistence<T> persistence;
		private LoadNodeBuilder loadNodeBuilder;

		/**
		 * Creates a PersistenceLoadNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that
		 * run the command.
		 * 
		 * @param persistence     The persistence associated to this node.
		 * @param onNameIsMissing Action to perform when the name of the file to load is missing.
		 */
		private PersistenceLoadNodeBuilder(IPlatformPersistence<T> persistence, Consumer<CommandSender> onNameIsMissing) {
			this.persistence = persistence;

			loadNodeBuilder = NodeBuilderFactory.loadNode(onNameIsMissing);

			// Action for argument completion.
			loadNodeBuilder.onTabComplete((sender, command, alias, args) -> {
				switch (args.length) {
				case 1:
					return filter(persistence.list().stream(), args[0]);
				default:
					return new ArrayList<String>();
				}
			});

			// Action to perform in order to deserialize the content of a file.
			loadNodeBuilder.onLoadAction(name -> {
				persistence.serialize();
				return persistence.deserialize(name);
			});

			// Action to perform when the deserialization fails.
			loadNodeBuilder.onFailToLoad((sender, name) -> send(eventBuilder(sender, ECommonCode.FILE_DOES_NOT_EXIST, name)));
		}

		/**
		 * @return The action to perform when the name is missing while loading a file.
		 */
		public Consumer<CommandSender> getOnNameIsMissing() {
			return loadNodeBuilder.getOnNameIsMissing();
		}

		/**
		 * @return The action for argument completion.
		 */
		public TabCompleter getOnTabComplete() {
			return loadNodeBuilder.getOnTabComplete();
		}

		/**
		 * @return The action to perform in order to deserialize a file.
		 */
		public Function<String, Boolean> getOnLoadAction() {
			return loadNodeBuilder.getOnLoadAction();
		}

		/**
		 * @return The action to perform when the deserialization fails.
		 */
		public BiConsumer<CommandSender, String> getOnFailToLoad() {
			return loadNodeBuilder.getOnFailToLoad();
		}

		/**
		 * Set the action to perform when a file is loaded. The {@link CommandSender} refers to the entity that run the command, the
		 * <code>String</code> parameter refers to the loaded file name.
		 * 
		 * @param onLoaded The action to perform.
		 * 
		 * @return This builder.
		 */
		public PersistenceLoadNodeBuilder<T> onLoaded(BiConsumer<CommandSender, T> onLoaded) {
			loadNodeBuilder.onLoaded((sender, name) -> onLoaded.accept(sender, persistence.get()));
			return this;
		}

		/**
		 * @return The action to perform when a file has been deserialized.
		 */
		public BiConsumer<CommandSender, String> getOnLoaded() {
			return loadNodeBuilder.getOnLoaded();
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
		public PersistenceLoadNode build(IMinecraftCode explanation) {
			return new PersistenceLoadNode(loadNodeBuilder.build(explanation));
		}

		/**
		 * @return The node explanation.
		 */
		public IMinecraftCode getExplanation() {
			return loadNodeBuilder.getExplanation();
		}

		/**
		 * Filter each string from the given stream using condition : <code>str.contains(filter)</code>
		 * 
		 * @param stream A stream that contains string to filter.
		 * @param filter The condition used to filter the previous stream.
		 * 
		 * @return A list of string from the given stream that contains the filter.
		 */
		protected List<String> filter(Stream<String> stream, String filter) {
			return stream.filter(str -> str.contains(filter)).collect(Collectors.toList());
		}
	}
}
