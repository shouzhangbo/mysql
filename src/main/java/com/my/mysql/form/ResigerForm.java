package com.my.mysql.form;

import org.hibernate.validator.constraints.NotEmpty;

public class ResigerForm extends BaseForm{

	@NotEmpty(message = "用户名不能为空！", groups = {resigerForm.class,isResigerForm.class,loginForm.class})
	private String userName;
	@NotEmpty(message = "密码不能为空！", groups = {resigerForm.class,loginForm.class})
	private String baseUserPsd;
	@NotEmpty(message = "用户id不能为空！", groups = {perfectRegister.class})
	private Integer userId;
	@NotEmpty(message = "用户手机号不能为空！", groups = {perfectRegister.class})
	private String userMobile;
	@NotEmpty(message = "邮件地址不能为空！", groups = {perfectRegister.class})
	private String userEmail;
	
	
	private String addressStreet;
	private String addressInfo;
	private String receivePhone;
	private String receiveMan;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBaseUserPsd() {
		return baseUserPsd;
	}
	public void setBaseUserPsd(String baseUserPsd) {
		this.baseUserPsd = baseUserPsd;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
