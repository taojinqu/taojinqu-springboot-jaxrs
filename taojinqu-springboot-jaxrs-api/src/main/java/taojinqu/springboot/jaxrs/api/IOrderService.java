package taojinqu.springboot.jaxrs.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import taojinqu.springboot.jaxrs.api.vo.OrderItemVO;

public interface IOrderService {

	int saveOrder(@BeanParam @NotNull OrderItemVO order);

	OrderItemVO getOrderById(@DefaultValue("1001") @QueryParam("id") @NotNull Long id);

	OrderItemVO getOrderByCode(@PathParam("code") @NotNull String code);
}
