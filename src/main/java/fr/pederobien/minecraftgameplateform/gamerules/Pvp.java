package fr.pederobien.minecraftgameplateform.gamerules;

import fr.pederobien.minecraftgameplateform.dictionary.EGameRuleMessageCode;
import fr.pederobien.minecraftmanagers.WorldManager;

public class Pvp extends GameRule<Boolean> {

	protected Pvp() {
		super("pvp", true, Boolean.class, EGameRuleMessageCode.PVP);
	}

	@Override
	public void setValue(Boolean value) {
		super.setValue(value);
		WorldManager.OVERWORLD.setPVP(value);
		WorldManager.NETHER_WORLD.setPVP(value);
		WorldManager.END_WORLD.setPVP(value);
	}
}
