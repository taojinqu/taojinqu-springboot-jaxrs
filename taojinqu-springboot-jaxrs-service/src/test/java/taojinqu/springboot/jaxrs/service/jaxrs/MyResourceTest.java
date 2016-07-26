package taojinqu.springboot.jaxrs.service.jaxrs;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import taojinqu.springboot.jaxrs.service.StartApp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StartApp.class)
public class MyResourceTest {

	private static WebTarget target;

	private URL base;

	@Before
	public void setUpClass() throws MalformedURLException {
		Client client = ClientBuilder.newClient();
		// target = client.target(URI.create(new URL(base,
		// "endpoint").toExternalForm()));
		target = client.target(URI.create(new URL("http://127.0.0.1:8080/myResource/getParams").toExternalForm()));
	}

	@Test
	public void testRequestWithAllParams() {
		WebTarget t = target.path("/123").path("/abc").queryParam("param1", "foo").queryParam("param2", "bar")
				.queryParam("param3", "baz");
		String r = t.request().get(String.class);
		System.out.println(r);
	}
}
