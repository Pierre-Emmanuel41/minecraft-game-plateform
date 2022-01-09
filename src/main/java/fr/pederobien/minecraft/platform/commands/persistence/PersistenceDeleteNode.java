package fr.pederobien.minecraft.platform.commands.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import com.google.common.base.Predicate;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNodeWrapper;
import fr.pederobien.minecraft.commandtree.interfaces.ICodeSender;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.platform.commands.common.DeleteNode;
import fr.pederobien.minecraft.platform.commands.common.DeleteNode.DeleteNodeBuilder;
import fr.pederobien.minecraft.platform.commands.common.NodeBuilderFactory;
import fr.pederobien.minecraft.platform.impl.EPlatformCode;
import fr.pederobien.minecraft.platform.interfaces.INominable;
import fr.pederobien.minecraft.platform.interfaces.IPlatformPersistence;

public class PersistenceDeleteNode extends MinecraftCodeNodeWrapper {

	private PersistenceDeleteNode(DeleteNode node) {
		super(node);
	}

	/**
	 * Creates a PersistenceDeleteNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that
	 * run the command
	 * 
	 * @param persistence     The persistence associated to this node.
	 * @param onNameIsMissing Action to perform when the name of the file to delete is missing.
	 * 
	 * @return A new instance of a DeleteNodeBuilder.
	 */
	protected static PersistenceDeleteNodeBuilder builder(IPlatformPersistence<? extends INominable> persistence, Consumer<CommandSender> onNameIsMissing) {
		return new PersistenceDeleteNodeBuilder(persistence, onNameIsMissing);
	}

	public static class PersistenceDeleteNodeBuilder implements ICodeSender {
		private DeleteNodeBuilder deleteNodeBuilder;

		/**
		 * Creates a PersistenceDeleteNodeBuilder based on the specified persistence. The {@link CommandSender} refers to the entity that
		 * run the command
		 * 
		 * @param persistence     The persistence associated to this node.
		 * @param onNameIsMissing Action to perform when the name of the file to delete is missing.
		 */
		private PersistenceDeleteNodeBuilder(IPlatformPersistence<? extends INominable> persistence, Consumer<CommandSender> onNameIsMissing) {
			deleteNodeBuilder = NodeBuilderFactory.deleteNode(onNameIsMissing);

			// Action for argument completion.
			deleteNodeBuilder.onTabComplete((sender, command, alias, args) -> {
				switch (args.length) {
				case 1:
					List<String> alreadyMentionnedFiles = Arrays.asList(args);
					Predicate<String> filter = name -> !startWithIgnoreCase(name, "default") && !alreadyMentionnedFiles.contains(name);
					return filter(persistence.list().stream().filter(filter), args);
				default:
					return new ArrayList<String>();
				}
			});

			// Action to perform in order to delete a file
			deleteNodeBuilder.onDeleteAction(name -> persistence.delete(name));

			// Action to perform when the deletion fails.
			deleteNodeBuilder.onFailToDelete((sender, name) -> send(eventBuilder(sender, EPlatformCode.FILE_DOES_NOT_EXIST, name)));
		}

		/**
		 * @return The action to perform when the name is missing while deleting a file.
		 */
		public Consumer<CommandSender> getOnNameIsMissing() {
			return deleteNodeBuilder.getOnNameIsMissing();
		}

		/**
		 * @return The action for argument completion.
		 */
		public TabCompleter getOnTabComplete() {
			return deleteNodeBuilder.getOnTabComplete();
		}

		/**
		 * @return The action to perform in order to delete a file.
		 */
		public Function<String, Boolean> getOnDeleteAction() {
			return deleteNodeBuilder.getOnDeleteAction();
		}

		/**
		 * @return The action to perform when the deletion fails.
		 */
		public BiConsumer<CommandSender, String> getOnFailToDelete() {
			return deleteNodeBuilder.getOnFailToDelete();
		}

		/**
		 * Set the action to perform when a file is deleted. The {@link CommandSender} refers to the entity that run the command, the
		 * <code>String</code> parameter refers to the deleted file name.
		 * 
		 * @param onDeleted The action to perform.
		 * 
		 * @return This builder.
		 */
		public PersistenceDeleteNodeBuilder onDeleted(BiConsumer<CommandSender, String> onDeleted) {
			deleteNodeBuilder.onDeleted(onDeleted);
			return this;
		}

		/**
		 * @return The action to perform when a file has been deleted.
		 */
		public BiConsumer<CommandSender, String> getOnDeleted() {
			return deleteNodeBuilder.getOnDeleted();
		}

		/**
		 * Creates a new {@link PersistenceDeleteNode} based on the previous parameter.
		 * 
		 * @param explanation The node explanation.
		 * 
		 * @return A new node that deletes files in the persistence folder.
		 * 
		 * @throws IllegalArgumentException if one parameter is null.
		 */
		public PersistenceDeleteNode build(IMinecraftCode explanation) {
			return new PersistenceDeleteNode(deleteNodeBuilder.build(explanation));
		}

		/**
		 * @return The node explanation.
		 */
		public IMinecraftCode getExplanation() {
			return deleteNodeBuilder.getExplanation();
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

		/**
		 * Filter each string from the given stream using condition : <code>str.contains(args[args.length - 1])</code>. This method is
		 * equivalent to : <code>filter(stream, args[args.length - 1])</code>. In other words, this method filter the given stream using
		 * the last argument from the array <code>args</code>.
		 * 
		 * @param stream A stream that contains string to filter.
		 * @param args   The array that contains arguments coming from method <code>onTabComplete</code>.
		 * 
		 * @return A list of string from the given stream that contains the filter.
		 * 
		 * @see #filter(Stream, String)
		 * @see #onTabComplete(org.bukkit.command.CommandSender, org.bukkit.command.Command, String, String[])
		 */
		protected List<String> filter(Stream<String> stream, String... args) {
			return stream.filter(str -> str.contains(args[args.length - 1])).collect(Collectors.toList());
		}
	}
}
