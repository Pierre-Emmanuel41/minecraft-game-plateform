package fr.pederobien.minecraft.game.platform.utils;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class TabCompleterFactory {

	public static TabCompleter trueFalseCompleter() {
		return new Completer("true", "false");
	}

	private static class Completer implements TabCompleter {
		private List<String> completion;

		public Completer(String... args) {
			completion = Arrays.asList(args);
		}

		@Override
		public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			return completion;
		}
	}
}
