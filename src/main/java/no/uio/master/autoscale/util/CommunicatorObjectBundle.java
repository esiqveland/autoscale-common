package no.uio.master.autoscale.util;

public class CommunicatorObjectBundle {

	private Object message;
	private String senderIp;
	
	public CommunicatorObjectBundle() {
		
	}
	
	public CommunicatorObjectBundle(Object message, String senderIp) {
		super();
		this.message = message;
		this.senderIp = senderIp;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public String getSenderIp() {
		return senderIp;
	}

	public void setSenderIp(String senderIp) {
		this.senderIp = senderIp;
	}

	@Override
	public String toString() {
		return "CommunicatorObjectBundle [message=" + message + ", senderIp=" + senderIp + "]";
	}
	
}
