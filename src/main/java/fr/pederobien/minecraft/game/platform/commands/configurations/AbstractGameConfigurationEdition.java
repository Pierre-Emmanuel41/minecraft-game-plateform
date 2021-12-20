package fr.pederobien.minecraft.game.platform.commands.configurations;

import java.util.Optional;

import org.bukkit.entity.Player;

import fr.pederobien.minecraft.game.platform.Platform;
import fr.pederobien.minecraft.game.platform.exceptions.ColorNotFoundException;
import fr.pederobien.minecraft.game.platform.exceptions.PlayerNotFoundException;
import fr.pederobien.minecraft.game.platform.exceptions.configurations.TeamNotFoundException;
import fr.pederobien.minecraft.game.platform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.game.platform.interfaces.element.ILabel;
import fr.pederobien.minecraft.game.platform.interfaces.element.ITeam;
import fr.pederobien.minecraft.game.platform.interfaces.helpers.IGameConfigurationHelper;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftmanagers.EColor;
import fr.pederobien.minecraftmanagers.PlayerManager;

public class AbstractGameConfigurationEdition<T extends IGameConfiguration> extends AbstractLabelEdition<T> {

	protected AbstractGameConfigurationEdition(ILabel label, IMinecraftMessageCode explanation) {
		super(label, explanation);
	}

	/**
	 * @return An helper to simplify manipulation of a game configuration.
	 */
	protected IGameConfigurationHelper getGameConfigurationHelper() {
		return Platform.getOrCreateConfigurationHelper(get());
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
	 * Find the team associated to the given name for this configuration.
	 * 
	 * @param teamName The team's name.
	 * @return The associated team if it exists.
	 * 
	 * @throws TeamNotFoundException If the name does not correspond to a team.
	 */
	protected ITeam getTeam(String teamName) {
		Optional<ITeam> optTeam = get().getTeam(teamName);
		if (!optTeam.isPresent())
			throw new TeamNotFoundException(get(), teamName);
		return optTeam.get();
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
}
