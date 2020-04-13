package fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.EWorldStructureMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldStructure;

public abstract class CommonDimension<T extends IWorldStructure> extends AbstractWorldStructureEdition<T> {

	public CommonDimension(IMessageCode explanation) {
		super(EWorldStructureLabel.DIMENSION, explanation);
	}

	/**
	 * Method called when the dimension of the world structure have been correctly defined.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The name of the structure.
	 * @param width  The width of the structure (X).
	 * @param height The height of the structure (Y).
	 * @param depth  The depth of the structure (Z).
	 */
	protected abstract void onDimensionDefined(CommandSender sender, String name, int width, int height, int depth);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			String width = args[0], height = args[1], depth = args[2];
			get().setWidth(getInt(width));
			get().setHeight(getInt(height));
			get().setDepth(getInt(depth));
			onDimensionDefined(sender, get().getName(), get().getWidth(), get().getHeight(), get().getDepth());
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, EWorldStructureMessageCode.COMMON_DIMENSION__MISSING_DIMENSION);
		} catch (NumberFormatException e) {
			sendMessageToSender(sender, EWorldStructureMessageCode.COMMON_DIMENSION__BAD_DIMENSION_FORMAT);
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return check(args[0], e -> isNotStrictInt(e), Arrays.asList("<X> <Y> <Z>"));
		case 2:
			return check(args[1], e -> isNotStrictInt(e), check(args[0], e -> isStrictInt(e), Arrays.asList("<Y> <Z>")));
		case 3:
			return check(args[2], e -> isNotStrictInt(e), check(args[1], e -> isStrictInt(e), Arrays.asList("<Z>")));
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
