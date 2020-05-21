package fr.pederobien.minecraftgameplateform.interfaces.commands;

import java.util.List;
import java.util.Optional;

import fr.pederobien.minecraftgameplateform.exceptions.CommandAlreadyRegisteredException;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public interface ICommandHelper {

	/**
	 * Register this command in order to be executed by this plugin.
	 * 
	 * @param command The command to register.
	 * 
	 * @throws CommandAlreadyRegisteredException If a command is already registered for the given command label.
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
	 * @return The list of all registered commands.
	 */
	public List<IParentCommand<IUnmodifiableNominable>> getCommands();
}
