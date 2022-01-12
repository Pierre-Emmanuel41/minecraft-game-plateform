# Presentation

This project can be used by minecraft developers in order to use three different commands : startgame, stopgame and pausegame. But first, those commands can be used only by operators on the server and second, they can be used if and only if there are plugins compatible with this plugin registered on the server. Using this plugin alone is useless.

# Download

First you need to download this project on your computer. But according to the Minecraft API version there is on the server, you should download this project by specifying the branch associated to the associated version if supported. To do so, you can use the following command line :

```git
git clone -b 1.0_MC_1.13.2-SNAPSHOT https://github.com/Pierre-Emmanuel41/minecraft-game-plateform.git --recursive
```

and then double click on the deploy.bat file. This will deploy this project and all its dependencies on your computer. Which means it generates the folder associated to this project and its dependencies in your .m2 folder. Once this has been done, you can add the project as maven dependency on your maven project :

```xml
<dependency>
	<groupId>fr.pederobien.minecraft</groupId>
	<artifactId>game</artifactId>
	<version>1.0_MC_1.13.2-SNAPSHOT</version>
	<scope<provided</scope>
</dependency>
<dependency>
	<groupId>fr.pederobien.minecraft</groupId>
	<artifactId>platform</artifactId>
	<version>1.0_MC_1.13.2-SNAPSHOT</version>
	<scope<provided</scope>
</dependency>
```

This plugins depends on the minecraft-game plugin, that is why it should be present in the server plugins folder. Moreover, like the minecraft-game plugin this plugin should also be present on the minecraft server in order to be used by several other plugins. That is why it is declared as <code>provided</code> for the dependency scope.

To see the functionalities provided by this plugin, please have a look to [this presentation](https://github.com/Pierre-Emmanuel41/minecraft-game-plateform/blob/master/Presentation.md)
