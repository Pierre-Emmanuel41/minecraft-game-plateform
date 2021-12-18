package fr.pederobien.minecraft.gameplateform.commands;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraft.gameplateform.interfaces.commands.IParentCommand;
import fr.pederobien.minecraft.gameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraft.gameplateform.utils.Plateform;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public abstract class AbstractParentCommand<T extends IUnmodifiableNominable> extends AbstractTabExecutorCommand<IParentPersistenceEdition<T>>
		implements IParentCommand<T> {

	protected AbstractParentCommand(JavaPlugin plugin, IParentPersistenceEdition<T> parent, boolean registerPresistence) {
		super(plugin, parent.getLabel(), parent);
		if (registerPresistence)
			Plateform.getPersistenceCenter().registerOrUpdate(parent.getPersistence());
	}

	protected AbstractParentCommand(JavaPlugin plugin, IParentPersistenceEdition<T> parent) {
		this(plugin, parent, true);
	}

	@Override
	public IParentPersistenceEdition<T> getParent() {
		return super.getParent();
	}
}
