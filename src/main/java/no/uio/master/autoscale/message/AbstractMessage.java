package no.uio.master.autoscale.message;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstraction for messages sent. <br>
 * All messages should contain the senders ip-address for internal mapping 
 * at the receiver.
 * 
 * @author andreas
 */
public abstract class AbstractMessage implements Serializable {
	private static Logger LOG = LoggerFactory.getLogger(AbstractMessage.class);

	private static final long serialVersionUID = -9156910154465325184L;
	private String senderHost;
	
	public AbstractMessage() {
		String host = "127.0.0.1";

		try {
			InetAddress ownIp=InetAddress.getLocalHost();
			host = ownIp.getHostAddress();
		} catch (UnknownHostException e1) {
			LOG.debug("Failed to retrieve ip");
		}
		
		senderHost = host;
	}
	
	/**
	 * Constructor handles this automatically.<br>
	 * Should only be used for testing purposes!
	 * @param host
	 */
	public void setSenderHost(String host) {
		this.senderHost = host;
	}
	
	public String getSenderHost() {
		return this.senderHost;
	}

	@Override
	public String toString() {
		return "Message [senderHost=" + senderHost + "]";
	}

}
