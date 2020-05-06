package fr.pederobien.minecraftgameplateform.border.persistence;

import fr.pederobien.minecraftgameplateform.impl.element.persistence.AbstractDefaultContent;

public class DefaultBorderContent extends AbstractDefaultContent {

	public DefaultBorderContent() {
		super("DefaultBorder");
	}

	@Override
	public String getDefaultContent() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<border>\r\n"
				+ "  <version>1.0</version>\r\n"
				+ "  <name>DefaultBorder</name>\r\n"
				+ "  <world>world</world>\r\n"
				+ "  <center x=\"0\" z=\"0\"/>\r\n"
				+ "  <initialdiameter>2000</initialdiameter>\r\n"
				+ "  <finaldiameter>30</finaldiameter>\r\n"
				+ "  <borderspeed>1.0</borderspeed>\r\n"
				+ "</border>";
	}
}
