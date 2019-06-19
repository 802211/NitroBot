package command_classes;

import org.javacord.api.event.message.MessageCreateEvent;

public class DadModeListener extends CustomMessageCreateListener{
	boolean isRunning = false;
	
	public DadModeListener(String channelName) {
		super(channelName);
		// TODO Auto-generated constructor stub
	}
	
	public void handle(MessageCreateEvent event) {
		if(event.getMessageAuthor().getDisplayName().equals("Nitro")) {
			return;
		}
		
		System.out.println(event.getMessageAuthor());
		if (event.getMessageContent().equalsIgnoreCase("!dadon")) {
			isRunning = true;
			event.getChannel().sendMessage("Activating Dad Mode!");
		} else if (event.getMessageContent().equalsIgnoreCase("!dadoff")) {	
			isRunning = false;
			event.getChannel().sendMessage("Deactiviting dad mode... Goodbye Dad!");
		}
		
		if (isRunning == true) {
			String msg = event.getMessageContent();
			int index = -1;
			String[] strarr = {"im", "Im", "iM", "IM", "i\'m", "i\'M", "I\'m", "I\'M", "I am"};
			for (int i = 0; i < strarr.length; i++) {
				index = msg.indexOf(strarr[i]);
				if(index >= 0) {
					String adj = event.getMessageContent().substring(index + strarr[i].length() + 1).trim();
					event.getChannel().sendMessage("Hi " + adj + ", I'm dad!");
					
				} else {
					System.out.println("bad");
				}
			}
			
		}
	}

}
