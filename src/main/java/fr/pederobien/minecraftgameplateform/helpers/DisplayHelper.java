package fr.pederobien.minecraftgameplateform.helpers;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.StringJoiner;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class DisplayHelper {
	private static DecimalFormat decimalFormat = new DecimalFormat();

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
	 * Method used to display the given block to minecraft player.
	 * 
	 * @param block The block to display.
	 * 
	 * @return "X=" + block.getX() + " Y=" + block.getY() + " Z=" + block.getZ();
	 */
	public static String toString(Block block) {
		return join("X=" + block.getX(), "Y=" + block.getY(), "Z=" + block.getZ());
	}

	/**
	 * Method used to display the given location to minecraft player.
	 * 
	 * @param location The location to display.
	 * @param full     If should display pitch an yaw.
	 * @return "X=" + location.getX() + " Y=" + location.getY() + " Z=" + location.getZ() + " Pitch=" + location.getPitch() + " Yaw="
	 *         + location.getYaw();
	 */
	public static String toString(Location location, boolean full) {
		StringJoiner joiner = new StringJoiner(" ");
		join(joiner, "X=" + location.getX(), "Y=" + location.getY(), "Z=" + location.getZ());
		if (full)
			join(joiner, "Pitch=" + location.getPitch(), "Yaw=" + location.getYaw());
		return joiner.toString();
	}

	/**
	 * Format the given number using the pattern "#.##".
	 * 
	 * @param number The number to format.
	 * @return The formatted number.
	 * 
	 * @see #format(String, double)
	 */
	public static String format(double number) {
		return format("#.##", number);
	}

	/**
	 * Format the given number using the specified pattern.
	 * 
	 * @param pattern The pattern used to format the number.
	 * @param number  The number to format.
	 * @return The formatted number.
	 * 
	 * @see DecimalFormat#format(double)
	 */
	public static String format(String pattern, double number) {
		decimalFormat.applyPattern(pattern);
		return decimalFormat.format(number);
	}

	private static String join(String... toJoin) {
		return join(new StringJoiner(" "), toJoin);
	}

	private static String join(StringJoiner joiner, String... toJoin) {
		for (String join : toJoin)
			joiner.add(join);
		return joiner.toString();
	}
}
