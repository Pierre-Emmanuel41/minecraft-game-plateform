package fr.pederobien.minecraftgameplateform.gamerules;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IRunnableGameRule;

public abstract class RunnableGameRule<T> extends GameRule<T> implements IRunnableGameRule<T> {
	private long period;
	private boolean isRunning;

	protected RunnableGameRule(String name, T defaultValue, Class<T> type, IMinecraftMessageCode explanation) {
		super(name, defaultValue, type, explanation);
	}

	@Override
	public long getPeriod() {
		return period;
	}

	@Override
	public void setPeriod(long period) {
		if (isRunning && this.period != period) {
			this.period = period;
			stop();
			start();
		}
	}

	@Override
	public boolean isRunning() {
		return isRunning;
	}

	protected void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
}
