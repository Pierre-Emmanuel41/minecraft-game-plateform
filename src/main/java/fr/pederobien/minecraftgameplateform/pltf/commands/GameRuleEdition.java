package fr.pederobien.minecraftgameplateform.pltf.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.impl.editions.AbstractMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameRule;
import fr.pederobien.minecraftgameplateform.pltf.IPlateformConfiguration;

public class GameRuleEdition<T> extends AbstractMapPersistenceEdition<IPlateformConfiguration> {
	private IGameRule<T> rule;

	protected GameRuleEdition(IGameRule<T> rule) {
		super(rule.getName(), rule.getExplanation());
		this.rule = rule;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return rule.getExecutor() == null ? true : rule.getExecutor().onCommand(sender, command, label, args);
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return rule.getCompleter() == null ? emptyList() : rule.getCompleter().onTabComplete(sender, command, alias, args);
	}
}
