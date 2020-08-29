package fr.pederobien.minecraftgameplateform.gamerules;

import java.util.Optional;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.EGameRuleMessageCode;
import fr.pederobien.minecraftgameplateform.helpers.TeamHelper;
import fr.pederobien.minecraftgameplateform.utils.TabCompleterFactory;

public class RevivePlayerNearTeamMateGameRule extends EventRunnableGameRule<Boolean> {

	public RevivePlayerNearTeamMateGameRule() {
		super("revivePlayerNearTeamMate", false, Boolean.class, EGameRuleMessageCode.REVIVE_NEAR_TEAM_MATE__EXPLANATION);
		setCompleter(TabCompleterFactory.trueFalseCompleter());
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		if (!isRunning() || !getValue())
			return;

		Optional<Player> optPlayer = TeamHelper.getRandomColleagues(event.getPlayer(), player -> player.getGameMode().equals(GameMode.SURVIVAL));
		if (optPlayer.isPresent())
			event.setRespawnLocation(optPlayer.get().getLocation());
	}

	@Override
	public CommandExecutor getExecutor() {
		return new CommandExecutor() {
			@Override
			public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
				try {
					String value = args[0];
					if (value.equals("true"))
						setValue(true);
					else if (value.equals("false"))
						setValue(false);
					else {
						sendMessageToSender(sender, ECommonMessageCode.COMMON_BAD_BOOLEAN_FORMAT);
						return false;
					}
					sendMessageToSender(sender, EGameRuleMessageCode.COMMON_VALUE_DEFINED_IN_GAME, getName(), value);
				} catch (IndexOutOfBoundsException e) {
					sendMessageToSender(sender, EGameRuleMessageCode.COMMON_VALUE_IS_MISSING, getName());
					return false;
				}
				return true;
			}
		};
	}
}
