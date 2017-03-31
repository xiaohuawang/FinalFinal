package com.dao;

import java.sql.SQLException;

import com.bean.Admin;
import com.bean.Customer;
import com.bean.Operator;
import com.bean.Retailer;
import com.bean.User;
import com.dao.interfaces.ILoginDao;
import com.util.DBConnection;

public class LoginDao extends GenericDao implements ILoginDao {

	@Override
	public User loginUser(User user) throws SQLException, ClassNotFoundException {
		con = DBConnection.getConnection();
		
		// Prepare SQL statement
		query = "select * from XUsers where username = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, user.getUsername());
		
		// Execute query
		rs = ps.executeQuery();
		
		if(rs.next()) {
			User loggedUser = null;
			Integer userRole = rs.getInt("roleId");

			switch (userRole) {
			case 1:
				loggedUser = new Admin();
				
				loggedUser.setUserId(rs.getInt(1));
				loggedUser.setUsername(rs.getString(2));
				loggedUser.setPassword(rs.getString(3));
				loggedUser.setRoleId(userRole);

				break;
			case 2:
				loggedUser = new Operator();
				
				loggedUser.setUserId(rs.getInt(1));
				loggedUser.setUsername(rs.getString(2));
				loggedUser.setPassword(rs.getString(3));
				loggedUser.setRoleId(userRole);
				break;
			case 3:
				user = new Retailer();
				break;
			case 4:
				loggedUser = new Customer();
				
				loggedUser.setUserId(rs.getInt(1));
				loggedUser.setUsername(rs.getString(2));
				loggedUser.setPassword(rs.getString(3));
				loggedUser.setRoleId(userRole);
				break;
			}
			
			if(user.getPassword().equals(loggedUser.getPassword())) {
				logger.info("RoleId: " + loggedUser.getRoleId() + " Username: " + loggedUser.getUsername() + " successfully logged in");
			} else {
				logger.info("Wrong username and password combination");
				return null;
			}
			
			return loggedUser;
		}

		return null;
	}

	

}
