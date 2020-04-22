package fr.pederobien.minecraftgameplateform.commands.common;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public abstract class CommonCurrent<T extends IUnmodifiableNominable> extends AbstractLabelEdition<T> {
	private IMessageCode currentCode;

	protected CommonCurrent(IMessageCode explanation, IMessageCode currentCode) {
		super(ECommonLabel.CURRENT, explanation);
		this.currentCode = currentCode;
	}

	@Override
	public final boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sendMessageToSender(sender, currentCode, get().toString());
		return true;
	}
}
