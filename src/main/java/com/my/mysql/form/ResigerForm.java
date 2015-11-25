package com.my.mysql.form;

import org.hibernate.validator.constraints.NotEmpty;

public class ResigerForm extends BaseForm{

	@NotEmpty(message = "用户名不能为空！", groups = {resigerForm.class})
	private String userName;
	@NotEmpty(message = "密码不能为空！", groups = {resigerForm.class})
	private String baseUserPsd;
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
}
