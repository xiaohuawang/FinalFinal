package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.Address;
import com.bean.Operator;
import com.bean.Retailer;
import com.service.RetailerService;
import com.util.DBConnection;
import com.util.DateUtil;

/**
 * Servlet implementation class RetailerController
 */
@WebServlet("/RetailerController")
public class RetailerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(DBConnection.class);  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetailerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RetailerService service = new RetailerService();
		Integer retailerId;
		String action = request.getParameter("action");
		switch(action){
			case "getAllRetailers":
				try{
					List<Retailer> retailer = service.getAllRetailers();
					
					
					request.setAttribute("retailers", retailer);
					request.setAttribute("source", action);
					
					request.getRequestDispatcher("viewRetailers.jsp").forward(request, response);
					
				}catch (ClassNotFoundException | SQLException e){
					logger.error(e.getMessage());
				}
				break;
			case "getRetailerByName":
				try{
					logger.info("start");
					String RetailerName = request.getParameter("name");
					List<Retailer> retailers = service.getRetailerByName(RetailerName);
					logger.info("middle");
					request.setAttribute("retailers", retailers);
					request.setAttribute("source", action);
					
					logger.info("end");
					request.getRequestDispatcher("viewRetailers.jsp").forward(request, response);
					logger.info("end");
					
				} catch (ClassNotFoundException | SQLException e){
					logger.error(e.getMessage());
				}
				break;
			case "delete":
				try{
					retailerId = Integer.parseInt(request.getParameter("id"));
					service.removeRetailerById(retailerId);
					
					String source = request.getParameter("source");
					System.out.println("source= "+source);
					if(source.equals("getAllRetailers")) {
						List<Retailer> retailers = service.getAllRetailers();
						
						request.setAttribute("retailers", retailers);
						request.setAttribute("source", source);
						
						logger.info("Delete from source: " + source);
						
						request.getRequestDispatcher("viewRetailers.jsp").forward(request, response);
					} 
					else if( source == "getRetailerByName") {
						String retailerName = request.getParameter("name");
						List<Retailer> retailers = service.getRetailerByName(retailerName);
						
						request.setAttribute("retailers", retailers);
						request.setAttribute("source", source);
						
						logger.info("Delete from source: " + source);
						
						request.getRequestDispatcher("viewRetailers.jsp").forward(request, response);
					}
				}catch (ClassNotFoundException | SQLException e) {
					logger.error(e.getMessage());
				}
				break;
			case "getRetailerById":
				try{
						retailerId = Integer.parseInt(request.getParameter("id"));
						Retailer retailer = service.getRetailerById(retailerId);

						request.setAttribute("retailers", retailer);
						//request.setAttribute("source", action);
						
						request.getRequestDispatcher("updateRetailer.jsp").forward(request, response);
						
					}
			catch(ClassNotFoundException | SQLException e) {
				logger.error(e.getMessage());
			}
			default:
		
				break;
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RetailerService service = new RetailerService();
		Retailer retailer = new Retailer();
		Integer retailerId;
		String action = request.getParameter("action");
		

		retailer.setName(request.getParameter("name"));
		
		retailer.setContactNo1(request.getParameter("contactNo1"));
		retailer.setContactNo2(request.getParameter("contactNo2"));
		retailer.setSetTopBoxLimit(request.getParameter("stbl"));
		retailer.setCreditLimit(request.getParameter("creditLimit"));
		retailer.setCommissionPercentage(request.getParameter("cpsg"));
		retailer.setServiceCharges(request.getParameter("serviceCharges"));
		retailer.setRetailerCreationDate(DateUtil.convertStringToDate(request.getParameter("retailerCreationDate"), "MM-dd-yyyy"));
		retailer.setUsername(request.getParameter("username"));
		retailer.setPassword(request.getParameter("password"));

		retailer.setName(request.getParameter("name"));
		retailer.setContactNo1(request.getParameter("contactNo1"));
		retailer.setContactNo2(request.getParameter("contactNo2"));
		retailer.setSetTopBoxLimit(request.getParameter("setTopBoxLimit"));
		retailer.setCreditLimit(request.getParameter("creditLimit"));
		retailer.setCommissionPercentage(request.getParameter("commissionPercentage"));
		retailer.setServiceCharges(request.getParameter("serviceCharges"));
		retailer.setRetailerCreationDate(DateUtil.convertStringToDate(request.getParameter("retailerCreationDate"), "MM-dd-yyyy"));
		retailer.setUsername(request.getParameter("username"));
		retailer.setPassword(request.getParameter("password"));

		switch(action){

		
		case"create":
			
			retailer.setName(request.getParameter("name"));
			retailer.setContactNo1(request.getParameter("contactNo1"));
			retailer.setContactNo2(request.getParameter("contactNo2"));
			retailer.setSetTopBoxLimit(request.getParameter("setTopBoxLimit"));
			retailer.setCreditLimit(request.getParameter("creditLimit"));
			retailer.setCommissionPercentage(request.getParameter("commissionPercentage"));
			retailer.setServiceCharges(request.getParameter("serviceCharges"));
			retailer.setRetailerCreationDate(DateUtil.convertStringToDate(request.getParameter("retailerCreationDate"), "MM-dd-yyyy"));
			retailer.setUsername(request.getParameter("username"));
			retailer.setPassword(request.getParameter("password"));
			
			Address address = new Address();
			address.setAddress1(request.getParameter("address1"));
			address.setAddress2(request.getParameter("address2"));
			address.setLandMark(request.getParameter("landMark"));
			address.setCity(request.getParameter("city"));
			address.setState(request.getParameter("state"));
			address.setPinCode(request.getParameter("zipcode"));
			
			retailer.setAddress(address);
		
			try {
				// service will add the retailer to db
				Integer userId = service.addRetailer(retailer);
				
				if(userId == -1) {
					logger.error("ERROR ADDING Retailer");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				logger.info("back in the controller !!!!!!!!!");
				response.sendRedirect("RetailerController?action=getAllRetailers");
				
			} catch (ClassNotFoundException | SQLException e) {
				// make sure to log error
					logger.error(e.getMessage());
			}
		break;
		
		case"update":
			try{
				logger.info("update from source");
				Retailer retailer1 = new Retailer();
				retailerId = Integer.parseInt(request.getParameter("id"));
				logger.info("update from source 1");
				retailer1.setUserId( retailerId);
				retailer1.setName(request.getParameter("name"));
				logger.info("update from source");
				retailer1.setContactNo1(request.getParameter("contactNo1"));		
				
				boolean status = service.updateRetailerById(retailer1);

				retailerId = Integer.parseInt(request.getParameter("id"));
				Retailer retailer11 = service.getRetailerById(retailerId);
				List<Retailer> retailers = new ArrayList<>();
				retailers.add(retailer11);
				request.setAttribute("retailers", retailers);
				logger.info("update from source: " + status);
				
				request.getRequestDispatcher("viewRetailers.jsp").forward(request, response);
				
			}
				catch(ClassNotFoundException | SQLException e) {
				logger.error(e.getMessage());
			}
			
		break;
		}


	}

}
