package fr.pederobien.minecraftgameplateform.commands.configurations.teams;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;
import fr.pederobien.minecraftgameplateform.commands.configurations.AbstractGameConfigurationEdition;
import fr.pederobien.minecraftgameplateform.exceptions.ColorNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.PlayerNotFoundException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.interfaces.helpers.IGameConfigurationHelper;
import fr.pederobien.minecraftgameplateform.utils.EColor;
import fr.pederobien.minecraftmanagers.PlayerManager;

public class AbstractTeamConfigurationEdition<T extends IGameConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected AbstractTeamConfigurationEdition(ILabel label, IMessageCode explanation) {
		super(label, explanation);
	}

	/**
	 * Remove players already mentioned from the stream returned by {@link IGameConfigurationHelper#getFreePlayers()}.
	 * 
	 * @param alreadyMentionedPlayers A list that contains already mentioned players.
	 * @return A stream that contains free and not mentioned players.
	 */
	protected Stream<Player> getFreePlayers(List<String> alreadyMentionedPlayers) {
		return getGameConfigurationHelper().getFreePlayers().filter(player -> !alreadyMentionedPlayers.contains(player.getName()));
	}

	/**
	 * Find the player associated to the given name.
	 * 
	 * @param playerName The player's name.
	 * @return The associated player if it exists.
	 * 
	 * @throws PlayerNotFoundException If the name does not correspond to a player.
	 */
	protected Player getPlayer(String playerName) {
		Player player = PlayerManager.getPlayer(playerName);
		if (player == null)
			throw new PlayerNotFoundException(playerName);
		return player;
	}

	/**
	 * Find the colour associated to the given name.
	 * 
	 * @param colorName The colour's name.
	 * @return The associated colour if it exists.
	 * 
	 * @throws ColorNotFoundException If the name does not correspond to a color.
	 */
	protected EColor getColor(String colorName) {
		EColor color = EColor.getByColorName(colorName);
		if (color == null)
			throw new ColorNotFoundException(colorName);
		return color;
	}

	/**
	 * Find the player associated to each player's name in the <code>playerNames</code> and concatenate the name.
	 * 
	 * @param playerNames An array that contains player's name to concatenate.
	 * @param delimiter   the sequence of characters to be used between each element added to the concatenation value.
	 * @param players     A list used to add player associated to the name in the <code>PlayerNames</code>
	 * @return The concatenation of each player's name.
	 * 
	 * @see #getPlayer(String)
	 * @see StringJoiner
	 */
	protected String getPlayerNamesConcatenated(String[] playerNames, CharSequence delimiter, List<Player> players) {
		StringJoiner joiner = new StringJoiner(delimiter);
		for (String playerName : playerNames) {
			Player player = getPlayer(playerName);
			players.add(player);
			joiner.add(player.getName());
		}
		return joiner.toString();
	}

	/**
	 * Remove teams already mentioned from the list returned by {@link IGameConfiguration#getTeams()}.
	 * 
	 * @param alreadyMentionedTeams A list that contains already mentioned teams.
	 * @return A stream that contains not mentioned teams.
	 */
	protected Stream<ITeam> getFreeTeams(List<String> alreadyMentionedTeams) {
		return get().getTeams().stream().filter(team -> !alreadyMentionedTeams.contains(team.getName()));
	}
}
