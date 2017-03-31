package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.Channel;
import com.service.ChannelService;
import com.util.DBConnection;


@WebServlet("/channel")
public class ChannelController extends HttpServlet {
	
	private static final long serialVersionUID = -6425906346960789918L;
	private static final Logger logger = LogManager.getLogger(DBConnection.class);
	
	public ChannelController() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChannelService service = new ChannelService();
		Integer channelId;
		String action = request.getParameter("action");
		switch (action) {
		case "getAllChannels":
			try {
				List<Channel> channels = service.getAllChannels();
				
				request.setAttribute("channels", channels);
				request.setAttribute("source", action);
				
				request.getRequestDispatcher("viewChannels.jsp").forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				logger.error(e.getMessage());
			}
			break;
		case "getChannelByName":
			try {
				String channelName = request.getParameter("channelName");
				List<Channel> channels = service.getChannelByName(channelName);
				
				request.setAttribute("channels", channels);
				request.setAttribute("source", action);
				
				request.getRequestDispatcher("viewChannels.jsp").forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				logger.error(e.getMessage());
			}
			break;
		case "delete":
			try{
				channelId = Integer.parseInt(request.getParameter("id"));
				service.removeChannelById(channelId);
				
				String source = request.getParameter("source");
				
				if(source.equals("getAllChannels")) {
					List<Channel> channels = service.getAllChannels();
					
					request.setAttribute("channels", channels);
					request.setAttribute("source", source);
					
					logger.info("Delete from source: " + source);
					
					request.getRequestDispatcher("viewChannels.jsp").forward(request, response);
				} else if( source == "getChannelsByName") {
					String channelName = request.getParameter("channelName");
					List<Channel> channels = service.getChannelByName(channelName);
					
					request.setAttribute("channels", channels);
					request.setAttribute("source", source);
					
					logger.info("Delete from source: " + source);
					
					request.getRequestDispatcher("viewChannels.jsp").forward(request, response);
				}
			}catch (ClassNotFoundException | SQLException e) {
				logger.error(e.getMessage());
			}
		break;
		default:
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// create channel object to hold input form data locally
		Channel channel = new Channel();
		ChannelService service = new ChannelService();		
		
		// filling operator class variables from input form
		channel.setName(request.getParameter("channelName"));
		channel.setBand(request.getParameter("channelBand"));
		channel.setVideoCarrierFrequency((Double.parseDouble(request.getParameter("videoCarrierFreq"))));		
		channel.setAudioCarrierFrequency(Double.parseDouble((request.getParameter("audioCarrierFreq"))));
		
		String channelType = request.getParameter("channelChargeType");		
		boolean free;
		if(channelType == "FTA (Free to Air)")
		{
			free = true;
		}
		else
		{
			free = false;
		}
		channel.setChannelChargeTypeFree(free);
		
		String transmissionType = request.getParameter("channelTransType");
		boolean standard;
		if(transmissionType == "Standard")
		{
			standard = true;
		}
		else
		{
			standard = false;
		}
		channel.setChannelTransmissionTypeStandard(standard);		
		channel.setCharge(Double.parseDouble(request.getParameter("channelCharge")));	
		
		
		try {
			// service will add the sample to db
			Integer channelId = service.addChannel(channel);
			
			if(channelId == -1) {
				logger.error("ERROR ADDING OPERATOR");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// make sure to log error
			logger.error(e.getMessage());
		}

    }	
}
