package no.uio.master.autoscale.message;

import java.io.Serializable;
import java.util.HashMap;

import no.uio.master.autoscale.message.enumerator.AgentMessageType;


public class AgentMessage extends AbstractMessage implements Serializable {
	private static final long serialVersionUID = 382125954042009372L;

	
	private AgentMessageType type;
	private HashMap<String, Object> map;
	
	public AgentMessage() {
		super();
		type = AgentMessageType.STARTUP_NODE;
		map = new HashMap<String, Object>();
	}
	
	public AgentMessage(AgentMessageType type) {
		super();
		this.type = type;
		map = new HashMap<String, Object>();
	}

	public AgentMessageType getType() {
		return type;
	}

	public void setType(AgentMessageType type) {
		this.type = type;
	}

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}
	
	public void put(String key, Object value) {
		map.put(key, value);
	}

	@Override
	public String toString() {
		return "AgentMessage [type=" + type + ", map=" + map +", senderIp=" + this.getSenderHost() + "]";
	}
}
