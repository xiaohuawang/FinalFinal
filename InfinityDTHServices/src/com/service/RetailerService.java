package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Retailer;
import com.dao.RetailerDao;
import com.dao.interfaces.IRetailerDao;

public class RetailerService {

	IRetailerDao dao = new RetailerDao();
	
	public Integer addRetailer(Retailer retailer) throws SQLException, ClassNotFoundException {
		return dao.addRetailer(retailer);
	
}
	public List<Retailer> getAllRetailers() throws SQLException, ClassNotFoundException {
		return dao.getAllRetailers();
	}
	
	public List<Retailer> getRetailerByName(String name) throws SQLException, ClassNotFoundException {
		return dao.getRetailerByName(name);
	}
	public boolean removeRetailerById(Integer retailerId) throws SQLException, ClassNotFoundException {
		return dao.removeRetailerById(retailerId);
		
	}
	public Retailer getRetailerById(Integer retailerId) throws SQLException, ClassNotFoundException {
		return dao.getRetailerById(retailerId);
	}
	public boolean updateRetailerById(Retailer retailer1) throws SQLException, ClassNotFoundException {
		return dao.updateRetailerById(retailer1);
	}
}

	