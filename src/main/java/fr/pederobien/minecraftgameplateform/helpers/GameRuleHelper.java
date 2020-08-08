package fr.pederobien.minecraftgameplateform.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import fr.pederobien.minecraftgameplateform.interfaces.element.IGameRule;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameRuleHelper;

public class GameRuleHelper implements IGameRuleHelper {
	private Map<String, IGameRule<?>> rules;

	private GameRuleHelper() {
		rules = new HashMap<String, IGameRule<?>>();
	}

	public static IGameRuleHelper getInstance() {
		return SingletonHolder.HELPER;
	}

	private static class SingletonHolder {
		public static final IGameRuleHelper HELPER = new GameRuleHelper();
	}

	@Override
	public <T> void register(IGameRule<T> rule) {
		rules.put(rule.getName(), rule);
	}

	@Override
	public boolean unregister(String ruleName) {
		return rules.remove(ruleName) != null;
	}

	@Override
	public List<IGameRule<?>> getRules() {
		return Collections.unmodifiableList(new ArrayList<>(rules.values()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Optional<IGameRule<T>> getRule(String ruleName) {
		return Optional.ofNullable((IGameRule<T>) rules.get(ruleName));
	}
}
