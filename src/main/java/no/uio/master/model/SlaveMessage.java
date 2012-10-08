package no.uio.master.model;

import java.io.Serializable;
import java.util.HashMap;

import no.uio.master.model.enumerator.SlaveMessageType;


public class SlaveMessage implements Serializable {
	private static final long serialVersionUID = 382125954042009372L;

	
	private SlaveMessageType type;
	private HashMap<String, Object> map;
	
	public SlaveMessage() {
		type = SlaveMessageType.INITIALIZATION;
		map = new HashMap<String, Object>();
	}
	
	public SlaveMessage(SlaveMessageType type) {
		this.type = type;
		map = new HashMap<String, Object>();
	}

	public SlaveMessageType getType() {
		return type;
	}

	public void setType(SlaveMessageType type) {
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
		return "SlaveMessage [type=" + type + ", map=" + map + "]";
	}
}
