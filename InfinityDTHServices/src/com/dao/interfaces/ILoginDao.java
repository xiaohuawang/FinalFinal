package com.dao.interfaces;

import java.sql.SQLException;

import com.bean.User;

public interface ILoginDao {
	public User loginUser(User user) throws SQLException, ClassNotFoundException;
}
