package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Channel;
import com.dao.ChannelDao;
import com.dao.interfaces.IChannelDao;


public class ChannelService {

	IChannelDao dao = new ChannelDao();
	
	public Integer addChannel(Channel channel) throws SQLException, ClassNotFoundException {
		return dao.addChannel(channel);		
	}

	public List<Channel> getAllChannels() throws SQLException, ClassNotFoundException {
		return dao.getAllChannels();
	}

	public List<Channel> getChannelByName(String channelName) throws SQLException, ClassNotFoundException {
		return dao.getChannelByName(channelName);
	}

	public boolean removeChannelById(Integer channelId)throws SQLException, ClassNotFoundException {
		return dao.removeChannelById(channelId);
		
	}

	
		
		
}


