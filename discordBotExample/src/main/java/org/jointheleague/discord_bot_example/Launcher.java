package org.jointheleague.discord_bot_example;

import java.util.Map;
import java.util.Scanner;

public class Launcher {
	public static void main(String[] args) {
		if (args.length == 0) {
			args = new String[] { "default" };
		}
		new Launcher().launch(args);
	}

	public void launch(String[] args) {
		Map<String, BotInfo> map = Utilities.loadBotsFromJson();
		for (String name : args) {
			BotInfo n = map.get(name);
			new Bot("NTYyNzk5MzE1MTA2Mzk4MjIw.XKQCEA.lYPqydXtQKLLbaJmR2RE0cpnUDM", "oliver-test").connect();
		}
	}
}
