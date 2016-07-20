package taojinqu.springboot.jaxrs.service.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		registerEndpoints();
	}

	private void registerEndpoints() {
		packages("taojinqu.springboot.jaxrs.service.api.impl");
		// register(HelloWorldService.class);
	}
}
