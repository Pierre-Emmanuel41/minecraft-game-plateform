package fr.pederobien.minecraft.game.platform.commands;

import java.util.function.Supplier;

import fr.pederobien.minecraft.commandtree.impl.MinecraftCodeNode;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.game.platform.interfaces.IConfigurable;

public class ConfigurableNode<T> extends MinecraftCodeNode {
	private IConfigurable<T> configurable;

	/**
	 * Create a configurable node in order to change the value of a configurable parameter.
	 * 
	 * @param configurable the configurable value to modify.
	 * @param label        The name of the node.
	 * @param explanation  The explanation of the node.
	 * @param isAvailable  True if this node is available, false otherwise.
	 */
	protected ConfigurableNode(String label, IMinecraftCode explanation, Supplier<Boolean> isAvailable, IConfigurable<T> configurable) {
		super(label, explanation, isAvailable);
		this.configurable = configurable;
	}

	/**
	 * Create a minecraft node defined by a label, which correspond to its name, and an explanation.
	 * 
	 * @param configurable the configurable value to modify.
	 * @param label        The name of the node.
	 * @param explanation  The explanation of the node.
	 */
	protected ConfigurableNode(String label, IMinecraftCode explanation, IConfigurable<T> configurable) {
		super(label, explanation);
	}

	/**
	 * @return The configurable value managed by this node.
	 */
	public IConfigurable<T> getConfigurable() {
		return configurable;
	}
}
