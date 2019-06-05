package command_classes;

import org.javacord.api.event.message.MessageCreateEvent;

public class DadModeListener extends CustomMessageCreateListener{
	int stage = 0;
	
	public DadModeListener(String channelName) {
		super(channelName);
		// TODO Auto-generated constructor stub
	}
	
	public void handle(MessageCreateEvent event) {
		if (event.getMessageContent().equalsIgnoreCase("!dadon")) {
			stage++;
			event.getChannel().sendMessage("Activating Dad Mode!");
		} else if (event.getMessageContent().equalsIgnoreCase("!dadoff")) {
			stage = 0;
			event.getChannel().sendMessage("Deactiviting dad mode... Goodbye Dad!");
		}
		
		while (stage == 1) {
			String msg = event.getMessageContent();
			int index = -1;
			String[] strarr = {"im", "Im", "iM", "IM", "i\'m", "i\'M", "I\'m", "I\'M"};
			for (int i = 0; i < strarr.length; i++) {
				if(msg.contains(strarr[i])) {
					String adj = event.getMessageContent().substring(index).trim();
					System.out.println(adj);
				}
			}
			
		}
	}

}
