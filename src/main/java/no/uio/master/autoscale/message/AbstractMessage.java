package no.uio.master.autoscale.message;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstraction for messages sent. <br>
 * All messages should contain the senders ip address for internal mapping, and the senders ip 
 * address should be read after fetching the object at the receiver-side, since the ip address 
 * provided by the InetAddress interface may be an internal address behind a router, e.g., 
 * 192.168.0.10, and therefore not directly accessible. 
 * 
 * @author andreas
 */
public abstract class AbstractMessage implements Serializable {

	private static final long serialVersionUID = -9156910154465325184L;
	private String senderHost;
	
	public AbstractMessage() {
	}
	
	/**
	 * Set sender-host addres / ip address.<br>
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
