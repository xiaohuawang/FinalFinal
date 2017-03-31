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
import com.bean.Customer;
import com.bean.User;
import com.dao.AddressDao;
import com.dao.CustomerDao;
import com.service.CustomerService;
import com.util.DateUtil;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LogManager.getLogger(CustomerController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerService service = new CustomerService();
		String action = request.getParameter("action");
		String customerIdStr;
		String customerNameStr;
		Integer customerId;
		CustomerDao customerdao=new CustomerDao();
		Customer customer=new Customer();
		
//		request.setAttribute("operators", operators);
//		request.setAttribute("source", action);
		

		switch (action) {
		case "getAllCustomers":
			try {
				
				request.setAttribute("source", action);
				List<Customer> customers = service.getAllCustomer();
				System.out.println("size= "+customers.size());
				
				System.out.println("get all customer");
				
				request.setAttribute("customers", customers);
				request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				logger.error(e.getMessage());
			}
			break;
		case "getCustomerByName":
			try {
				request.setAttribute("source", action);
				
				logger.info("getCustomerByName: " + request.getParameter("customerName"));
				
				customerNameStr = request.getParameter("customerName");

				List<Customer> customers = service.getCustomerByName(customerNameStr);
				
				System.out.println("size= "+customers.size());
				
				request.setAttribute("customerName", customerNameStr);
				request.setAttribute("customers", customers);
				
				System.out.println("get customer by name");
				request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				logger.error(e.getMessage());
			}
			break;
		case "update":
			
			customerIdStr = request.getParameter("id");
			customerId=Integer.parseInt(customerIdStr);
			Address address=new Address();
			AddressDao addressdao=new AddressDao();
			User user=new User();
			// List<Customer> customers =
			// service.getCustomerByName(customerName);

			customer = customerdao.getCustomerById(customerIdStr);
			int addressId=customer.getAddressId();
			address =addressdao.getAddressById(addressId);
			user=customerdao.getUserById(customerIdStr);
			
			System.out.println("firstname= "+customer.getFirstName());
			System.out.println("address1= "+address.getAddress1());
			
			request.setAttribute("customer", customer);
			request.setAttribute("address", address);
			request.setAttribute("user", user);

			request.getRequestDispatcher("customer.jsp").forward(request, response);
			customerdao.deleteCustomer(customerId);
			logger.info("CustomerID: " + customerIdStr);
			break;
		
//		not use
		case "updateAfter":
			
			customerIdStr = request.getParameter("id");
			System.out.println("customerstr= "+customerIdStr);
//			customerId=Integer.parseInt(customerIdStr);
//			customerdao.deleteCustomer(customerId);
			
			
			break;
			
		case "delete":
			
			
			List<Customer> customers;
			
			String source = request.getParameter("source");
			System.out.println("source= "+source);
			customerIdStr = request.getParameter("id");
			customerId=Integer.parseInt(customerIdStr);
			System.out.println("customerid="+customerId);
			
			if(source.equals("getAllCustomers")){
				try {
					customerdao.deleteCustomer(customerId);
					customers = service.getAllCustomer();
					request.setAttribute("source", source);
					request.setAttribute("customers", customers);
					request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(source.equals("getCustomerByName")){
				
				try {
					customerdao.deleteCustomer(customerId);
					System.out.println(request.getParameter("name"));
					String customerName=request.getParameter("name");
					request.setAttribute("source", source);
					customers = service.getCustomerByName(customerName);
					request.setAttribute("customers", customers);
					request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);
					return;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
//			customerdao.updateCustomer(customer, customerId);

//			List<Customer> customers=customerdao.getCustomerByName(customerName);
			
//			logger.info("CustomerID: " + customerId);
//			logger.info("CustomerID: " + customerId);			
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService service = new CustomerService();
		CustomerDao customerdao=new CustomerDao();
		Customer customer=new Customer();
		Address address=new Address();
		
		String action = request.getParameter("action");
		System.out.println("dopost action"+ action);
		
		String firstNameStr=request.getParameter("firstName");
		String lastNameStr=request.getParameter("lastName");
		String emailIdStr=request.getParameter("emailId");
		String phoneNumberStr=request.getParameter("phoneNumber");
		String address1Str=	request.getParameter("address1");
		String address2Str=	request.getParameter("address2");
		
		String landMarkStr=request.getParameter("landMark");
		String pinCodeStr=request.getParameter("pinCode");
		String cityStr=request.getParameter("city");
		String stateStr=request.getParameter("state");
		String userNameStr=request.getParameter("userName");
		String passwordStr=request.getParameter("password");
		String dateStr=request.getParameter("date");
		
		System.out.println("address1Str= "+address1Str);
		System.out.println("address2Str= "+address2Str);
		System.out.println("landmark= "+landMarkStr);
		System.out.println("pincode= "+pinCodeStr);
		System.out.println("cityStr= "+cityStr);
		System.out.println("stateStr= "+stateStr);
		System.out.println("dateStr= "+dateStr);
		
//		customer.setUserId(1);
		customer.setFirstName(firstNameStr);
		customer.setLastName(lastNameStr);
		customer.setEmailAddress(emailIdStr);
		customer.setPhoneNumber(phoneNumberStr);
		customer.setUsername(userNameStr);
		customer.setPassword(passwordStr);
		customer.setCustomerCreationDate(DateUtil.convertStringToDate(dateStr, "MM-dd-yyyy"));
//		customer.setAddress(address);
		
		System.out.println("firstname =" + firstNameStr);
		System.out.println("lastName= " + lastNameStr);
		System.out.println("email= " + emailIdStr);
		System.out.println("phone= " + phoneNumberStr);
//		System.out.println("address= " + customer.getAddress().getAddressId());
		
		address.setCity(cityStr);
		address.setLandMark(landMarkStr);
		address.setPinCode(pinCodeStr);
		address.setState(stateStr);
		address.setAddress1(address1Str);
		
		address.setAddress2(address2Str);
		//
		
		customer.setAddress(address);
		
		try{
			Integer customerId = service.addCustomer(customer);
			
			if(customerId == -1) {
				//TODO: HandleError
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		List<Customer> customers=customerdao.getAllCustomer();
//		request.setAttribute("customers", customers);
//		request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);
//		request.getRequestDispatcher("viewCustomer.jsp").forward(request, response);

		switch(action){
			case "insert":
				System.out.println("we come to insert");
				request.getRequestDispatcher("customerHome.jsp").forward(request, response);
				break;
			case "updateupdate":
				
				System.out.println("we come to update");
//				String userIdStr=request.getParameter("customerid");
//				System.out.println("userid= "+userIdStr);
//				customer=customerdao.getCustomerById(userIdStr);
//				List<Customer> customers=new ArrayList<Customer>();
//				customers.add(customer);
//				request.setAttribute("customers", customers);

//				request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);
				request.getRequestDispatcher("searchCustomer.jsp").forward(request, response);

				break;
		}	
		
	}

}