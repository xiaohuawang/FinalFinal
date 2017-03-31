package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Operator;
import com.bean.User;
import com.dao.interfaces.IOperatorDao;
import com.util.DBConnection;

public class OperatorDao extends GenericDao implements IOperatorDao {
	
	@Override
	public Integer addOperator(Operator operator) throws SQLException, ClassNotFoundException {
		
		Integer userId = addNewUser(operator, User.OPERATOR);

		String sql= "INSERT INTO OPERATOR VALUES(?,?,?,?,?,?,?,?,?)";
		// (USERID,FIRSTNAME,LASTNAME,EMAILID,PHONENUMBER,SHIFTTIMESTART, SHIFTTIMEEND, MAXNOCUSTOMERS, CREATIONDATE)

		ps = con.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setString(2,operator.getFirstName());
		ps.setString(3,operator.getLastName());
		ps.setString(4,operator.getEmailAddress());
		ps.setString(5,operator.getPhoneNumber());
		
	    java.sql.Date sqlDate = this.convertDate(operator.getShiftTimeStart());
		ps.setDate(6,sqlDate);
		
	    java.sql.Date sqlDate2 = this.convertDate(operator.getShiftTimeEnd());
		ps.setDate(7,sqlDate2);
		
		ps.setInt(8,operator.getMaxNoCustomers());
		
	    java.sql.Date sqlDate3 = this.convertDate(operator.getCreationDate());
		ps.setDate(9,sqlDate3);
		
		ps.executeUpdate();
		
		return userId;
	}
	
	@Override
	public ArrayList<Operator> getAllOperators() {
		ArrayList<Operator> operators = new ArrayList<>();		
		
		// Get connection
		con = DBConnection.getConnection();
		
		// Prepare SQL statement
		try {
			ps = con.prepareStatement("select * from Operator");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Operator operator = new Operator();
				
				operator.setUserId(rs.getInt("operatorId"));
				operator.setFirstName(rs.getString("firstName"));
				operator.setLastName(rs.getString("lastName"));
				operator.setEmailAddress(rs.getString("emailId"));
				operator.setPhoneNumber(rs.getString("phoneNumber"));
				operator.setShiftTimeStart(rs.getDate("shiftTimeStart"));
				operator.setShiftTimeEnd(rs.getDate("shiftTimeEnd"));
				operator.setMaxNoCustomers(rs.getInt("maxCustomer"));
				operator.setCreationDate(rs.getDate("creationDate"));

				operators.add(operator);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

		return operators;
	}

	@Override
	public List<Operator> getOperatorByName(String operatorName)
			throws SQLException, ClassNotFoundException {
		
		ArrayList<Operator> operators = new ArrayList<>();		
		
		con = DBConnection.getConnection();
		
		try {
			ps = con.prepareStatement("select * from Operator where firstname = ?");
			ps.setString(1, operatorName);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Operator operator = new Operator();
				
				operator.setUserId(rs.getInt("operatorId"));
				operator.setFirstName(rs.getString("firstName"));
				operator.setLastName(rs.getString("lastName"));
				operator.setEmailAddress(rs.getString("emailId"));
				operator.setPhoneNumber(rs.getString("phoneNumber"));
				operator.setShiftTimeStart(rs.getDate("shiftTimeStart"));
				operator.setShiftTimeEnd(rs.getDate("shiftTimeEnd"));
				operator.setMaxNoCustomers(rs.getInt("maxCustomer"));
				operator.setCreationDate(rs.getDate("creationDate"));

				operators.add(operator);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return operators;
	}

	@Override
	public boolean removeOperatorById(Integer operatorId)
			throws SQLException, ClassNotFoundException {
		con = DBConnection.getConnection();
	
		try{	
			ps = con.prepareStatement("delete from Operator where operatorId = ?");
			ps.setInt(1, operatorId);
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	@Override
	public Operator getOperatorById(Integer operatorId) throws SQLException,
			ClassNotFoundException {
		con = DBConnection.getConnection();
		Operator operator = new Operator();
		
		try{	
			ps = con.prepareStatement("select * from Operator where operatorId = ?");
			ps.setInt(1, operatorId);
			rs = ps.executeQuery();
			while(rs.next()) {
	
				operator.setUserId(rs.getInt("operatorId"));
				operator.setFirstName(rs.getString("firstName"));
				operator.setLastName(rs.getString("lastName"));
				operator.setEmailAddress(rs.getString("emailId"));
				operator.setPhoneNumber(rs.getString("phoneNumber"));
				operator.setShiftTimeStart(rs.getDate("shiftTimeStart"));
				operator.setShiftTimeEnd(rs.getDate("shiftTimeEnd"));
				operator.setMaxNoCustomers(rs.getInt("maxCustomer"));
				operator.setCreationDate(rs.getDate("creationDate"));

			
		}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return operator;
	}

	@Override
	public boolean updateOperatorById(Operator operator) throws SQLException,
			ClassNotFoundException {
			
		con = DBConnection.getConnection();
	
		try{	
			ps = con.prepareStatement("update Operator set firstname = ?, lastname=?,phonenumber=?  where operatorId = ?");
			ps.setString(1,operator.getFirstName());
			ps.setString(2,operator.getLastName());
			ps.setString(3,operator.getPhoneNumber());
			ps.setInt(4, operator.getUserId());
			ps.executeUpdate();
		

		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return true;
	}
}