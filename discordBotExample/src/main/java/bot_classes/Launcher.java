 package bot_classes;

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
		//Map<String, BotInfo> map = Utilities.loadBotsFromJson();
		for (String name : args) {
			//BotInfo n = map.get(name); 
			new Bot("NjExMDA2MDc0ODU3OTc5OTA0.XWXMPA.13bp8y5phOk6SAAn9un9YYFFKRM", "testing-chloe").connect();	
		}
	}
}
