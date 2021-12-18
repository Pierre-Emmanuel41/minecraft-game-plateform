package fr.pederobien.minecraft.gameplateform.impl.editions;

import java.time.LocalTime;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.gameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraft.gameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraft.gameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraft.gameplateform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.minecraftdevelopmenttoolkit.exceptions.ArgumentNotFoundException;
import fr.pederobien.minecraftdevelopmenttoolkit.exceptions.NotAvailableArgumentException;
import fr.pederobien.minecraftdevelopmenttoolkit.impl.messagecode.AbstractMessageCodeMapEdition;
import fr.pederobien.minecraftdevelopmenttoolkit.utils.DisplayHelper;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public abstract class AbstractMapPersistenceEdition<T extends IUnmodifiableNominable>
		extends AbstractMessageCodeMapEdition<T, IParentPersistenceEdition<T>, IMapPersistenceEdition<T>> implements IMapPersistenceEdition<T> {

	protected AbstractMapPersistenceEdition(String label, IMinecraftMessageCode explanation) {
		super(label, explanation);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			return super.onCommand(sender, command, label, args);
		} catch (ArgumentNotFoundException e) {
			sendSynchro(sender, ECommonMessageCode.COMMON_ARGUMENT_NOT_FOUND, e.getNotFoundArgument(), e.getLabel());
		} catch (NotAvailableArgumentException e) {
			sendSynchro(sender, ECommonMessageCode.COMMON_NOT_AVAILABLE_ARGUMENT, e.getArgument(), e.getLabel());
		}
		return false;
	}

	@Override
	public final IMapPersistenceEdition<T> setAvailable(boolean available) {
		internalSetAvailable(available);
		return this;
	}

	@Override
	public final IMapPersistenceEdition<T> setModifiable(boolean modifiable) {
		internalSetModifiable(modifiable);
		return this;
	}

	@Override
	public final IMapPersistenceEdition<T> addEdition(IMapPersistenceEdition<T> elt) {
		internalAdd(elt);
		return this;
	}

	@Override
	public final IMapPersistenceEdition<T> removeEdition(IMapPersistenceEdition<T> elt) {
		internalRemove(elt);
		return this;
	}

	/**
	 * Get the persistence coming from the parent of this edition. It is equivalent to call {@link #getParent()} and then
	 * {@link IParentPersistenceEdition#getPersistence()}.
	 * 
	 * @return The persistence used to save/load objects associated to the type <code>T</code>.
	 */
	protected IMinecraftPersistence<T> getPersistence() {
		return getParent().getPersistence();
	}

	/**
	 * Method used to display the given block to minecraft player.
	 * 
	 * @param block The block to display.
	 * 
	 * @return "X=" + block.getX() + " Y=" + block.getY() + " Z=" + block.getZ();
	 */
	protected String toString(Block block) {
		return DisplayHelper.toString(block);
	}

	/**
	 * Method used to display the given time to minecraft player.
	 * 
	 * @param time The time to display.
	 * @param full True if the method show hours, minutes or second even if it equals 0.
	 * 
	 * @return time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
	 */
	protected String toString(LocalTime time, boolean full) {
		return DisplayHelper.toString(time, full);
	}

	/**
	 * Method used to display the given location to minecraft player.
	 * 
	 * @param location The location to display.
	 * @param full     If should display pitch an yaw.
	 * @return "X=" + location.getX() + " Y=" + location.getY() + " Z=" + location.getZ() + " Pitch=" + location.getPitch() + " Yaw="
	 *         + location.getYaw();
	 */
	protected String toString(Location location, boolean full) {
		return DisplayHelper.toString(location, full);
	}
}
