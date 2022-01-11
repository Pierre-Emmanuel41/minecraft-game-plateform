package fr.pederobien.minecraft.platform.commands.common;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.game.commands.ListNode;
import fr.pederobien.minecraft.game.commands.ListNode.ListNodeBuilder;
import fr.pederobien.minecraft.game.interfaces.IGame;
import fr.pederobien.minecraft.platform.commands.common.DeleteNode.DeleteNodeBuilder;
import fr.pederobien.minecraft.platform.commands.common.DetailsNode.DetailsNodeBuilder;
import fr.pederobien.minecraft.platform.commands.common.LoadNode.LoadNodeBuilder;
import fr.pederobien.minecraft.platform.commands.common.NewNode.NewNodeBuilder;
import fr.pederobien.minecraft.platform.commands.common.RenameNode.RenameNodeBuilder;
import fr.pederobien.minecraft.platform.commands.common.SaveNode.SaveNodeBuilder;
import fr.pederobien.minecraft.platform.interfaces.INominable;

public class NodeBuilderFactory {

	/**
	 * Creates a DetailsNodeBuilder based on the given element. The {@link CommandSender} refers to the entity that run the command,
	 * the <code>T</code> parameter refers to type of element whose details should be displayed.
	 * 
	 * @param element   The element used to display its details.
	 * @param onDetails Action to perform when displaying the details of the underlying object.
	 * 
	 * @return A new instance of a DetailsNodeBuilder.
	 */
	public static <T> DetailsNodeBuilder<T> detailsNode(Supplier<T> element, BiConsumer<CommandSender, T> onDetails) {
		return DetailsNode.builder(element, onDetails);
	}

	/**
	 * Creates a NewNodeBuilder in order to create new objects. The <code>String</code> parameters refers to the name of the created
	 * object, the <code>T</code> parameters refers to the type of the object to create.
	 * 
	 * @param creator The function used to create new objects.
	 * 
	 * @return A new instance of NewNodeBuilder.
	 */
	public static <T> NewNodeBuilder<T> newNode(Function<String, T> creator) {
		return NewNode.builder(creator);
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
	public static RenameNodeBuilder renameNode(Supplier<INominable> element, BiConsumer<CommandSender, String> onNameIsMissing) {
		return RenameNode.builder(element, onNameIsMissing);
	}

	/**
	 * Creates a SaveNodeBuilder in order to serialize an object. The <code>Boolean</code> parameter refers to the succeed of the
	 * serialize action.
	 * 
	 * @param onSerializeAction Set the action to serialize an object.
	 *
	 * @return A new instance of a SaveNodeBuilder.
	 */
	public static SaveNodeBuilder saveNode(Supplier<Boolean> onSerializeAction) {
		return SaveNode.builder(onSerializeAction);
	}

	/**
	 * Creates a LoadNodeBuilder in order to deserialize file contents. The {@link CommandSender} refers to the entity that run the
	 * command.
	 * 
	 * @param onNameIsMissing Action to perform when the name of the file to load is missing.
	 * 
	 * @return A new instance of a LoadNodeBuilder.
	 */
	public static LoadNodeBuilder loadNode(Consumer<CommandSender> onNameIsMissing) {
		return LoadNode.builder(onNameIsMissing);
	}

	/**
	 * Creates a ListNodeBuilder in order to display a specific list. The <code>List&lt;U&gt;</code> parameter refers to the list of
	 * string to display.
	 * 
	 * @param onListRequest Supplier in order to get a list to display.
	 * 
	 * @return A new instance of a ListNodeBuilder.
	 */
	public static <U> ListNodeBuilder<U> listNode(Supplier<List<U>> onListRequest) {
		return ListNode.builder(onListRequest);
	}

	/**
	 * Creates a DeleteNodeBuilder. The {@link CommandSender} refers to the entity that run the command.
	 * 
	 * @param onNameIsMissing Action to perform when the name of the file to delete is missing.
	 * 
	 * @return a new instance of a DeleteNodeBuilder.
	 */
	public static DeleteNodeBuilder deleteNode(Consumer<CommandSender> onNameIsMissing) {
		return DeleteNode.builder(onNameIsMissing);
	}

	/**
	 * Get a node that sets the given game to start with the command "./startgame".
	 * 
	 * @param game The game to start.
	 */
	public static AsCurrentNode asCurrentNode(Supplier<IGame> game) {
		return new AsCurrentNode(game);
	}
}
