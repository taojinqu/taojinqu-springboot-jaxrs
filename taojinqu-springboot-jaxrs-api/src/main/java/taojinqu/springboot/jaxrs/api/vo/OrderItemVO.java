package taojinqu.springboot.jaxrs.api.vo;

import java.io.Serializable;

public class OrderItemVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4798848911205156588L;

	private Long id;

	private String code;

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
