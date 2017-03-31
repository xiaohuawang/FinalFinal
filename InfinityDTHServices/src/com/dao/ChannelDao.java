package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Channel;
import com.util.DBConnection;
import com.dao.interfaces.IChannelDao;

public class ChannelDao extends GenericDao implements IChannelDao{

	public Integer addChannel(Channel channel) throws SQLException, ClassNotFoundException {
		Integer channelId = 0; 
		
		// Get connection
		con = DBConnection.getConnection();
		
		logger.info("BEGINNING");

		String sql = "INSERT INTO CHANNELS VALUES(Channels_Sequences.nextval,?,?,?,?,?,?,?)";
		// (CHANNELSID, CHANNELNAME, VIDEOFREQUENCY, AUDIOFREQUENCY, CHARGETYPE, TRANSMISSIONTYPE, CHARGE)
		
		ps = con.prepareStatement(sql);				
		ps.setString(1,channel.getName());	
		logger.info("after name");
		ps.setString(2,channel.getBand());
		logger.info("after band");
		ps.setDouble(3, channel.getVideoCarrierFrequency());
		logger.info("after video freq");
		ps.setDouble(4, channel.getAudioCarrierFrequency());
		logger.info("after audio freq");
		
		//Convert Boolean Flag to String for storage
		if(channel.isChannelChargeTypeFree() == true)
		    ps.setString(5, "FTA");
		else
			ps.setString(5, "Paid");
		logger.info("after charge type");
		
		//Convert Boolean Flag to String for storage
		if(channel.isChannelTransmissionTypeStandard() == true)
			ps.setString(6, "Standard");
		else
			ps.setString(6, "HD");
		logger.info("after transmission type");
		
		ps.setDouble(7, channel.getCharge());
		logger.info("after charge");
		ps.executeUpdate();
		
		logger.info("END");
		
		
		query = "select Channels_Sequences.currval from dual";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			channelId = rs.getInt(1);
			return channelId;
		}
		
		return -1;
    }

	@Override
	public List<Channel> getAllChannels() {
        ArrayList<Channel> channels = new ArrayList<>();		
		
		// Get connection
		con = DBConnection.getConnection();
		
		// Prepare SQL statement
		try {
			ps = con.prepareStatement("select * from Channels");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Channel channel = new Channel();
				
				channel.setChannelId(rs.getInt("channelId"));
				channel.setName(rs.getString("channelName"));
				channel.setBand(rs.getString("band"));
				channel.setVideoCarrierFrequency(rs.getDouble("videoFrequencey"));
				channel.setAudioCarrierFrequency(rs.getDouble("audioFrequencey"));
				if(rs.getString("chargeType") == "FTA")
					channel.setChannelChargeTypeFree(true);
				else
					channel.setChannelChargeTypeFree(false);
				if(rs.getString("transmissionType") == "Standard")
					channel.setChannelTransmissionTypeStandard(true);
				else
					channel.setChannelTransmissionTypeStandard(false);
				channel.setCharge(rs.getDouble("charge"));

				channels.add(channel);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

		return channels;
	}

	@Override
	public List<Channel> getChannelByName(String channelName) {
        ArrayList<Channel> channels = new ArrayList<>();		
		
		con = DBConnection.getConnection();
		
		try {
			ps = con.prepareStatement("select * from Channels where channelName = ?");
			ps.setString(1, channelName);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Channel channel = new Channel();
				
				channel.setChannelId(rs.getInt("channelsId"));
				channel.setName(rs.getString("channelName"));
				channel.setBand(rs.getString("band"));
				channel.setVideoCarrierFrequency(rs.getDouble("videoFrequencey"));
				channel.setAudioCarrierFrequency(rs.getDouble("audioFrequencey"));
				
				if(rs.getString("chargeType") == "FTA")
					channel.setChannelChargeTypeFree(true);
				else
					channel.setChannelChargeTypeFree(false);
				
				if(rs.getString("transmissionType") == "Standard")
					channel.setChannelTransmissionTypeStandard(true);
				else
					channel.setChannelTransmissionTypeStandard(false);
				
				channel.setCharge(rs.getDouble("charge"));

				channels.add(channel);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return channels;
	}

	@Override
	public boolean removeChannelById(Integer channelId) {
		con = DBConnection.getConnection();
		
		try{	
			ps = con.prepareStatement("delete from Channels where channelsId = ?");
			ps.setInt(1, channelId);
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return false;
	}
}

