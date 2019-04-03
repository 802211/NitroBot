package org.jointheleague.modules;

import java.util.Random;

import org.javacord.api.event.message.MessageCreateEvent;

public class CoinFlipMessageListener extends CustomMessageCreateListener {

	private static final String COMMAND = "!coinflip";
	private static final String HEADS = "You got Heads!";
	private static final String TAILS = "You got Tails!";

	public CoinFlipMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) {
		if (event.getMessageContent().equalsIgnoreCase(COMMAND)) {
			Random r = new Random();
			int f = r.nextInt(100);
			if(f % 2 == 0) {
				event.getChannel().sendMessage(HEADS);
			} else {
				event.getChannel().sendMessage(TAILS);
			}
		}
	}
}
