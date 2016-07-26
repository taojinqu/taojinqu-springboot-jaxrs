package taojinqu.springboot.jaxrs.api.vo;

import java.io.Serializable;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class ProductVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4417878878689115710L;

	@PathParam("id")
	private Long id;

	@QueryParam("name")
	private String name;

	@QueryParam("price")
	private Float price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
