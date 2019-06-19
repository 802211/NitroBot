package bot_classes;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import command_classes.AssignRoleMessageListener;
import command_classes.CoinFlipMessageListener;
import command_classes.DadModeListener;
import command_classes.KickMessageListener;
import command_classes.NicknameListener;
import command_classes.PingMessageListener;
import command_classes.PlayRPSMessageListener;
import command_classes.QuitMessageListener;
import command_classes.RollDiceMessageListener;
import command_classes.SolveQuadraticListener;

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
		api.addMessageCreateListener(new DadModeListener(channelName));
		api.addMessageCreateListener(new NicknameListener(channelName));
		api.addMessageCreateListener(new SolveQuadraticListener(channelName));
		api.addMessageCreateListener(new RollDiceMessageListener(channelName));
	}
}
