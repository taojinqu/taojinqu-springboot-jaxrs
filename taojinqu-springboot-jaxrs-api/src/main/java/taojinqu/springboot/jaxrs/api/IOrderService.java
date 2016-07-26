package taojinqu.springboot.jaxrs.api;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import taojinqu.springboot.jaxrs.api.vo.OrderItemVO;
import taojinqu.springboot.jaxrs.api.vo.ProductVO;

public interface IOrderService {

	// int saveOrder(@BeanParam @NotNull OrderItemVO order);
	Response saveProduct(@BeanParam ProductVO product);

	Response saveOrderForm(@FormParam("id") Long id, @FormParam("code") String code,
			@FormParam("platform") String platform);

	Response saveOrderForm2(@BeanParam OrderItemVO order);

	OrderItemVO getOrderById(@DefaultValue("1001") @QueryParam("id") @NotNull Long id);

	OrderItemVO getOrderByCode(@PathParam("code") @NotNull String code);

	public void parseData(@FormParam("data") List data);
}
