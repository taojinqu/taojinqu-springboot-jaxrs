package taojinqu.springboot.jaxrs.service.api.impl;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("message")
	public String message() {
		return "Hello world";
	}

	@GET
	@Path("reverse")
	public String reverse(@QueryParam("input") @NotNull String input) {
		return new StringBuilder(input).reverse().toString();
	}
}
