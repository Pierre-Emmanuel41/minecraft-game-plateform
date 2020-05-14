package fr.pederobien.minecraftgameplateform.commands.common;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public abstract class CommonCurrent<T extends IUnmodifiableNominable> extends AbstractLabelEdition<T> {
	private IMinecraftMessageCode currentCode;

	protected CommonCurrent(IMinecraftMessageCode explanation, IMinecraftMessageCode currentCode) {
		super(ECommonLabel.CURRENT, explanation);
		this.currentCode = currentCode;
	}

	@Override
	public final boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sendMessageToSender(sender, currentCode, get().toString());
		return true;
	}
}
