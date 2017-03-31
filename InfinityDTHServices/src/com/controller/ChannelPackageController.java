package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.Channel;
import com.bean.ChannelPackage;
import com.service.ChannelPackageService;
import com.util.DBConnection;
import com.util.DateUtil;

/**
 * Servlet implementation class ChannelPackageController
 */
@WebServlet("/channel-package")
public class ChannelPackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(DBConnection.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChannelPackageController() {
        super(); 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// create operator object to hold input form data locally
		ChannelPackageService service = new ChannelPackageService();
		ChannelPackage cp = new ChannelPackage();
		
		
		
		// filling operator class variables from input form
		cp.setName(request.getParameter("packageName"));
		logger.info("after adding package name" + cp.getName());

		cp.setChargingType(request.getParameter("packageChargingType"));
		logger.info("after adding package charging type" + cp.getChargingType());
		cp.setPackageTransmissionType(request.getParameter("packageTransmissionType"));
		logger.info("after adding transmission type" + cp.getPackageTransmissionType());
		
		 ArrayList<Channel> channels = new ArrayList<>();
		 Channel channel;
		 
		 if(request.getParameter("standard") != null) {
			 channel = new Channel();
			 channel.setName("standard");
			 channels.add(channel);
		 }
		 if(request.getParameter("hd") != null) {
			 channel = new Channel();
			 channel.setName("hd");
			 channels.add(channel);		 
		 }
		 if(request.getParameter("hdRecorder") != null) {
			 channel = new Channel();
			 channel.setName("hdRecorder");
			 channels.add(channel);	
		 }
		 if(request.getParameter("iptv") != null) {
			 channel = new Channel();
			 channel.setName("iptv");
			 channels.add(channel);	
		 }
		 
     	 cp.setChannels(channels);		
//		 for(Channel c: channels){
//			 logger.info("channel " + c.getName());
//		 }
		//double
		//cp.setCost(Double.parseDouble(request.getParameter("channelPackageCost")));
		 cp.setCost(Double.parseDouble(request.getParameter("packageCost")));
		logger.info("after adding package cost " + cp.getCost());
		
		
		//date
        cp.setAvailableFromDate(DateUtil.convertStringToDate(request.getParameter("packageAvailableFromDate"), "MM-dd-yyyy"));
        logger.info("after adding Available  " + cp.getAvailableFromDate());
        cp.setAvailableToDate(DateUtil.convertStringToDate(request.getParameter("packageAvailableToDate"), "MM-dd-yyyy"));
        logger.info("after adding Available From  " + cp.getAvailableToDate());
        cp.setAddedByDefault(request.getParameter("addByDefault"));
        logger.info("after added by default " + cp.getAddedByDefault());
  		 
  		ArrayList<String> categories = new ArrayList<>();
		 
		 if(request.getParameter("sports") != null) {
			 categories.add("sports");
		 }
		 if(request.getParameter("news") != null) {
			 categories.add("news");
		 }
		 if(request.getParameter("kids") != null) {
			 categories.add("kids");
		 }
		 if(request.getParameter("nature") != null) {
			 categories.add("nature");
		 }
		 cp.setCategory(categories);
		 
//		 for(String s:categories){
//			 logger.info("categories " + s);
//		 }
		 
		try {
			// service will add the sample to db
			Integer userId = service.addChannelPackage(cp);
				
			if(userId == -1) {
				logger.error("ERROR ADDING OPERATOR");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
				
			request.setAttribute("package", cp.getName());
			request.getRequestDispatcher("viewChannelPackage.jsp").forward(request, response);
				
		} catch (ClassNotFoundException | SQLException e) {
				// make sure to log error
				logger.error(e.getMessage());
			}
  		
  	
		
	}

}
