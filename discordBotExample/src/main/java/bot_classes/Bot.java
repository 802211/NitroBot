package bot_classes;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import command_classes.AssignRoleMessageListener;
import command_classes.CoinFlipMessageListener;
import command_classes.DadMode;
import command_classes.KickMessageListener;
import command_classes.PingMessageListener;
import command_classes.PlayRPSMessageListener;
import command_classes.QuitMessageListener;

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
		api.getServerTextChannelsByName(channelName).forEach(e -> e.sendMessage("Nitro On!"));

		api.addMessageCreateListener(new QuitMessageListener(channelName));
		api.addMessageCreateListener(new PingMessageListener(channelName));	
		api.addMessageCreateListener(new CoinFlipMessageListener(channelName));
		api.addMessageCreateListener(new PlayRPSMessageListener(channelName));
		api.addMessageCreateListener(new KickMessageListener(channelName));
		api.addMessageCreateListener(new AssignRoleMessageListener(channelName));
		api.addMessageCreateListener(new DadMode(channelName));
	}
}
