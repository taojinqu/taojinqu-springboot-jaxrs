package taojinqu.springboot.jaxrs.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import taojinqu.springboot.jaxrs.api.vo.OrderItemVO;

public interface IOrderService {

	// int saveOrder(@BeanParam @NotNull OrderItemVO order);
	Response saveOrder(@BeanParam OrderItemVO order);

	Response saveOrderForm(@FormParam("id") Long id, @FormParam("code") String code,
			@FormParam("platform") String platform);

	Response saveOrderForm2(@FormParam("order") OrderItemVO order);

	OrderItemVO getOrderById(@DefaultValue("1001") @QueryParam("id") @NotNull Long id);

	OrderItemVO getOrderByCode(@PathParam("code") @NotNull String code);
}
