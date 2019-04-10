package org.jointheleague.discord_bot_example;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.jointheleague.modules.CoinFlipMessageListener;
import org.jointheleague.modules.PingMessageListener;
import org.jointheleague.modules.PlayRPSMessageListener;
import org.jointheleague.modules.QuitMessageListener;

public class Bot {
	private String token;
	private String channelName;
	DiscordApi api;

	public Bot(String token, String channelName) {
		this.token = token;
		this.channelName = channelName;
	}

	public void connect() {
		api = new DiscordApiBuilder().setToken(token).login().join();
		System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
		api.getServerTextChannelsByName(channelName).forEach(e -> e.sendMessage("Hello Friends!"));

		api.addMessageCreateListener(new QuitMessageListener(channelName));
		api.addMessageCreateListener(new PingMessageListener(channelName));
		api.addMessageCreateListener(new PlayRPSMessageListener(channelName));
		api.addMessageCreateListener(new CoinFlipMessageListener(channelName));
	}
}
