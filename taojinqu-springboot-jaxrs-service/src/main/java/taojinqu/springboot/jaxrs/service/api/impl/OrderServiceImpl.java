package taojinqu.springboot.jaxrs.service.api.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.validation.constraints.NotNull;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import taojinqu.springboot.jaxrs.api.IOrderService;
import taojinqu.springboot.jaxrs.api.vo.OrderItemVO;

@Component("orderService")
@Path("/orderService")
public class OrderServiceImpl implements IOrderService {
	public static Map<Long, OrderItemVO> data = new HashMap<Long, OrderItemVO>();
	static {
		OrderItemVO o1 = new OrderItemVO();
		o1.setId(1001L);
		o1.setCode("CO10010");
		o1.setPlatform("ALI");
		data.put(1001L, o1);

		OrderItemVO o2 = new OrderItemVO();
		o2.setId(1002L);
		o2.setCode("CO10020");
		o2.setPlatform("EBAY");
		data.put(1002L, o2);

		OrderItemVO o3 = new OrderItemVO();
		o3.setId(1003L);
		o3.setCode("CO10030");
		o3.setPlatform("WISH");
		data.put(1003L, o3);
	}

	// @Override
	// @POST
	// @Path("/saveOrder")
	// @Consumes({ MediaType.APPLICATION_JSON })
	// public int saveOrder(@BeanParam @NotNull OrderItemVO order) {
	// System.out.println(order);
	// data.put(order.getId(), order);
	// return 1;
	// }

	@Override
	@POST
	@Path("/saveOrder")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	public Response saveOrder(@BeanParam OrderItemVO order) {
		return Response.status(200).entity(String.format("saveOrder is called, %s", order)).build();
	}

	@Override
	@POST
	@Path("/saveOrderForm")
	public Response saveOrderForm(@FormParam("id") Long id, @FormParam("code") String code,
			@FormParam("platform") String platform) {
		return Response
				.ok(String.format("saveOrderForm is called, id : %s, code : %s, platform : %s", id, code, platform))
				.build();
	}

	@Override
	@POST
	@Path("/saveOrderForm2")
	public Response saveOrderForm2(@FormParam("order") OrderItemVO order) {
		return Response.status(200).entity(String.format("saveOrderForm is called, %s", order)).build();
	}

	@Override
	@GET
	@Path("/getOrderById")
	@Produces({ MediaType.APPLICATION_JSON })
	public OrderItemVO getOrderById(@DefaultValue("1001") @QueryParam("id") @NotNull Long id) {
		return data.get(id);
	}

	@Override
	@POST
	@Path("/getOrderByCode/{code}")
	@Produces({ MediaType.APPLICATION_JSON })
	public OrderItemVO getOrderByCode(@PathParam("code") @NotNull String code) {
		for (Entry<Long, OrderItemVO> entry : data.entrySet()) {
			OrderItemVO value = entry.getValue();
			if (code.equals(value.getCode())) {
				return value;
			}
		}
		return null;
	}
}
