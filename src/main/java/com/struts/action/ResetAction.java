package com.struts.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.struts.DAO.UserImpl;
import com.struts.model.User;

@Namespace("/")
@Action(value = "reset", results = { @Result(name = "success", location = "/reset-success.jsp"),
		@Result(name = "error", location = "/error.jsp") })
public class ResetAction  {

	private String password;

	
	
	public ResetAction() {

	}

	/**
	 * @param password
	 */
	HttpSession session=ServletActionContext.getRequest().getSession(false);
	
	public ResetAction(String password) {

		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() {
		UserImpl userImpl = new UserImpl();
		User user = new User();
		user.setPassword(getPassword());
		String email=(String) session.getAttribute("email");
		System.out.println(email);
		user.setEmail(email);
		if (userImpl.resetUser(user)) {
			return "success";
		} else {
			return "error";
		}
	}
}
