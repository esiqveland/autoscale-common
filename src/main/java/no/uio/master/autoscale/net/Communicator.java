package no.uio.master.autoscale.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import no.uio.master.autoscale.util.CommunicatorObjectBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common communicator for Autoscale and Autoscale-slave
 * @author andreas
 */
public class Communicator {
	private static Logger LOG = LoggerFactory.getLogger(Communicator.class);
	private static ObjectOutputStream outputStream;
	private static ObjectInputStream inputStream;
	
	private static Socket socket;
	private static ServerSocket serverSocket;
	
	private Integer input_port;
	private Integer output_port;
	
	/**
	 * Initialize the communicator. Define incoming and outgoing ports.
	 * @param input_port
	 * @param output_port
	 */
	public Communicator(Integer input_port, Integer output_port) {
		this.input_port = input_port;
		this.output_port = output_port;
	}
	
	/**
	 * Initialize a socket-connection against <tt>host:output_port</tt>
	 * @param host
	 * @param port
	 */
	private void initializeSocket(String host) {
		LOG.debug("Initialize socket ["+host+":"+output_port+"]");
		try {
			this.socket = new Socket(host,output_port);
		} catch (IOException e) {
			LOG.error("Failed to init connection with " + host, e);
		}
	}

	/**
	 * Initialize a server-socket listening for incoming connections 
	 * at <tt>input_port</tt>
	 * @param port
	 */
	private void initializeServerSocket() {
        LOG.debug("Initialize serversocket listening at port [" + input_port + "]");
        try {
            this.serverSocket = new ServerSocket(input_port);
        } catch (IOException e) {
            LOG.error("Failed to initialize server-socket ", e);
        }
    }

    /**
	 * Start listening for <tt>incoming_port</tt>, and waits for incoming messages
	 * @return
	 */
	public CommunicatorObjectBundle readMessage() {
		initServerSocketIfNotActive();
		CommunicatorObjectBundle obj = new CommunicatorObjectBundle();

		try {
			LOG.debug("Waiting for incoming connections...");
			socket = serverSocket.accept();
			if(null != socket) {
				inputStream = new ObjectInputStream(socket.getInputStream());
				obj.setMessage(inputStream.readObject());
				obj.setSenderIp(socket.getInetAddress().getHostAddress());
				
			} else {
				LOG.error("Could not initialize socket.");
			}
		} catch (Exception e) {
            LOG.error("Failed to read message ", e);
        } finally {
			try {
				if(null != inputStream) {
					inputStream.close();
				}
				
				if(null != serverSocket) {
					serverSocket.close();
				}
				
				if(null != socket) {
					socket.close();
				}
			} catch (IOException e) {
                LOG.error("Failed to close input stream and/or server socket ", e);
            }
        }
		
		return obj;
	}
	
	/**
	 * Sends <tt>obj</tt> with socket.
	 * @param obj
	 */
	public void sendMessage(String host, Object obj) {
		LOG.debug("Sending message");
		initSocketIfNotActive(host);
		
		try {
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.writeObject(obj);
			outputStream.flush();
			LOG.debug("Message sent: {}",obj);
		} catch (Exception e) {
            LOG.error("Failed to send message", e);
        } finally {
			try {
				outputStream.close();
				socket.close();
			} catch (Exception e) {
				LOG.error("Failed to close output-stream");
			}
		}
	}
	
	/**
	 * Initialize a socket for the provided <tt>host</tt> if socket isn't active
	 * @param host
	 */
	public void initSocketIfNotActive(String host) {
		if(null == socket || socket.isClosed()) {
			initializeSocket(host);
		}
	}
	
	/**
	 * Initialize serverSocket if socket isn't active
	 */
	public void initServerSocketIfNotActive() {
		if(null == serverSocket || serverSocket.isClosed()) {
			initializeServerSocket();
		}
	}
}
