package no.uio.master.autoscale.message.enumerator;


public enum AgentMessageType {
	
	/**
	 * Initialize (and startup Cassandra if not currently running).
	 */
	STARTUP_NODE,
	
	/**
	 * Update configuration-values.
	 */
	UPDATE,
	
	/**
	 * Stop agent 
	 */
	STOP_AGENT,
	
	/**
	 * Start agent
	 */
	START_AGENT,
	
	/**
	 * Decomission node, and shut down Cassandra-process
	 */
	SHUTDOWN_NODE;
}
