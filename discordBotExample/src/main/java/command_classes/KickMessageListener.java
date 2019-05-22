package command_classes;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;

import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

public class KickMessageListener extends CustomMessageCreateListener {

	private static final String COMMAND = "!kick";
	private static boolean inPlay = false;
	private static String n = "";

	public KickMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) {
		if(!inPlay) {
			if (event.getMessageContent().equalsIgnoreCase(COMMAND)) {
				inPlay = true;
				n = event.getMessageAuthor().getDisplayName();
				event.getChannel().sendMessage("Enter the discriminated name of the user you want kicked");
			}
		}
		else if(inPlay) {
			if(event.getMessageAuthor().getDisplayName().equals(n)) {
				System.out.println(event.getMessageContent());		
				inPlay = false;
				n = "";
				String k = event.getMessageContent();
				User u = event.getServer().get().getMemberByDiscriminatedName(k).get();
				if(u == null) {
					System.out.println("No User");	
				} else {
					System.out.println("User Found");	
				}
				CompletableFuture<Void> cf =	event.getServer().get().kickUser(u);
				while(!cf.isDone()) {
					System.out.println("waiting...");
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						
					}
				}
				System.out.println("Done kicking: " + cf);
			}
		}
	}
}
