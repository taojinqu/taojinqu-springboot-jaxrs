重点参考文章：http://www.cnblogs.com/xinsheng/p/3897289.html

@BeanParam
https://jersey.java.net/documentation/latest/jaxrs-resources.html


https://qbgbook.gitbooks.io/spring-boot-reference-guide-zh/content/IV.%20Spring%20Boot%20features/26.2.%20JAX-RS%20and%20Jersey.html


/**
* 请求地址http://127.0.0.1:8080/orderService/getOrderByCode/CO10020
* 只能用post方式提交，不支持get提交
* 一个方法应该只有一个HTTP方法指示符（即一个方法只能是POST或者GET，不能同时制定POST、GET，否则请求报错）
* 使用@PathParam可以获取URI中指定规则的参数
* 注意，这里的code并不是说Key是code, value是CO10020
*	     而是说/getOrderByCode/后面跟着的内容就是code,这里code只是个变量
*    /getOrderByCode/后面的内容中不能有/（路径分隔符），否则请求找不到地址（404错误）
*
*/
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




/**
*
* @QueryParam用于获取GET请求中的查询参数
* http://127.0.0.1:8080/orderService/getOrderById?id=1002，id=1002，@DefaultValue是默认值；
* http://127.0.0.1:8080/orderService/getOrderById，没有传id参数时，取默认值
*
*/
@Override
@GET
@Path("/getOrderById")
@Produces({ MediaType.APPLICATION_JSON })
public OrderItemVO getOrderById(@DefaultValue("1001") @QueryParam("id") @NotNull Long id) {
	return data.get(id);
}


