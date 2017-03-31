package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.ChannelPackage;
import com.dao.ChannelPackageDao;
import com.dao.interfaces.IChannelPackageDao;

public class ChannelPackageService {
	IChannelPackageDao dao = new ChannelPackageDao();
	
	public Integer addChannelPackage(ChannelPackage channelPackage) throws SQLException, ClassNotFoundException {
		return dao.addChannelPackage(channelPackage);
	}
	
	public List<ChannelPackage> getAllChannelPackage() throws SQLException, ClassNotFoundException {
		return dao.getAllChannelPackage();
	}
	
	public List<ChannelPackage> getChannelPackageByName(String channelPackagename) throws SQLException, ClassNotFoundException {
		return dao.getChannelPackageByName(channelPackagename);
	}
}
