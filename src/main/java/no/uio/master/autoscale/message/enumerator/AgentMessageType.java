package no.uio.master.autoscale.message.enumerator;


public enum AgentMessageType {
	
	/**
	 * Initialize node.<br>
	 * Update configurations from message<br>
	 * Start agent.
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
	 * Decomission node, and shut down system-process
	 */
	SHUTDOWN_NODE,
	
	/**
	 * Get status for given criteria .<br>
	 * @see Status-enumerator must be sent together with the message
	 * {@link no.uio.master.autoscale.message.enumerator.AgentStatus}
	 */
	STATUS,
	
	/**
	 * A breach occurred
	 */
	BREACH_MESSAGE;
}
