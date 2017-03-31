package com.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bean.ChannelPackage;

public interface IChannelPackageDao {
	public Integer addChannelPackage(ChannelPackage channelPackage) throws SQLException, ClassNotFoundException;
	public ResultSet selectSQL(String sql) throws SQLException;
	public List<ChannelPackage> getAllChannelPackage() throws SQLException, ClassNotFoundException;
	public List<ChannelPackage> getChannelPackageByName(String channelPackageName) throws SQLException, ClassNotFoundException;
}
