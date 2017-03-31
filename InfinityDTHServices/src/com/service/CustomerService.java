package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Customer;
import com.dao.CustomerDao;
import com.dao.interfaces.ICustomerDao;

public class CustomerService {
	ICustomerDao dao = new CustomerDao();
	
	public Integer addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		return dao.addCustomer(customer);
	}
	
	public List<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {
		return dao.getAllCustomer();
	}
	
	public List<Customer> getCustomerByName(String customerName) throws SQLException, ClassNotFoundException {
		return dao.getCustomerByName(customerName);
	}
}
