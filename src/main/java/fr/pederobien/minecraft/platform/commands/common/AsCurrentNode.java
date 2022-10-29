package fr.pederobien.minecraft.platform.commands.common;

import java.util.function.Supplier;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNode;
import fr.pederobien.minecraft.game.interfaces.IGame;
import fr.pederobien.minecraft.platform.GamePlatformPlugin;
import fr.pederobien.minecraft.platform.impl.EPlatformCode;

public class AsCurrentNode extends MinecraftCodeNode {
	private Supplier<IGame> game;

	/**
	 * The game that should be defined as the game to start with the command "startgame".
	 * 
	 * @param game The game to start.
	 */
	protected AsCurrentNode(Supplier<IGame> game) {
		super("ascurrent", EPlatformCode.GAME_CONFIG__AS_CURRENT__EXPLANATION, () -> game.get() != null);
		this.game = game;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		GamePlatformPlugin.getGameTree().setGame(game.get());
		sendSuccessful(sender, EPlatformCode.GAME_CONFIG__AS_CURRENT__GAME_DEFINED, game.get().getName());
		return true;
	}
}
