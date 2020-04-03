package fr.pederobien.minecraftgameplateform.impl.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.utils.EColor;

public class PlateformTeam extends AbstractNominable implements ITeam {
	private EColor color;
	private List<Player> players;
	private boolean isCreatedOnServer, isCopy;

	private PlateformTeam(String name, EColor color, boolean isCopy) {
		super(name);

		players = new ArrayList<Player>();
		isCreatedOnServer = false;

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
	public boolean isCreatedOnServer() {
		return isCreatedOnServer;
	}

	@Override
	public void setColor(EColor color) {
		Objects.requireNonNull(color, "The color is null");
		this.color = color;
	}

	@Override
	public void addPlayer(Player player) {
		updatePlayer(player, getColor());
		players.add(player);
	}

	@Override
	public void removePlayer(Player player) {
		updatePlayer(player, EColor.RESET);
		players.remove(player);
	}

	@Override
	public void clear() {
		for (Player player : players)
			updatePlayer(player, EColor.RESET);
		players.clear();
	}

	@Override
	public void setCreatedOnServer(boolean isCreatedOnServer) {
		this.isCreatedOnServer = isCreatedOnServer;
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
		StringBuilder builder = new StringBuilder(getName());
		builder.append(" [");
		for (int i = 0; i < players.size(); i++) {
			builder.append(players.get(i).getName());
			if (i < players.size() - 1)
				builder.append(" ");
		}
		builder.append("]");
		return getColor().getInColor(builder.toString());
	}

	private void updatePlayer(Player player, EColor color) {
		if (isCopy)
			return;
		player.setDisplayName(color.getInColor(player.getName()));
	}
}
