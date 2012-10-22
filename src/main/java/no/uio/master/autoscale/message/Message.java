package no.uio.master.autoscale.message;

import java.io.Serializable;

/**
 * Abstraction for messages sent. <br>
 * All messages should contain the senders ip-address for internal mapping 
 * at the receiver.
 * 
 * @author andreas
 */
public abstract class Message implements Serializable {

	private static final long serialVersionUID = -9156910154465325184L;
	private String senderHost;
	
	public Message() {
		String host = "127.0.0.1";
		//TODO: Remove this later, to retrieve the actual ip-address
//		try {
//			InetAddress ownIp=InetAddress.getLocalHost();
//			host = ownIp.getHostAddress();
//		} catch (UnknownHostException e1) {
//			LOG.debug("Failed to retrieve ip");
//		}
		senderHost = host;
	}
	
	public String getSenderHost() {
		return this.senderHost;
	}

	@Override
	public String toString() {
		return "Message [senderHost=" + senderHost + "]";
	}

}
