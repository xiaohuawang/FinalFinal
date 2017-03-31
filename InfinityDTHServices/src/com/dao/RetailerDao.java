package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Operator;
import com.bean.Retailer;
import com.bean.User;
import com.dao.interfaces.IRetailerDao;
import com.util.DBConnection;

public class RetailerDao extends GenericDao implements IRetailerDao {
	@Override
	public Integer addRetailer(Retailer retailer) throws SQLException, ClassNotFoundException{
		Integer userId = addNewUser(retailer, User.RETAILER);
		
		// Add Address
		AddressDao addressDao = new AddressDao();
		Integer addressId = addressDao.addAddress(retailer.getAddress());
		logger.info("Back in add Retailer");
		/*
		 * RETAILERID		NUMBER(38,0)
			NAME			VARCHAR2(30 BYTE)
			CONTACTNO1		VARCHAR2(30 BYTE)
			CONTACTNO2		VARCHAR2(30 BYTE)
			ADDRESSID		NUMBER(38,0)
			STBL			VARCHAR2(30 BYTE)
			CREDITLIMIT		VARCHAR2(30 BYTE)
			CPSG			VARCHAR2(30 BYTE)
			SERVICECHARGE	VARCHAR2(30 BYTE)
			CREATIONDATE	DATE
			TCI				NUMBER
		 */
	
		String sql = "INSERT INTO RETAILER VALUES(?,?,?,?,?,?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		logger.info("after prepare statement");
		ps.setInt(1, userId);
		logger.info("after user id");
		ps.setString(2, retailer.getName());
		logger.info("after get name");
		ps.setString(3, retailer.getContactNo1());
		logger.info("after contact 1");
		ps.setString(4, retailer.getContactNo2());
		logger.info("after contact 2");
		ps.setInt(5, addressId);
		logger.info("after address id");
		ps.setString(6, retailer.getSetTopBoxLimit());
		logger.info("after get set top box");
		ps.setString(7, retailer.getCreditLimit());
		logger.info("after credit limit");
		ps.setString(8,  retailer.getCommissionPercentage());
		logger.info("after commission");
		ps.setString(9, retailer.getServiceCharges());
		logger.info("after service charges");
		
		// USE THIS TO CONVERT DATES FROM java.util.Date TO java.sql.Date
		java.sql.Date sqlDate = this.convertDate(retailer.getRetailerCreationDate());
		ps.setDate(10, sqlDate);
		logger.info("after set date");
		ps.executeUpdate();
		logger.info("after execute update");
		return userId;
	}
	@Override
	public List<Retailer> getRetailerByName(String name) throws SQLException, ClassNotFoundException {
		con = DBConnection.getConnection();
		List<Retailer> retailers = new ArrayList<>();
		
		try{
			ps = con.prepareStatement("Select * from retailer where name = ?");
			ps.setString(1, name);
		
			rs = ps.executeQuery();
		
			while(rs.next()){
				Retailer retailer = new Retailer();
				retailer.setUserId(rs.getInt("retailerId"));
				retailer.setName(rs.getString("name"));
				retailer.setContactNo1(rs.getString("contactNo1"));
				
				retailers.add(retailer);
			}
		}catch(SQLException e){
			logger.error(e.getMessage());
		}
		
		return retailers;
	}
	@Override
	public List<Retailer> getAllRetailers() {
		
		
		ArrayList<Retailer> retailers = new ArrayList<>();
	//	Address address=new Address();
		
		// Get connection
		con = DBConnection.getConnection();
		
		// Prepare SQL statement
		try {
			ps = con.prepareStatement("select * from Retailer");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Retailer retailer = new Retailer();
				
				retailer.setUserId(rs.getInt("retailerId"));
				retailer.setName(rs.getString("name"));
				retailer.setContactNo1(rs.getString("contactNo1"));
				retailer.setContactNo2(rs.getString("contactNo2"));
				retailer.setSetTopBoxLimit(rs.getString("stbl"));
				retailer.setCreditLimit(rs.getString("creditLimit"));
				retailer.setCommissionPercentage(rs.getString("cpsg"));
				retailer.setServiceCharges(rs.getString("serviceCharge"));
				retailer.setRetailerCreationDate(rs.getDate("CreationDate"));
			
//				address.setAddressId(Integer.parseInt(rs.getString("addressid")));
//				customer.getAddress().getAddress1()
			//	logger.info(retailer.getName());
				
				retailers.add(retailer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}

		// Execute SQL statement
		
		
		return retailers;
	}
	@Override
	public boolean removeRetailerById(Integer retailerId) throws SQLException,
			ClassNotFoundException {
		con = DBConnection.getConnection();
		
		try{	
			ps = con.prepareStatement("delete from retailer where retailerId = ?");
			ps.setInt(1, retailerId);
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	@Override
	public Retailer getRetailerById(Integer retailerId) throws SQLException,
			ClassNotFoundException {
		con = DBConnection.getConnection();
		Retailer retailer = new Retailer();
		
		try{	
			ps = con.prepareStatement("select * from retailer where retailerId = ?");
			ps.setInt(1, retailerId);
			rs = ps.executeQuery();
			while(rs.next()) {
	
				retailer.setUserId(rs.getInt("retailerId"));
				retailer.setName(rs.getString("name"));
				retailer.setContactNo1(rs.getString("contactNo1"));
				retailer.setContactNo2(rs.getString("contactNo2"));
				retailer.setSetTopBoxLimit(rs.getString("stbl"));
				retailer.setCreditLimit(rs.getString("creditLimit"));
				retailer.setCommissionPercentage(rs.getString("cpsg"));
				retailer.setServiceCharges(rs.getString("serviceCharge"));
				retailer.setRetailerCreationDate(rs.getDate("CreationDate"));
			
		}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return retailer;
	}
	@Override
	public boolean updateRetailerById(Retailer retailer1) throws SQLException,
			ClassNotFoundException {
		
		con = DBConnection.getConnection();
		
		try{	
			ps = con.prepareStatement("update retailer set name = ?, contactNo1=? where retailerId = ?");
			ps.setString(1,retailer1.getName());
			ps.setString(2,retailer1.getContactNo1());
			ps.setInt(3, retailer1.getUserId());
			ps.executeUpdate();
		

		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return true;
	}
}
