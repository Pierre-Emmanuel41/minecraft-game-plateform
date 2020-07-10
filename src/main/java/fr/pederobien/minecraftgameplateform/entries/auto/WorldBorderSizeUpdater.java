package fr.pederobien.minecraftgameplateform.entries.auto;

import fr.pederobien.minecraftgameplateform.border.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.entries.simple.WorldBorderSizeEntry;
import fr.pederobien.minecraftscoreboards.interfaces.IObjective;

public class WorldBorderSizeUpdater extends BorderConfigurationEntryUpdater<WorldBorderSizeEntry> {

	/**
	 * Create an entry updater. This entry is responsible to update the source entry.
	 * 
	 * @param objective The objective associated to the source entry.
	 * @param source    The source tracked by this updater.
	 */
	public WorldBorderSizeUpdater(IObjective objective, WorldBorderSizeEntry source) {
		super(objective, source);
	}

	/**
	 * Create an entry updater. This entry is responsible to update the source entry.
	 * 
	 * @param objective       The objective associated to the source entry.
	 * @param score           The line number of this entry in the player objective.
	 * @param configuration   The configuration used to get informations to display.
	 * @param pattern         A string used to format the world border size.
	 * @param displayHalfSize True to display the radius, false to display the diameter.
	 */
	public WorldBorderSizeUpdater(IObjective objective, int score, IBorderConfiguration configuration, String pattern, boolean displayHalfSize) {
		this(objective, new WorldBorderSizeEntry(score, configuration, pattern).setDisplayHalfSize(displayHalfSize));
	}

	/**
	 * Create an entry updater. This entry is responsible to update the source entry.
	 * 
	 * @param objective     The objective associated to the source entry.
	 * @param score         The line number of this entry in the player objective.
	 * @param configuration The configuration used to get informations to display.
	 * @param pattern       A string used to format the world border size.
	 */
	public WorldBorderSizeUpdater(IObjective objective, int score, IBorderConfiguration configuration, String pattern) {
		this(objective, score, configuration, pattern, false);
	}
}
