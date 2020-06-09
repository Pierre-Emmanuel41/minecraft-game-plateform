package fr.pederobien.minecraftgameplateform.entry.simple;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftdevelopmenttoolkit.utils.DisplayHelper;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;

public class TotalTimeEntry extends TimeTaskEntry {

	/**
	 * Create an entry. This entry displays the time elapsed from the beginning of the game.
	 * 
	 * @param score The line number of this entry in the player objective.
	 */
	public TotalTimeEntry(int score) {
		super(score);
	}

	@Override
	protected String updateCurrentValue(Player player) {
		return DisplayHelper.toString(getTask().getTotalTime(), false);
	}

	@Override
	protected IMinecraftMessageCode getBeforeAsCode(Player player) {
		return EGameMessageCode.GAME_TIME;
	}
}
