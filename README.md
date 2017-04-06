# react-cloud-synoptic
This project is a proof of concept testing the Spring Cloud Stream capabilites combined with WebSockets to push real time information from a microservice to a web client application.
This is the early stage to build a real time dashboard (synoptic) where events are pushed from the microservice to the front-end.

ReactJS will be used for the front-end part.

## synoptic-service
This Spring Boot microservice hosts the source sending events through the streams binded thanks to Spring Cloud Stream:

```java

@InboundChannelAdapter(Source.OUTPUT)
public SynopticEvent sendEvent() {
	return new GenericSynopticEvent("Event " + System.currentTimeMillis());
}

```

## synoptic-client
This is the client part, it receives the event on the inbound channel, and forwards it to a STOMP WebSocket: 

```java

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

```

## Running the demo
* First, you will need a kafka broker running somewhere, for instance in a docker container:
```

$ docker run -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=localhost --env ADVERTISED_PORT=9092 spotify/kafka

```
* Launch the SynopticServiceApplication (running on port 8090),

* Launch the SynopticClientApplication (running on port 8080).

* You can see the streamed events at http://localhost:8080

## Running the demo within Docker
You can deploy an image for synoptic-client and synoptic-service as Dockerfiles are provided, and then thanks to the docker-compose.yml file launch the following within your Docker engine:

```

docker-compose up

```

