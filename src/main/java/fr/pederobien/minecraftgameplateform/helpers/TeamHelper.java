package fr.pederobien.minecraftgameplateform.helpers;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftmanagers.PlayerManager;
import fr.pederobien.minecraftmanagers.TeamManager;
import fr.pederobien.minecraftmanagers.WorldManager;

public class TeamHelper {

	/**
	 * Create the given team on the server. A team with the name, the color and players is created on the server.
	 * 
	 * @param team The team to create on the server.
	 */
	public static Team createTeamOnServer(ITeam team) {
		return TeamManager.createTeam(team.getName(), team.getColor().getChatColor(), team.getPlayers().stream());
	}

	/**
	 * Creates a {@link Team} for each {@link ITeam} present in the given list.
	 * 
	 * @param teams A list that contains all teams to create on the server.
	 * 
	 * @see #createTeamOnServer(ITeam)
	 */
	public static void createTeamsOnServer(List<ITeam> teams) {
		for (ITeam team : teams)
			createTeamOnServer(team);
	}

	/**
	 * Remove the given team from the server.
	 * 
	 * @param team The team to remove.
	 */
	public static void removeTeamFromServer(ITeam team) {
		TeamManager.removeTeam(team.getName());
	}

	/**
	 * Remove each team present in the given stream from the server.
	 * 
	 * @param teams A stream that contains all teams to remove from the server.
	 * 
	 * @see #removeTeamFromServer(ITeam)
	 */
	public static void removeTeamsFromServer(Stream<ITeam> teams) {
		teams.peek(team -> removeTeamFromServer(team));
	}

	/**
	 * Pick a random player from the given stream that verify the given predicate.
	 * 
	 * @param players   A stream of player used as reference to choose randomly a player.
	 * @param predicate A filter for the players' selection.
	 * @return An empty optional if any players from the stream verify the predicate, a not empty optional otherwise.
	 */
	public static Optional<Player> getRandom(Stream<Player> players, Predicate<Player> predicate) {
		return TeamManager.getRandom(players.filter(predicate).collect(Collectors.toList()));
	}

	/**
	 * Teleport each player from the given team at the specified location.
	 * 
	 * @param team     The team to teleport.
	 * @param location The target transport's location.
	 */
	public static void teleportTeam(ITeam team, Location location) {
		PlayerManager.teleportePlayers(team.getPlayers().stream(), location);
	}

	/**
	 * Get a random location from the {@link WorldManager} and teleport each player of the given team at this location.
	 * 
	 * @param team   The team to teleport.
	 * @param world  The world into which players are randomly teleported.
	 * @param center The center used to be sure the random location is inside the area represented by the center and the bound.
	 * @param bound  The bound used to define a random location.
	 * 
	 * @see WorldManager#getRandomlyLocation(org.bukkit.World, int)
	 */
	public static void teleportTeamRandomly(ITeam team, World world, Block center, int bound) {
		teleportTeam(team, WorldManager.getRandomlyLocation(world, center, bound));
	}
}
