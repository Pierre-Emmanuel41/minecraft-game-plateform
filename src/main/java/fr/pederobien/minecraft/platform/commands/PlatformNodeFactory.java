package fr.pederobien.minecraft.platform.commands;

import fr.pederobien.minecraft.platform.commands.common.NodeBuilderFactory;
import fr.pederobien.minecraft.platform.interfaces.IPvpTimeConfigurable;

public class PlatformNodeFactory extends NodeBuilderFactory {

	/**
	 * Creates a node in order to modify the PVP time for this configuration.
	 * 
	 * @param configuration The configuration that contains a PVP time parameter.
	 * 
	 * @return A node that modify the PVP time value.
	 */
	public PvpTimeNode pvpTimeNode(IPvpTimeConfigurable configuration) {
		return new PvpTimeNode(configuration);
	}
}
