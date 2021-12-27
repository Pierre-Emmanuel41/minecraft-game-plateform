package fr.pederobien.minecraft.platform.commands.common;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNode;
import fr.pederobien.minecraft.game.GamePlugin;
import fr.pederobien.minecraft.game.interfaces.IGame;
import fr.pederobien.minecraft.platform.impl.EPlatformCode;

public class AsCurrentNode extends MinecraftCodeNode {
	private IGame game;

	/**
	 * The game that should be defined as the game to start with the command "startgame".
	 * 
	 * @param game The game to start.
	 */
	protected AsCurrentNode(IGame game) {
		super("ascurrent", EPlatformCode.GAME_CONFIG__AS_CURRENT__EXPLANATION);
		this.game = game;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		GamePlugin.getGameTree().setGame(game);
		send(eventBuilder(sender, EPlatformCode.GAME_CONFIG__AS_CURRENT__GAME_DEFINED, game.getName()));
		return true;
	}
}
