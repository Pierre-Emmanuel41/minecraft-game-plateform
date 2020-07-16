package fr.pederobien.minecraftgameplateform.gamerules;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.impl.element.AbstractNominable;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameRule;
import fr.pederobien.minecraftgameplateform.interfaces.element.IRunnableGameRule;

public abstract class GameRule<T> extends AbstractNominable implements IGameRule<T> {
	/**
	 * A list that contains all runnable rules
	 */
	public static final List<IRunnableGameRule<?>> RUNNABLE_RULES = new ArrayList<IRunnableGameRule<?>>();

	/**
	 * Game rule to enable/deactivate the display of player team mates location.
	 */
	public static final IRunnableGameRule<Boolean> DISPLAY_CURRENT_TEAMMATE_LOCATION = new DisplayCurrentTeammatesLocation();

	/**
	 * Game rule to enable/deactivate the pvp in the overworld, nether and end.
	 */
	public static final IGameRule<Boolean> PVP = new Pvp();

	private T value, defaultValue;
	private Class<T> type;
	private TabCompleter completer;
	private CommandExecutor executor;
	private IMinecraftMessageCode explanation;

	protected GameRule(String name, T defaultValue, Class<T> type, IMinecraftMessageCode explanation) {
		super(name);
		this.defaultValue = defaultValue;
		this.type = type;
	}

	@Override
	public T getValue() {
		return value == null ? defaultValue : value;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public T getDefaultValue() {
		return defaultValue;
	}

	@Override
	public Class<T> getType() {
		return type;
	}

	@Override
	public IMinecraftMessageCode getExplanation() {
		return explanation;
	}

	@Override
	public TabCompleter getCompleter() {
		return completer;
	}

	@Override
	public CommandExecutor getExecutor() {
		return executor;
	}

	/**
	 * @param completer The completer that propose completions for this command.
	 */
	protected void setCompleter(TabCompleter completer) {
		this.completer = completer;
	}

	/**
	 * @param executor The executor that execute some code.
	 */
	protected void setExecutor(CommandExecutor executor) {
		this.executor = executor;
	}

	static {
		RUNNABLE_RULES.add(DISPLAY_CURRENT_TEAMMATE_LOCATION);
	}
}
