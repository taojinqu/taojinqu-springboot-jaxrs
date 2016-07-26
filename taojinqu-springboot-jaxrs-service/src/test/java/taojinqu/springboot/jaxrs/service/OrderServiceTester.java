package taojinqu.springboot.jaxrs.service;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.util.collection.MultivaluedStringMap;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StartApp.class)
public class OrderServiceTester {

	@Test
	public void testGetOrderById() {
		Client client = ClientBuilder.newClient();
		Response res = client.target("http://127.0.0.1:8080/orderService/getOrderById?id=1003")
				.request(MediaType.APPLICATION_JSON).get();
		String message = res.readEntity(String.class);
		System.out.println(message);
	}

	@Test
	public void testGetOrderByCode() {
		Client client = ClientBuilder.newClient();
		Response res = client.target("http://127.0.0.1:8080/orderService/getOrderByCode/CO10020")
				.request(MediaType.APPLICATION_JSON).post(null);
		int status = res.getStatus();
		Assert.assertEquals(200, status);
		String message = res.readEntity(String.class);
		System.out.println(message);
	}

	@Test
	public void testSaveProduct() throws IOException {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target(URI.create(new URL("http://127.0.0.1:8080/orderService/saveProduct").toExternalForm()));

		WebTarget t = target.path("/1009").queryParam("name", "产品1009").queryParam("price", "11.23");
		String r = t.request().get(String.class);
		System.out.println(r);
	}

	/**
	 * post方式提交表单
	 * 
	 * @throws IOException
	 */
	@Test
	public void testSaveOrderForm() throws IOException {
		MultivaluedMap<String, String> store = new MultivaluedStringMap(10);
		store.putSingle("id", "1005");
		store.putSingle("code", "C1005");
		store.putSingle("platform", "LAZAD");
		Entity<Form> entity = Entity.form(store);

		Client client = ClientBuilder.newClient();
		Response res = client.target("http://127.0.0.1:8080/orderService/saveOrderForm").request().post(entity);
		int status = res.getStatus();
		Assert.assertEquals(200, status);
		String message = res.readEntity(String.class);
		System.out.println(message);
	}

	/**
	 * post方式提交表单
	 * 
	 * @throws IOException
	 */
	@Test
	public void saveOrderForm2() throws IOException {
		MultivaluedMap<String, String> store = new MultivaluedStringMap(10);
		store.putSingle("id", "1005");
		store.putSingle("code", "C1005");
		store.putSingle("platform", "LAZAD");
		Entity<Form> entity = Entity.form(store);

		Client client = ClientBuilder.newClient();
		Response res = client.target("http://127.0.0.1:8080/orderService/saveOrderForm2").request().post(entity);
		int status = res.getStatus();
		Assert.assertEquals(200, status);
		String message = res.readEntity(String.class);
		System.out.println(message);
	}
}
