package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.User;
import com.util.DBConnection;

//GenericDao holds a few class fields to ease the create of DAO's
//Those fields are used to log errors, make connections to DB and
//write and execute SQL statements
public class GenericDao {
	protected static final Logger logger = LogManager.getLogger(GenericDao.class);

	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	protected Statement stmt = null;
	protected String query = null;

	protected Integer addNewUser(User user, Integer roleId) throws SQLException, ClassNotFoundException {
		con = DBConnection.getConnection();
		
		String newUser = "insert into XUsers values(XUsers_Sequences.nextVal, ?, ?, ?)";
		System.out.println(newUser);
		ps = con.prepareStatement(newUser);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setInt(3, roleId);
		
		ps.executeUpdate();
		
		query = "select XUsers_Sequences.currval from dual";
		System.out.println(query);
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		
		if(rs.next()) {
			Integer userId = rs.getInt(1);
			logger.info("UserId: " + userId);

			return userId;
		}
		
		return -1;
	}
	
	protected Date convertDate(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}
}
