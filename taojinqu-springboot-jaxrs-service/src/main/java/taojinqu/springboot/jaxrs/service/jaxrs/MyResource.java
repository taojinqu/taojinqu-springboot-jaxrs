package taojinqu.springboot.jaxrs.service.jaxrs;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/endpoint")
public class MyResource {
	@GET()
	@Path("getParams/{id1}/{id2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getParams(@BeanParam MyPathParams pathParams, @BeanParam MyQueryParams queryParams) {
		return "/" + pathParams.getId1() + "/" + pathParams.getId2() + "?param1=" + queryParams.getParam1() + "&param2="
				+ queryParams.getParam2() + "&param3=" + queryParams.getParam3();
	}
}
