package no.uio.master.autoscale.slave.message;

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
	private String senderIp;
	
	public Message() {
		String ip = "127.0.0.1";
		//TODO: Remove this later, to retrieve the actual ip-address
//		try {
//			InetAddress ownIp=InetAddress.getLocalHost();
//			ip = ownIp.getHostAddress();
//		} catch (UnknownHostException e1) {
//			LOG.debug("Failed to retrieve ip");
//		}
		senderIp = ip;
	}
	
	public String getSenderIp() {
		return this.senderIp;
	}

	@Override
	public String toString() {
		return "Message [senderIp=" + senderIp + "]";
	}

}
