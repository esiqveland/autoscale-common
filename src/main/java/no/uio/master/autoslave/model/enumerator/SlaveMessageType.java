package no.uio.master.autoslave.model.enumerator;

import java.io.Serializable;

public enum SlaveMessageType implements Serializable {
	INITIALIZATION,
	UPDATE,
	STOP_DAEMON;
}
