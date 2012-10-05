package no.uio.master.autoslave.model;

import java.io.Serializable;

public class SlaveMessage implements Serializable {
	private static final long serialVersionUID = 382125954042009372L;

	private String message;
	
	public SlaveMessage() {
		
	}

	public SlaveMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SlaveMessage [message=" + message + "]";
	}

	
}
