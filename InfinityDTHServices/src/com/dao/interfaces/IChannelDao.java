package com.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.bean.Channel;

public interface IChannelDao {

	public abstract Integer addChannel(Channel channel) throws SQLException, ClassNotFoundException;

	public abstract List<Channel> getAllChannels();

	public abstract List<Channel> getChannelByName(String channelName);

	public abstract boolean removeChannelById(Integer channelId);

	
}
