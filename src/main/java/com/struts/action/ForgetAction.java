package com.struts.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.struts.DAO.UserImpl;
import com.struts.model.User;

@Namespace("/")
@Action(value="forget",results={@Result(name="success",location="/forget-success.jsp")
,@Result(name = "error",location = "/error.jsp")})
public class ForgetAction implements SessionAware {

	private String email;
	 private Map<String, Object> sessionMap;
	
	public ForgetAction()
	{
		
	}

	/**
	 * @param email
	 */
	public ForgetAction(String email) {
		
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String execute()
	{
		System.out.println("dsflkjafs;lakj");
		User user=new User();
		user.setEmail(getEmail());
		UserImpl userImpl=new UserImpl();
		if(userImpl.forgetUser(user))
		{
			
			sessionMap.put("email", email);
			return "success";
		}
		else
		{
			return "error";
		}
	}

	public void setSession(Map<String, Object> session) {
		this.sessionMap=session;
	}

	
}
