package com.baidu.bean;

public class User {
	private Integer id;
	private String user_name;
	private String user_state;
	private String user_pwd;
	private Integer enterprise_id;
	private EnterpriseInfo enterpriseInfo;
	
	public EnterpriseInfo getEnterpriseInfo() {
		return enterpriseInfo;
	}
	public void setEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
		this.enterpriseInfo = enterpriseInfo;
	}
	
	public User() {
		super();
	}
	
	public User(Integer id, String user_name, String user_state,
			String user_pwd, Integer enterprise_id,
			EnterpriseInfo enterpriseInfo) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_state = user_state;
		this.user_pwd = user_pwd;
		this.enterprise_id = enterprise_id;
		this.enterpriseInfo = enterpriseInfo;
	}
	public User(Integer id, String user_name, String user_state,
			String user_pwd, Integer enterprise_id) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_state = user_state;
		this.user_pwd = user_pwd;
		this.enterprise_id = enterprise_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public Integer getEnterprise_id() {
		return enterprise_id;
	}
	public void setEnterprise_id(Integer enterprise_id) {
		this.enterprise_id = enterprise_id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", user_state="
				+ user_state + ", user_pwd=" + user_pwd + ", enterprise_id="
				+ enterprise_id + ", enterpriseInfo=" + enterpriseInfo + "]";
	}
	
}
