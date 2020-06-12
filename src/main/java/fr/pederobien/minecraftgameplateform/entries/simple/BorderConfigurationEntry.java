package fr.pederobien.minecraftgameplateform.entries.simple;

import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;
import fr.pederobien.minecraftscoreboards.impl.AbstractSimpleEntry;

public abstract class BorderConfigurationEntry extends AbstractSimpleEntry {
	private IBorderConfiguration configuration;

	protected BorderConfigurationEntry(int score, IBorderConfiguration configuration) {
		super(score);
		this.configuration = configuration;
	}

	/**
	 * @return The border configuration associated to this entry.
	 */
	public IBorderConfiguration getConfiguration() {
		return configuration;
	}
}
