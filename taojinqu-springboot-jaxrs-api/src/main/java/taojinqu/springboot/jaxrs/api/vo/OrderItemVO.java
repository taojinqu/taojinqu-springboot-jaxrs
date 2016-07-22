package taojinqu.springboot.jaxrs.api.vo;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class OrderItemVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4798848911205156588L;

	@FormParam("id")
	private Long id;

	@FormParam("code")
	private String code;

	@FormParam("platform")
	private String platform;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Override
	public String toString() {
		return "OrderItemVO [id=" + id + ", code=" + code + ", platform=" + platform + "]";
	}
}
