package com.struts.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.struts.DAO.UserImpl;
import com.struts.model.User;

@Namespace(value = "/")
@Action(value="login",results={@Result(name="success",location="/login-success.jsp")
,@Result(name = "error",location = "/error.jsp")})
public class LoginAction {

	private String email;
	private String password;
	
	public LoginAction()
	{
		
	}

	/**
	 * @param email
	 * @param password
	 */
	public LoginAction(String email, String password) {
		
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute()
	{
		User user=new User();
		user.setEmail(getEmail());
		user.setPassword(getPassword());
		UserImpl userImpl=new UserImpl();
		if(userImpl.loginUser(user))
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}

	@Override
	public String toString() {
		return "LoginAction [email=" + email + ", password=" + password + "]";
	}
	
}
