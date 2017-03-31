package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.SampleBean;
import com.service.SampleService;
import com.util.DBConnection;
import com.util.DateUtil;

/**
 * Servlet implementation class SampleController
 */
@WebServlet("/sample")
public class SampleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LogManager.getLogger(DBConnection.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create service to perform CRUD operation
		SampleService service = new SampleService();
		
		String action = request.getParameter("action");
		switch (action) {
		case "getAllSamples":
			try {
				// Attempt to get all Samples
				List<SampleBean> samples = service.getAllSamples();
				
				if(samples == null) {
					logger.error("No Samples found");
				}
				
				request.setAttribute("sampleList", samples);
				request.getRequestDispatcher("viewSamples.jsp").forward(request, response);
				
				for(SampleBean sample : samples) {
					logger.info(sample.toString());
				}
			} catch (ClassNotFoundException | SQLException e) {
				logger.error(e.getMessage());
			}
			break;
		case "getSampleByName":
			try {
				// Attempt to get Sample with parameter "name" passed from JSP
				SampleBean sample = service.getSampleByName(request.getParameter("sampleName"));
				
				if(sample == null) {
					logger.error("No Sample with such name");
				}
				
				logger.info(sample.toString());
				
			} catch (ClassNotFoundException | SQLException e) {
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
		// Create service to perform CRUD operation
		SampleService service = new SampleService();
		
		// Store data from form into the bean
		SampleBean sample = new SampleBean();
		sample.setSampleName(request.getParameter("sampleName"));
		
		// USE THIS TO CONVERT DATE (MM-dd-yyyy) TO java.util.date
		String date = request.getParameter("sampleDate");
		
		logger.info(request.getParameter("sampleDate"));
		
		Date newDate = DateUtil.convertStringToDate(date, DateUtil.FORMAT);
		
		sample.setSampleDate(newDate);
		
		try {
			// service will invoke CRUD operation
			service.addSample(sample);
			
			response.sendRedirect("index.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// Feed errors to logger
			logger.error(e.getMessage());
		}
	}
}
