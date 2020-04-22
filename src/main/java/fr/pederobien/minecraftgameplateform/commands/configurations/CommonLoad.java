package fr.pederobien.minecraftgameplateform.commands.configurations;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.StringJoiner;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.EGameConfigurationMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;

public abstract class CommonLoad<T extends IGameConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected CommonLoad(IMessageCode explanation) {
		super(EGameConfigurationLabel.LOAD, explanation);
	}

	/**
	 * Method called when a style has been successfully loaded.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The loaded game configuration's name.
	 */
	protected abstract void onStyleLoaded(CommandSender sender, String name);

	/**
	 * Method called When any name has been furnished to load a game configuration.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 */
	protected abstract void onNameIsMissing(CommandSender sender);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String name = "";
		try {
			name = args[0];
			getPersistence().save();
			getPersistence().load(name);
			onStyleLoaded(sender, name);
		} catch (IndexOutOfBoundsException e) {
			onNameIsMissing(sender);
			return false;
		} catch (FileNotFoundException e) {
			sendMessageToSender(sender, EGameConfigurationMessageCode.COMMON_LOAD__CONFIGURATION_DOES_NOT_EXIST, name);
			return false;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(getPersistence().list().stream(), args[0]);
		return super.onTabComplete(sender, command, alias, args);
	}

	/**
	 * Get a concatenation of each team's name for this configuration. Each team's name is coloured.
	 * 
	 * @return A string that concatenate each team's name.
	 */
	protected String getTeamNamesWithColor() {
		StringJoiner joiner = new StringJoiner(" ");
		for (ITeam team : get().getTeams())
			joiner.add(team.getColoredName());
		return joiner.toString();
	}
}
