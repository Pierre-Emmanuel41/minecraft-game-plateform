package fr.pederobien.minecraftgameplateform.helpers;

import java.time.LocalTime;
import java.util.StringJoiner;

import org.bukkit.block.Block;

public class DisplayHelper {

	/**
	 * Method used to display the given time to minecraft player.
	 * 
	 * @param time The time to display.
	 * 
	 * @return time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
	 */
	public static String toString(LocalTime time) {
		return join(time.getHour() + "h", time.getMinute() + "m", time.getSecond() + "s");
	}

	/**
	 * Protected method used to display the given block to minecraft player.
	 * 
	 * @param block The block to display.
	 * 
	 * @return "X=" + block.getX() + " Y=" + block.getY() + " Z=" + block.getZ();
	 */
	public static String toString(Block block) {
		return join("X=" + block.getX(), "Y=" + block.getY(), "Z=" + block.getZ());
	}

	private static String join(String... toJoin) {
		return join(" ", toJoin);
	}

	private static String join(CharSequence delimiter, String... toJoin) {
		StringJoiner joiner = new StringJoiner(" ");
		for (String join : toJoin)
			joiner.add(join);
		return joiner.toString();
	}
}
