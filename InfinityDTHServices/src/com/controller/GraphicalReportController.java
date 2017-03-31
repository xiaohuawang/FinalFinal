package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.Graph;
import com.service.GraphicalReportService;

/**
 * Servlet implementation class GraphicalReportController
 */
@WebServlet("/GraphicalReportController")
public class GraphicalReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	private final HashMap <String, String> graphNames = new HashMap <String, String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GraphicalReportController() {
        super();
        graphNames.put("piec", "Retailer-wise total count of Customers");
        graphNames.put("barc", "Month-wise total Customers created for last 12 months");
        
        graphNames.put("pieo", "Total number of Operators in each shift");
        graphNames.put("baro", "Month-wise total Operators created for last 12 months");
        
        graphNames.put("pier", "Total number of Retailers in each state");
        graphNames.put("barr", "Month-wise total Retailers created for last 12 months");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		if (!request.isUserInRole("admin"))
		{
			logger.info("Non admin user tried to generate report");
			return;
		}*/
		
		GraphicalReportService service = new GraphicalReportService();
		
		String input = request.getParameter("graphType");
		String type = input.substring(0, input.length()-1);
		String target = input.substring(input.length()-1, input.length());
		
		if (target.equals("c"))
		{
			target = "customer";
		}
		else if (target.equals("r"))
		{
			target = "retailer";
		}
		else if (target.equals("o"))
		{
			target = "operator";
		}
		else
		{
			logger.error("Unkown type of target has been passed in");
			return;
		}

		try 
		{
			ArrayList<Graph> data = service.getData(type, target);
			request.setAttribute("data", data);
			request.setAttribute("name", this.graphNames.get(input));
			request.setAttribute("type", type);
	        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/graphResult.jsp");
	        requestDispatcher.forward(request, response);
		} 
		catch (ClassNotFoundException e)
		{	
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
	}

}
