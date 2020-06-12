package fr.pederobien.minecraftgameplateform.entries.simple;

import java.text.DecimalFormat;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.entries.PlateformEntry;

public class HealthEntry extends PlateformEntry {
	private DecimalFormat format;

	/**
	 * Create an entry that displays the current player health.
	 * 
	 * @param score   The line number of this entry.
	 * @param pattern A string used to format the player health on screen.
	 */
	public HealthEntry(int score, String pattern) {
		super(score);
		format = new DecimalFormat(pattern);
	}

	@Override
	protected String updateCurrentValue(Player player) {
		return format.format(player.getHealth());
	}
}
