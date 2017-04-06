package vballada.synoptic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import vballada.synoptic.domain.SynopticEvent;

/**
 * @author BALLADA_V
 *         <p>
 *         The event sender
 *         </p>
 */
@Component
public class EventSender {

	/**
	 * The streaming source
	 */
	private Source source;

	/**
	 * Autowiring the source created by Spring Boot
	 * 
	 * @param source The source created by Spring Boot
	 */
	@Autowired
	public EventSender(Source source) {
		this.source = source;
	}

	/**
	 * Sending events
	 * 
	 * @param event
	 *            The event to send
	 */
	public void sendEvent(SynopticEvent event) {
		source.output().send(MessageBuilder.withPayload(event).build());
	}
}
