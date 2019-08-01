package com.struts.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.struts.DAO.UserImpl;
import com.struts.model.User;

@Namespace("/")
@Action(value="register",results={@Result(name="success",location="/register-success.jsp")})
public class RegisterAction implements SessionAware {

	private String name;
	private String email;
	private String password;
	private String phoneNumber;
	

	 private Map<String,Object> session;
	 
	    public void setSession(Map<String,Object> session){ 
	        this.session = session;
	    }

	
	public String execute()
	{
		System.out.println("regg");
		User user=new User(name, email, password, phoneNumber);
		UserImpl userImpl=new UserImpl();
		userImpl.registerUser(user);
		String email=(String) session.get("email");
		System.out.println(email);
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
