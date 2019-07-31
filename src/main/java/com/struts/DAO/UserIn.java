package com.struts.DAO;

import com.struts.model.User;

public interface UserIn {
	
	void registerUser(User user);
	boolean loginUser(User user);
	boolean forgetUser(User user);
	boolean resetUser(User user);

}
