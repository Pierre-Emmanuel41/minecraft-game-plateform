package fr.pederobien.minecraft.gameplateform.interfaces.commands;

import java.util.List;
import java.util.Optional;

import fr.pederobien.minecraft.gameplateform.exceptions.CommandAlreadyRegisteredException;

public interface ICommandHelper {

	/**
	 * Register this command in order to be executed by this plugin.
	 * 
	 * @param command The command to register.
	 * 
	 * @throws CommandAlreadyRegisteredException If a command is already registered for the given command label.
	 */
	public void register(ICommand command);

	/**
	 * Get the command registered for the given label.
	 * 
	 * @param label The command label to get.
	 * @return An optional that contains the command if it exists, an empty optional otherwise.
	 */
	public Optional<ICommand> getCommand(String label);

	/**
	 * @return The list of all registered commands.
	 */
	public List<ICommand> getCommands();
}
