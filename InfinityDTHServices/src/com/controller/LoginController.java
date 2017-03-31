package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.User;
import com.service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(LoginController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("logout")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
			    session.invalidate();

			    getServletContext().setAttribute("loginstatus", false);
			    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

			    return;
			}
		}
		
		// Get user from session
		User loggedUser = (User)getServletConfig().getServletContext().getAttribute("rememberedUser");
		
		if(loggedUser == null) {
			loggedUser = (User)request.getSession().getAttribute("loggedUser");
		}

		// Is user already logged in?
		if(loggedUser != null) {
			switch (loggedUser.getRoleId()) {
				case 1:
					response.sendRedirect("admin.jsp");
					return;
				case 2:
					response.sendRedirect("operatorHome.jsp");
					return;
				case 4:
					response.sendRedirect("customerHome.jsp");
					return;
	
				default:
					break;
			}
		}
		
		response.sendRedirect("signin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create service to perform CRUD operation
		LoginService service = new LoginService();
		
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
	
		try {
			User loggedUser = service.loginUser(user);
			
			if(loggedUser != null) {
				// Start new session and save user in that session
				HttpSession session = request.getSession(true);
				session.setAttribute("loggedUser", loggedUser);
				
				switch (loggedUser.getRoleId()) {
					case 1:
						getServletContext().setAttribute("loginstatus", true);						
					    getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
					    return;
					case 2:
						getServletContext().setAttribute("loginstatus", true);						
					    getServletContext().getRequestDispatcher("/operatorHome.jsp").forward(request, response);
					    return;
					case 4:
						getServletContext().setAttribute("loginstatus", true);						
					    getServletContext().getRequestDispatcher("/customerHome.jsp").forward(request, response);
					    return;
					default:
						break;
				}
			}
			
			getServletContext().setAttribute("loginerror", "Wrong username and/or password!");
			getServletContext().getRequestDispatcher("/signin.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(e.getMessage());
		}
	}

}
