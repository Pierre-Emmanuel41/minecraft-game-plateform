package fr.pederobien.minecraft.platform.commands;

import java.util.function.Supplier;

import fr.pederobien.minecraft.platform.commands.common.NodeBuilderFactory;
import fr.pederobien.minecraft.platform.interfaces.IPvpTimeConfigurable;

public class PlatformNodeFactory extends NodeBuilderFactory {

	/**
	 * Creates a node in order to modify the PVP time for a pvp time configurable.
	 * 
	 * @param pvpTime The configuration that contains a PVP time parameter.
	 * 
	 * @return A node that modify the PVP time value.
	 */
	public static PvpTimeNode pvpTimeNode(Supplier<IPvpTimeConfigurable> pvpTime) {
		return new PvpTimeNode(() -> pvpTime.get());
	}
}
