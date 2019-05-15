package command_classes;

import org.javacord.api.event.message.MessageCreateEvent;

public class AssignRoleMessageListener {
	
	private static final String COMMAND = "!addrole";

	public void handle(MessageCreateEvent event) {
		if(event.getMessageContent().equalsIgnoreCase(COMMAND)) {
			event.getChannel().sendMessage("Who would you like to receive a role?");
		}
	
	}

}
