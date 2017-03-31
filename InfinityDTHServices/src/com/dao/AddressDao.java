package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Address;
import com.util.DBConnection;

public class AddressDao extends GenericDao {

	public ResultSet selectSQL(String sql) {

		ResultSet result = null;
		Connection conn = null;

		try {
			conn = DBConnection.getConnection();
			PreparedStatement preStatement = conn.prepareStatement(sql);
			result = preStatement.executeQuery();
		} catch (SQLException e) {
			e.getMessage();
//			logger.error(e.getMessage());
		}

		return result;
	}

	public Integer addAddress(Address address) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO ADDRESS VALUES(ADDRESS_SEQUENCE.NEXTVAL,?,?,?,?,?,?)";
		System.out.println(sql);
		
		con = DBConnection.getConnectionTest();

		// String sql="INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?)";

		// (USERID,FIRSTNAME,LASTNAME,EMAILID,PHONENUMBER,ADDRESSID)
		System.out.println(sql);
		
		ps = con.prepareStatement(sql);
		ps.setString(1, address.getAddress1());
		ps.setString(2, address.getAddress2());
		ps.setString(3, address.getLandMark());
		ps.setString(4, address.getPinCode());
		ps.setString(5,address.getCity());
		ps.setString(6,address.getState());
		
		ps.executeUpdate();
		
		// GET ADDRESS ID
		query = "select ADDRESS_SEQUENCE.currval from dual";
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		
		if(rs.next()) {
			Integer addressId = rs.getInt(1);
			logger.info("AddressId: " + addressId);
			return addressId;
		}

		DBConnection.CloseConnection(con);

		return -1;
	}
	
	public Address getAddressById(int addressId){
		
		Address address=new Address();
		String sql="select * from Address where addressid ="+addressId;
		System.out.println(sql);
		try {
			con = DBConnection.getConnectionTest();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				address.setAddress1(rs.getString("address1"));
				address.setAddress2(rs.getString("address2"));
				address.setLandMark(rs.getString("landmark"));
				address.setPinCode(rs.getString("pincode"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("get end");
		return address;
	}
}
