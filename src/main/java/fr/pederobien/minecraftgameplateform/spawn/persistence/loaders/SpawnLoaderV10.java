package fr.pederobien.minecraftgameplateform.spawn.persistence.loaders;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.pederobien.minecraftgameplateform.impl.element.WorldBlock;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldBlock;
import fr.pederobien.minecraftgameplateform.spawn.persistence.SpawnXmlTag;
import fr.pederobien.persistence.interfaces.xml.IXmlPersistenceLoader;

public class SpawnLoaderV10 extends AbstractSpawnLoader {

	public SpawnLoaderV10() {
		super(1.0);
	}

	@Override
	public IXmlPersistenceLoader<ISpawn> load(Element root) {
		createNewElement();

		// Getting the spawn's name
		Node name = getElementsByTagName(root, SpawnXmlTag.NAME).item(0);
		get().setName(name.getChildNodes().item(0).getNodeValue());

		// Getting the spawn's world
		Node world = getElementsByTagName(root, SpawnXmlTag.WORLD).item(0);
		get().setWorld(world.getChildNodes().item(0).getNodeValue());

		// Getting the dimensions of the spawn
		Element dimensions = (Element) getElementsByTagName(root, SpawnXmlTag.DIMENSIONS).item(0);
		get().setWidth(getIntAttribute(dimensions, SpawnXmlTag.WIDTH));
		get().setHeight(getIntAttribute(dimensions, SpawnXmlTag.HEIGHT));
		get().setDepth(getIntAttribute(dimensions, SpawnXmlTag.DEPTH));

		// Getting the spawn's center
		Element center = (Element) getElementsByTagName(root, SpawnXmlTag.CENTER).item(0);
		get().setCenter(getXCoordinates(center), getYCoordinates(center), getZCoordinates(center));

		// Getting the spawn's player spawn
		Element playerSpawn = (Element) getElementsByTagName(root, SpawnXmlTag.PLAYER_SPAWN).item(0);
		get().setRelativePlayerSpawn(getXCoordinates(playerSpawn), getYCoordinates(playerSpawn), getZCoordinates(playerSpawn));

		// Getting the allow mobs under spawn
		Element allowMobsUnderSpawn = (Element) getElementsByTagName(root, SpawnXmlTag.ALLOW_MOBS_UNDER_SPAWN).item(0);
		get().setAllowMobsUnderSpawn(getBooleanNodeValue(allowMobsUnderSpawn.getChildNodes().item(0)));

		// Getting spawn's blocks
		NodeList blocks = getElementsByTagName(root, SpawnXmlTag.BLOCK);
		List<IWorldBlock> spawnBlocks = new ArrayList<IWorldBlock>();
		for (int i = 0; i < blocks.getLength(); i++) {
			Element block = (Element) blocks.item(i);
			spawnBlocks.add(new WorldBlock(getXCoordinates(block), getYCoordinates(block), getZCoordinates(block), getStringAttribute(block, SpawnXmlTag.BLOCK_DATA)));
		}
		get().setBlocks(spawnBlocks);
		return this;
	}
}
