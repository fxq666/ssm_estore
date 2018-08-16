package com.briup.estore.common.bean;

/**
 * 省份
 * @author ying
 *
 */
public class Province {
	private String id;
	private String province;
	private Integer contry;
	
	public Province() {

	}

	public Province(String id, String province, Integer contry) {
		this.id = id;
		this.province = province;
		this.contry = contry;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getContry() {
		return contry;
	}

	public void setCountry(Integer contry) {
		this.contry = contry;
	}
	
	
	
}
