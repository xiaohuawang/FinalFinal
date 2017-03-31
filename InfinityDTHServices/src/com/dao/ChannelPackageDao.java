package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.bean.Address;
import com.bean.ChannelPackage;
import com.bean.Customer;
import com.bean.User;
import com.dao.interfaces.IChannelPackageDao;
import com.util.DBConnection;


public class ChannelPackageDao extends GenericDao implements IChannelPackageDao{

	@Override
	public Integer addChannelPackage(ChannelPackage channelPackage)
			throws SQLException, ClassNotFoundException {
		
		// Get connection
		con = DBConnection.getConnection();
		String sql= "INSERT INTO ChannelsPackage VALUES(ChannelsPackage_Sequences.nextVal,?,?,?,?,?,?,?,?)";
		ps = con.prepareStatement(sql);

		ps.setString(1,channelPackage.getCategory().get(0));
		
		ps.setString(2,channelPackage.getChargingType());
		
		ps.setString(3,channelPackage.getPackageTransmissionType());
	
		ps.setString(4,( channelPackage.getChannels()).get(0).getName());
	
		ps.setDouble(5,channelPackage.getCost());
	
		
		 java.sql.Date sqlDate = this.convertDate(channelPackage.getAvailableFromDate());
		 ps.setDate(6,sqlDate);
		
		 java.sql.Date sqlDate1 = this.convertDate(channelPackage.getAvailableToDate());
		 ps.setDate(7,sqlDate1);
		
		 ps.setString(8, channelPackage.getAddedByDefault());
		 
		
		int status = ps.executeUpdate();
		
		return status;
	}

	@Override
	public ResultSet selectSQL(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChannelPackage> getAllChannelPackage() throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChannelPackage> getChannelPackageByName(
			String channelPackageName) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
