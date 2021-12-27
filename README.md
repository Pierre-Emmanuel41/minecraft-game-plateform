# Presentation

This project can be used by minecraft developers in order to use three different commands : startgame, stopgame and pausegame. But first, those commands can be used only by operators on the server and second, they can be used if and only if there are plugins compatible with this plugin registered on the server. Using this plugin alone is useless.

# Download

First you need to download this project on your computer. To do so, you can use the following command line :

```git
git clone https://github.com/Pierre-Emmanuel41/minecraft-game-plateform.git --recursive
```

and then double click on the deploy.bat file. This will deploy this project and all its dependencies on your computer. Which means it generates the folder associated to this project and its dependencies in your .m2 folder. Once this has been done, you can add the project as maven dependency on your maven project :

```xml
<dependency>
	<groupId>fr.pederobien.minecraft</groupId>
	<artifactId>platform</artifactId>
	<version>1.0_MC_1.13.2-SNAPSHOT</version>
</dependency>
```
You can now use features provided by this API in you project.
