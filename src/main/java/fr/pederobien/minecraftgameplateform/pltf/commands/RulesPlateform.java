package fr.pederobien.minecraftgameplateform.pltf.commands;

import fr.pederobien.minecraftgameplateform.dictionary.EPlateformMessageCode;
import fr.pederobien.minecraftgameplateform.helpers.GameRuleHelper;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameRule;
import fr.pederobien.minecraftgameplateform.interfaces.observer.IObsGameRuleHelper;
import fr.pederobien.minecraftgameplateform.pltf.IPlateformConfiguration;

public class RulesPlateform extends AbstractLabelEdition<IPlateformConfiguration> implements IObsGameRuleHelper {

	protected RulesPlateform() {
		super(EPlateformLabel.RULES, EPlateformMessageCode.RULES__EXPLANATION);
		((GameRuleHelper) GameRuleHelper.getInstance()).addObserver(this);
	}

	@Override
	public void onGameRuleAdded(IGameRule<?> rule) {
		addEdition(new GameRuleEdition<>(rule));
	}

	@Override
	public void onGameRuleRemoved(IGameRule<?> rule) {
		removeEdition(new GameRuleEdition<>(rule));
	}
}
