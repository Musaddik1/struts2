package com.struts.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;


import com.struts.DAO.UserImpl;
import com.struts.model.User;

@Namespace("/")
@Action(value="register",results={@Result(name="success",location="/register-success.jsp")})
public class RegisterAction {

	private String name;
	private String email;
	private String password;
	private String phoneNumber;
	

	public String execute()
	{
		System.out.println("regg");
		User user=new User(name, email, password, phoneNumber);
		UserImpl userImpl=new UserImpl();
		userImpl.registerUser(user);
		return "success";
	}
	public RegisterAction()
	{
		
	}

	/**
	 * @param name
	 * @param email
	 * @param password
	 * @param phoneNumber
	 */
	public RegisterAction(String name, String email, String password, String phoneNumber) {
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
