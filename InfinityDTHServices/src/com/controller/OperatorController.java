package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.Operator;
import com.service.OperatorService;
import com.util.DBConnection;
import com.util.DateUtil;

/*
 * Controller Servlet Class to take Operator information from
 * Operator Registration page. First, storing it locally in an
 * Operator object. Finally, saving it to database for persistent
 * storage.
 * Class written by: Patrick Laflin 3/24/2017 
 */

@WebServlet("/operator")
public class OperatorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(DBConnection.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperatorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		OperatorService service = new OperatorService();
		Integer operatorId;
		String action = request.getParameter("action");
		switch (action) {
		case "getAllOperators":
			try {
				List<Operator> operators = service.getAllOperators();
				
				request.setAttribute("operators", operators);
				request.setAttribute("source", action);
				
				request.getRequestDispatcher("viewOperators.jsp").forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				logger.error(e.getMessage());
			}
			break;
		case "getOperatorByName":
			try {
				String operatorName = request.getParameter("operatorName");
				List<Operator> operators = service.getOperatorByName(operatorName);
				
				request.setAttribute("operators", operators);
				request.setAttribute("source", action);
				
				request.getRequestDispatcher("viewOperators.jsp").forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				logger.error(e.getMessage());
			}
			break;
		case "delete":
			try{
				operatorId = Integer.parseInt(request.getParameter("id"));
				service.removeOperatorById(operatorId);
				
				String source = request.getParameter("source");
				System.out.println("source= "+source);
				if(source.equals("getAllOperators")) {
					List<Operator> operators = service.getAllOperators();
					
					request.setAttribute("operators", operators);
					request.setAttribute("source", source);
					
					logger.info("Delete from source: " + source);
					
					request.getRequestDispatcher("viewOperators.jsp").forward(request, response);
				} else if( source == "getOperatorsByName") {
					String operatorName = request.getParameter("operatorName");
					List<Operator> operators = service.getOperatorByName(operatorName);
					
					request.setAttribute("operators", operators);
					request.setAttribute("source", source);
					
					logger.info("Delete from source: " + source);
					
					request.getRequestDispatcher("viewOperators.jsp").forward(request, response);
				}
			}catch (ClassNotFoundException | SQLException e) {
				logger.error(e.getMessage());
			}
			break;
		case "getOperatorById":
			try{
					operatorId = Integer.parseInt(request.getParameter("id"));
					Operator operator = service.getOperatorById(operatorId);

					request.setAttribute("operators", operator);
					//request.setAttribute("source", action);
					
					request.getRequestDispatcher("updateOperator.jsp").forward(request, response);
					
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
		// create operator object to hold input form data locally
		Operator operator = new Operator();
		OperatorService service = new OperatorService();	
		Integer operatorId;
		String action = request.getParameter("action");
		
		switch (action) {
			
		case"create":
			// filling operator class variables from input form
			operator.setEmailAddress(request.getParameter("emailAddress"));
			operator.setFirstName(request.getParameter("firstName"));
			operator.setLastName(request.getParameter("lastName"));		
			operator.setMaxNoCustomers(Integer.parseInt((request.getParameter("maxNoCustomers"))));
			operator.setPhoneNumber(request.getParameter("phoneNumber"));
			operator.setCreationDate(DateUtil.convertStringToDate(request.getParameter("creationDate"), "MM-dd-yyyy") );
			operator.setPassword(request.getParameter("password"));
			operator.setUsername(request.getParameter("username"));
			
			DateFormat sdf = new SimpleDateFormat("hh:mm:ss"); 
			
			//logger.info(operator.getFirstName());
			
			// try catch to try and parse the start time input from operator form
			try {
				Date startTime = sdf.parse(request.getParameter("shiftTimeStart"));
				operator.setShiftTimeStart(startTime);			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // End try-catch block for start time
			
			// try catch to try and parse the end time input from operator form
			try {
				Date endTime = sdf.parse(request.getParameter("shiftTimeEnd"));
				operator.setShiftTimeEnd(endTime);
				logger.info("shift time end"+operator.getShiftTimeEnd());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // End try-catch block for end time
			
			// TODO: FIND OUT HOW TO GET THIS FROM DATABASE
			//operator.setTotalNoActiveCustomers(Integer.parseInt(request.getParameter("totalNoActiveCustomers")));
			
					
			try {
				// service will add the sample to db
				Integer userId = service.addOperator(operator);
				
				if(userId == -1) {
					logger.error("ERROR ADDING OPERATOR");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				
				response.sendRedirect("operator?action=getAllOperators");
				
			} catch (ClassNotFoundException | SQLException e) {
				// make sure to log error
				logger.error(e.getMessage());
			}
			break;
		case"update":{
			try{
				logger.info("update from source");
				Operator operator1 = new Operator();
				operatorId = Integer.parseInt(request.getParameter("id"));
				logger.info("update from source 1");
				operator1.setUserId( operatorId);
				operator1.setPhoneNumber(request.getParameter("phoneNumber"));
				logger.info("update from source");
				operator1.setFirstName(request.getParameter("firstName"));
				operator1.setLastName(request.getParameter("lastName"));		
				
				boolean status = service.updateOperatorById(operator1);

				operatorId = Integer.parseInt(request.getParameter("id"));
				Operator operator11 = service.getOperatorById(operatorId);
				List<Operator> operators = new ArrayList<>();
				operators.add(operator11);
				request.setAttribute("operators", operators);
				logger.info("update from source: " + status);
				
				request.getRequestDispatcher("viewOperators.jsp").forward(request, response);
				
			}
				catch(ClassNotFoundException | SQLException e) {
				logger.error(e.getMessage());
			}
			
		}
		default:
			break;
		
		}
		
	}

}
