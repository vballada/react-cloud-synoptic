package vballada.synoptic.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import vballada.synoptic.domain.SynopticEvent;

/**
 * @author BALLADA_V
 *         <p>
 *         Sinking the event and forwarding it to the client with a websocket
 *         </p>
 */
@EnableBinding(Sink.class)
public class SynopticEventSink {

	/**
	 * Websocket Messaging Template
	 */
	private final SimpMessagingTemplate websocket;

	/**
	 * @param websocket
	 *            Autowired Websocket Messaging Template
	 */
	@Autowired
	public SynopticEventSink(SimpMessagingTemplate websocket) {
		this.websocket = websocket;
	}

	/**
	 * Receive an event and forwarding to a web client with a websocket
	 * 
	 * @param event
	 *            The receveid event from the synoptic-service source
	 */
	@StreamListener(Sink.INPUT)
	public void receive(SynopticEvent event) {
		System.out.println("Receive "+event);
		websocket.convertAndSend("/topic/synop", event);
	}
}
