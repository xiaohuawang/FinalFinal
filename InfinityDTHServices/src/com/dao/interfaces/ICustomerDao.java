package com.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bean.Customer;

public interface ICustomerDao {
	public Integer addCustomer(Customer customer) throws SQLException, ClassNotFoundException;
	public ResultSet selectSQL(String sql) throws SQLException;
	public List<Customer> getAllCustomer() throws SQLException, ClassNotFoundException;
	public List<Customer> getCustomerByName(String customerName) throws SQLException, ClassNotFoundException;
}
