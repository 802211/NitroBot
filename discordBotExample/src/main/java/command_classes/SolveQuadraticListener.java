package command_classes;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

public class SolveQuadraticListener extends CustomMessageCreateListener {

	private static final String COMMAND = "!solvequad";
	private static int stage = 0;
	private static String n = "";
	private User user;
	private static double a = 0;
	private static double b = 0;
	private static double c = 0;
	

	public SolveQuadraticListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) {
		if(stage == 0) {
			if (event.getMessageContent().equalsIgnoreCase(COMMAND)) {
				stage = 1;
				n = event.getMessageAuthor().getDisplayName();
				event.getChannel().sendMessage("Enter the 'A' Value");
			}
		}
		else if(stage == 1) {
			if(event.getMessageAuthor().getDisplayName().equals(n)) {
				stage = 2;
				a = Double.parseDouble(event.getMessageContent());
				event.getChannel().sendMessage("Enter the 'B' Value");
			}
		}
		else if(stage == 2) {
			if(event.getMessageAuthor().getDisplayName().equals(n)) {
				stage = 3;
				b = Double.parseDouble(event.getMessageContent());
				event.getChannel().sendMessage("Enter the 'C' Value");
			}
		}
		else if(stage == 3) {
			if(event.getMessageAuthor().getDisplayName().equals(n)) {
				stage = 0;
				c = Double.parseDouble(event.getMessageContent());
				double a1 = ((-b) + Math.sqrt(Math.pow(b, 2.0) - (4*a*c))/(2*a));
				event.getChannel().sendMessage("" + a1);
			}
		}
	}
}
