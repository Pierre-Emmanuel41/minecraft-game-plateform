package fr.pederobien.minecraftgameplateform.interfaces.commands;

public interface ICommandHelper {

	/**
	 * Register this command in order to be executed by this plugin.
	 * 
	 * @param command The command to register.
	 */
	public void register(ICommand command);

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
