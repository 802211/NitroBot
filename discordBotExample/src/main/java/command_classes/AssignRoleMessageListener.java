package command_classes;

import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

public class AssignRoleMessageListener extends CustomMessageCreateListener{
	
	private static final String COMMAND = "!addrole";
	
	public AssignRoleMessageListener(String channelName) {
		super(channelName);	
	}

	public void handle(MessageCreateEvent event) {
		String username;
		User user;
		String roleName;
		Role role;
		Server server;
		
		if(event.getMessageContent().equalsIgnoreCase(COMMAND)) {
			event.getChannel().sendMessage("Who would you like to receive a role?");
			
		} else {
			server = event.getServer().orElse(null);
			if(server ==  null) {
				System.out.println("no server");
				return;
			}
			
			username = event.getMessageContent();
			user = server.getMemberByDiscriminatedName(username).orElse(null);
			if(user == null) {
				System.out.println("no user");
				return;
			}
			
			event.getChannel().sendMessage("What role would you like to give them?");
			roleName = event.getMessageContent();
			role = server.getRoleById(roleName).get();
			event.getServer().get().addRoleToUser(user, role);
		}
		
		
	}

}
