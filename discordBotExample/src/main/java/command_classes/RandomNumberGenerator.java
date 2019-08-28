package command_classes;

import java.util.Random;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class RandomNumberGenerator implements MessageCreateListener {
	
	private static final String COMMAND = "!GenerateRandNum";

	public RandomNumberGenerator(String channelName) {
		
	}
	
	public void onMessageCreate(MessageCreateEvent event) {
		// TODO Auto-generated method stub
		if (event.getMessageContent().equalsIgnoreCase(COMMAND)) {
			int x = new Random().nextInt();
			event.getChannel().sendMessage(x + "");
		}
	}
}
