package com.baidu.bean;

public class ConsultationInfo {
	private Integer id;
	private String street_name;
	private String fixed_telephone;
	private String mail_bo;
	private String postal_address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public String getFixed_telephone() {
		return fixed_telephone;
	}
	public void setFixed_telephone(String fixed_telephone) {
		this.fixed_telephone = fixed_telephone;
	}
	public String getMail_bo() {
		return mail_bo;
	}
	public void setMail_bo(String mail_bo) {
		this.mail_bo = mail_bo;
	}
	public String getPostal_address() {
		return postal_address;
	}
	public void setPostal_address(String postal_address) {
		this.postal_address = postal_address;
	}
	@Override
	public String toString() {
		return "ConsultationInfo [id=" + id + ", street_name=" + street_name
				+ ", fixed_telephone=" + fixed_telephone + ", mail_bo="
				+ mail_bo + ", postal_address=" + postal_address + "]";
	}
	public ConsultationInfo(Integer id, String street_name,
			String fixed_telephone, String mail_bo, String postal_address) {
		super();
		this.id = id;
		this.street_name = street_name;
		this.fixed_telephone = fixed_telephone;
		this.mail_bo = mail_bo;
		this.postal_address = postal_address;
	}
	public ConsultationInfo() {
		super();
	}
	
	
}
