package com.service;

import java.sql.SQLException;

import com.bean.User;
import com.dao.LoginDao;
import com.dao.interfaces.ILoginDao;

public class LoginService {
	ILoginDao dao = new LoginDao ();
	
	public User loginUser(User user) throws SQLException, ClassNotFoundException {
		return dao.loginUser(user);
	}
}
