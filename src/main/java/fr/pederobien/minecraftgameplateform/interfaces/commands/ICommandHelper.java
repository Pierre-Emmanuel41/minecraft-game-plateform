package fr.pederobien.minecraftgameplateform.interfaces.commands;

import java.util.Optional;

import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public interface ICommandHelper {

	/**
	 * Register this command in order to be executed by this plugin.
	 * 
	 * @param command The command to register.
	 */
	public <T extends IUnmodifiableNominable> void register(IParentCommand<T> command);

	/**
	 * Get the command registered for the given label.
	 * 
	 * @param label The command label to get.
	 * @return An optional that contains the command if it exists, an empty optional otherwise.
	 */
	public <T extends IUnmodifiableNominable> Optional<IParentCommand<T>> getCommand(String label);

	/**
	 * Set the availability of each registered commands.
	 * 
	 * @param available True if all commands are available, false if all commands are not available.
	 */
	public void setAllAvailable(boolean available);

	/**
	 * Set the availability of the command associated to the given label.
	 * 
	 * @param label       The label of the command to modify.
	 * @param isAvailable The new value that represent the availability of this command.
	 * 
	 * @return True if the command has been found, false otherwise.
	 */
	public boolean setAvailable(String label, boolean available);
}
