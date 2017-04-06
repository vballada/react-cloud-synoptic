package vballada.synoptic.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author BALLADA_V
 *         <p>
 *         Web client receiving Spring Cloud Stream events and forwarding them
 *         to web client through websockets
 *         </p>
 */
@SpringBootApplication
public class SynopticClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SynopticClientApplication.class, args);
	}
}
