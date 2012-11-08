package no.uio.master.autoscale.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Bundle for all messages sent through the system.
 * @author andreas
 */
public class MessageBundle implements Serializable {
	private static final long serialVersionUID = -1082075693898433083L;
	
	private List<AbstractMessage> messages;
	
	public MessageBundle() {
		this.messages = new ArrayList<AbstractMessage>();
	}
	
	public void addMessage(AbstractMessage message) {
		this.messages.add(message);
	}
	
	public List<AbstractMessage> getMessages() {
		return this.messages;
	}
	
	public int getMessageCount() {
		return this.messages.size();
	}
	
	public List<AbstractMessage> getMessagesFrom(String host) {
		List<AbstractMessage> hostMessages = new ArrayList<AbstractMessage>();
		
		for(AbstractMessage msg : messages) {
			if(host.equals(msg.getSenderHost())) {
				hostMessages.add(msg);
			}
		}
		
		return hostMessages;
	}

	@Override
	public String toString() {
		return "MessageBundle consiting of " + messages.size() + " message(s).";
	}
}
