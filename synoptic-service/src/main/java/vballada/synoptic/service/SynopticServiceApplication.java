package vballada.synoptic.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author BALLADA_V
 *         <p>
 *         Microservice generating events to test Spring Cloud Streaming
 *         capabilities
 *         </p>
 */
@SpringBootApplication
public class SynopticServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SynopticServiceApplication.class, args);
	}
}
