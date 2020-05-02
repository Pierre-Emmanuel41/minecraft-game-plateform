package fr.pederobien.minecraftgameplateform.impl.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Consumer;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.utils.EColor;
import fr.pederobien.minecraftmanagers.TeamManager;

public class PlateformTeam extends AbstractNominable implements ITeam {
	private EColor color;
	private List<Player> players;
	private boolean isCopy;
	private Team serverTeam;

	private PlateformTeam(String name, EColor color, boolean isCopy) {
		super(name);

		players = new ArrayList<Player>();

		setColor(color);
		this.isCopy = isCopy;
	}

	/**
	 * Create a team with the give name and the specified color. The color cannot be null.
	 * 
	 * @param name  The name of the team.
	 * @param color The color of the team.
	 * 
	 * @return The created team.
	 */
	public static ITeam of(String name, EColor color) {
		return new PlateformTeam(name, color, false);
	}

	/**
	 * Create a team with the given name, its color is {@link EColor#RESET}.
	 * 
	 * @param name The name of the team.
	 * 
	 * @return The created team.
	 * 
	 * @see #of(String, EColor)
	 */
	public static ITeam of(String name) {
		return of(name, EColor.RESET);
	}

	@Override
	public String getColoredName() {
		return getColor().getInColor(getName());
	}

	@Override
	public EColor getColor() {
		return color;
	}

	@Override
	public List<Player> getPlayers() {
		return Collections.unmodifiableList(players);
	}

	@Override
	public Optional<Team> getServerTeam() {
		return TeamManager.getTeam(getName());
	}

	@Override
	public boolean isCreatedOnServer() {
		Optional<Team> optTeam = getServerTeam();
		if (optTeam.isPresent()) {
			serverTeam = optTeam.get();
			return true;
		}
		return false;
	}

	@Override
	public void setColor(EColor color) {
		Objects.requireNonNull(color, "The color is null");
		this.color = color;
		synchronizeWithServerTeam(serverTeam -> serverTeam.setColor(color.getChatColor()));
	}

	@Override
	public void addPlayer(Player player) {
		players.add(player);
		synchronizeWithServerTeam(serverTeam -> serverTeam.addEntry(player.getName()));
	}

	@Override
	public void removePlayer(Player player) {
		players.remove(player);
		synchronizeWithServerTeam(serverTeam -> serverTeam.removeEntry(player.getName()));
	}

	@Override
	public void clear() {
		for (Player player : players)
			synchronizeWithServerTeam(serverTeam -> serverTeam.removeEntry(player.getName()));
		players.clear();
	}

	@Override
	public ITeam clone() {
		ITeam team = new PlateformTeam(getName(), getColor(), true);
		for (Player player : getPlayers())
			team.addPlayer(player);
		return team;
	}

	@Override
	public String toString() {
		StringJoiner players = new StringJoiner(" ", "[", "]");
		for (Player player : getPlayers())
			players.add(player.getName());
		return getColor().getInColor(getName() + " " + players.toString());
	}

	private void synchronizeWithServerTeam(Consumer<Team> consumer) {
		if (isCreatedOnServer() && !isCopy)
			consumer.accept(serverTeam);
	}
}
