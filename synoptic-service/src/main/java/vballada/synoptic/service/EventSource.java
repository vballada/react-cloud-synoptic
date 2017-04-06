package vballada.synoptic.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

import vballada.synoptic.domain.GenericSynopticEvent;
import vballada.synoptic.domain.SynopticEvent;

/**
 * @author BALLADA_V
 *         <p>
 *         The event source. By default, it sends one event per second
 *         </p>
 */
@EnableBinding(Source.class)
public class EventSource {

	/**
	 * Send a {@link SynopticEvent}
	 * 
	 * @return A new {@link SynopticEvent}
	 */
	@InboundChannelAdapter(Source.OUTPUT)
	public SynopticEvent sendEvent() {
		return new GenericSynopticEvent("Event " + System.currentTimeMillis());
	}
}
